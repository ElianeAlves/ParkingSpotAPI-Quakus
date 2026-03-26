package org.eliane.parking_control.controllers;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eliane.parking_control.dtos.ParkingSpotRequestDTO;
import org.eliane.parking_control.dtos.ParkingSpotResponseDTO;
import org.eliane.parking_control.models.ParkingSpot;
import org.eliane.parking_control.services.ParkingSpotService;

import java.util.List;
import java.util.UUID;

@Path("/parking-spot")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ParkingSpotController {

    @Inject
    private ParkingSpotService parkingSpotService;

    @GET
    public Response getParkingSpot() {
        List<ParkingSpotResponseDTO> parkingSpotList = parkingSpotService.getParkingSpot();
        return Response.ok(parkingSpotList).build();
    }

    @GET
    @Path("/{id}")
    public Response getParkingSpotById(@PathParam("id") UUID uuid) {
        ParkingSpotResponseDTO parkingSpot = parkingSpotService.getParkingSpotByID(uuid);
        return Response.ok(parkingSpot).build();
    }

    @POST
    @Transactional
    public Response postParkingSpot(@Valid ParkingSpotRequestDTO request) {
        parkingSpotService.postParkingSpot(request);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteParkingSpotByID(@PathParam("id") UUID uuid) {
        boolean deleted = parkingSpotService.deleteParkingSpotByID(uuid);

        if (!deleted) {
            throw new NotFoundException("Parking spot not found");
        }

        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response putParkingSpot(@PathParam(value = "id") UUID uuid, ParkingSpot parkingSpotBody) {
        ParkingSpot parkingSpot = parkingSpotService.putParkingSpot(uuid, parkingSpotBody);
        return Response.ok(parkingSpot).build();
    }
}