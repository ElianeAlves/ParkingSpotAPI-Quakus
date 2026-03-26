package org.eliane.parking_control.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.eliane.parking_control.models.ParkingSpot;

import java.util.UUID;

@ApplicationScoped
public class ParkingSpotRepository implements PanacheRepositoryBase<ParkingSpot, UUID> {
}
