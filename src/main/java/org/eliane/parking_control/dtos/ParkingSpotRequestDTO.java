package org.eliane.parking_control.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.eliane.parking_control.models.ParkingSpot;

@Data
public class ParkingSpotRequestDTO {

    @NotBlank
    private String apartment;

    @NotBlank
    private String block;

    @NotBlank
    private String brandCar;

    @NotBlank
    private String colorCar;

    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;

    @NotBlank
    private String modelCar;

    @NotBlank
    private String parkingSpotNumber;

    @NotBlank
    private String responsibleName;

    public ParkingSpot toEntity() {
        ParkingSpot entity = new ParkingSpot();

        updateEntity(entity);

        return entity;
    }

    public void updateEntity(ParkingSpot entity) {
        entity.setApartment(this.apartment);
        entity.setBlock(this.block);
        entity.setBrandCar(this.brandCar);
        entity.setColorCar(this.colorCar);
        entity.setLicensePlateCar(this.licensePlateCar);
        entity.setModelCar(this.modelCar);
        entity.setParkingSpotNumber(this.parkingSpotNumber);
        entity.setResponsibleName(this.responsibleName);
    }
}
