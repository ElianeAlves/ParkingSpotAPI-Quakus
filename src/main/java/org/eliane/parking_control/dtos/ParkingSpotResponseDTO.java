package org.eliane.parking_control.dtos;

import org.eliane.parking_control.models.ParkingSpot;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingSpotResponseDTO {

    public UUID id;
    public String apartment;
    public String block;
    public String brandCar;
    public String colorCar;
    public String licensePlateCar;
    public String modelCar;
    public String parkingSpotNumber;
    public String responsibleName;
    public LocalDateTime registrationDate;

    public static ParkingSpotResponseDTO paraDTO(ParkingSpot entity) {
        ParkingSpotResponseDTO dto = new ParkingSpotResponseDTO();

        dto.id = entity.getId();
        dto.apartment = entity.getApartment();
        dto.block = entity.getBlock();
        dto.brandCar = entity.getBrandCar();
        dto.colorCar = entity.getColorCar();
        dto.licensePlateCar = entity.getLicensePlateCar();
        dto.modelCar = entity.getModelCar();
        dto.parkingSpotNumber = entity.getParkingSpotNumber();
        dto.registrationDate = entity.getRegistrationDate();
        dto.responsibleName = entity.getResponsibleName();

        return dto;
    }
}
