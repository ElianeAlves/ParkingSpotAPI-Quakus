package org.eliane.parking_control.controllers;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eliane.parking_control.models.ParkingSpot;
import org.eliane.parking_control.repositories.ParkingSpotRepository;
import org.eliane.parking_control.services.ParkingSpotService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Path("/parking-spot")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParkingSpotController {

    @Inject
    private ParkingSpotService parkingSpotService;

    @Inject
    private ParkingSpotRepository parkingSpotRepository;

    @GET
    public Response getParkingSpot() {
        List<ParkingSpot> parkingSpotList = parkingSpotService.getParkingSpot();
        return Response.ok(parkingSpotList).build();
    }

    @GET
    @Path("/{id}")
    public Response getParkingSpotById(@PathParam("id") UUID id) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(id);
        return Response.ok(parkingSpot).build();
    }

    @POST
    @Transactional
    public Response postParkingSpot(@Valid ParkingSpot parkingSpot) {
        parkingSpot.setRegistrationDate(LocalDateTime.now());
        parkingSpotRepository.persist(parkingSpot);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteParkingSpot(@PathParam("id") UUID id) {
        boolean deleted = parkingSpotRepository.deleteById(id);

        if (!deleted) {
            throw new NotFoundException("Parking spot not found");
        }

        return Response.noContent().build(); // 204
    }
}