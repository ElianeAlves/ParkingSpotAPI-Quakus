package org.eliane.parking_control.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eliane.parking_control.dtos.ParkingSpotRequestDTO;
import org.eliane.parking_control.dtos.ParkingSpotResponseDTO;
import org.eliane.parking_control.models.ParkingSpot;
import org.eliane.parking_control.repositories.ParkingSpotRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ParkingSpotService {

    @Inject
    private ParkingSpotRepository parkingSpotRepository;

    public List<ParkingSpotResponseDTO> getParkingSpot() {
        return parkingSpotRepository.listAll().stream().map(ParkingSpotResponseDTO::paraDTO).toList();
    }

    public ParkingSpotResponseDTO getParkingSpotByID(UUID uuid) {
        var entity = parkingSpotRepository.findById(uuid);
        if(entity == null) {
            throw new NotFoundException("Vaga de estacionamento não encontrada.");
        }
        return ParkingSpotResponseDTO.paraDTO(entity);
    }

    public ParkingSpotResponseDTO postParkingSpot(ParkingSpotRequestDTO request) {
        ParkingSpot entity = request.toEntity();
        entity.setRegistrationDate(LocalDateTime.now());
        parkingSpotRepository.persist(entity);
        return ParkingSpotResponseDTO.paraDTO(entity);
    }

    public boolean deleteParkingSpotByID(UUID uuid) {
        return parkingSpotRepository.deleteById(uuid);
    }

    public ParkingSpot putParkingSpot(UUID id, ParkingSpotRequestDTO dto) {
        ParkingSpot entity = parkingSpotRepository.findById(id);

        if (entity == null) {
            throw new NotFoundException();
        }

        dto.updateEntity(entity);
        entity.setRegistrationDate(LocalDateTime.now());

        return entity;
    }
}
