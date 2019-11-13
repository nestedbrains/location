package com.ovi.location.controllers;

import com.ovi.location.entities.Location;
import com.ovi.location.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LocationController {

    private final
    LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @PostMapping("/locationSave")
    public String saveLocation(
            @ModelAttribute("location") Location location,
            RedirectAttributes redirectAttributes
    ) {
        Location result = locationService.saveLocation(location);
        String msg = "Location is saved with " + result.getId();
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/displayLocations";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(
            ModelMap modelMap,
            @ModelAttribute("msg") String message) {
        if(message!=null){
            modelMap.addAttribute("msg", message);
        }
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displaylocations";
    }

    @RequestMapping("/deleteLocations")
    public String deleteLocations(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displaylocations";
    }

    @RequestMapping("/updateLocation")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = locationService.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @RequestMapping(value = "/updateLoc", method = RequestMethod.POST)
    public String updateLoc(@ModelAttribute("location") Location location, ModelMap modelMap) {
        locationService.updateLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

}
