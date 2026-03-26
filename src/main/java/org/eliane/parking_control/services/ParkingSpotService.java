package org.eliane.parking_control.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eliane.parking_control.models.ParkingSpot;
import org.eliane.parking_control.repositories.ParkingSpotRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ParkingSpotService {

    @Inject
    private ParkingSpotRepository parkingSpotRepository;

    public List<ParkingSpot> getParkingSpot() {
        return parkingSpotRepository.listAll();
    }

    public ParkingSpot getParkingSpotByID(UUID uuid) {
        return parkingSpotRepository.findById(uuid);
    }

    public void postParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setRegistrationDate(LocalDateTime.now());
        parkingSpotRepository.persist(parkingSpot);
    }

    public boolean deleteParkingSpotByID(UUID uuid) {
        return parkingSpotRepository.deleteById(uuid);
    }

    public ParkingSpot putParkingSpot(UUID uuid, ParkingSpot parkingSpotBody) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(uuid);

        parkingSpot.setApartment(parkingSpotBody.getApartment());
        parkingSpot.setBlock(parkingSpotBody.getBlock());
        parkingSpot.setBrandCar(parkingSpotBody.getBrandCar());
        parkingSpot.setColorCar(parkingSpotBody.getColorCar());
        parkingSpot.setLicensePlateCar(parkingSpotBody.getLicensePlateCar());
        parkingSpot.setParkingSpotNumber(parkingSpotBody.getParkingSpotNumber());
        parkingSpot.setRegistrationDate(LocalDateTime.now());
        parkingSpot.setResponsibleName(parkingSpotBody.getResponsibleName());

        return parkingSpot;
    }
}
