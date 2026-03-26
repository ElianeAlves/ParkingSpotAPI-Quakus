package org.eliane.parking_control.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eliane.parking_control.models.ParkingSpot;
import org.eliane.parking_control.repositories.ParkingSpotRepository;

import java.util.List;

@ApplicationScoped
public class ParkingSpotService {

    @Inject
    private ParkingSpotRepository parkingSpotRepository;

    public List<ParkingSpot> getParkingSpot() {
        return parkingSpotRepository.listAll();
    }
}
