package com.ovi.location.repos;

import com.ovi.location.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location ,Integer> {
}
