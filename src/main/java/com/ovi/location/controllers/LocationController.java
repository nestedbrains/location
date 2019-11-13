package com.ovi.location.controllers;

import com.ovi.location.entities.Location;
import com.ovi.location.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/locationSave")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location result = locationService.saveLocation(location);
        String msg = "Location is saved with " + result.getId();
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/updateLocation")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = locationService.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLoc(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location result = locationService.updateLocation(location);
        String msg = "Location is saved with " + result.getId() + "updates";
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("msg", msg);
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

}
