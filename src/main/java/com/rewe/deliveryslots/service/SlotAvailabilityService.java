package com.rewe.deliveryslots.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SlotAvailabilityService {

    private final SlotRepository repository;
    
        public SlotAvailabilityService(SlotRepository repository) {
            this.repository = repository;
        }


    // adjusted 1
    private boolean isUsable1(Slot slot) {
        return slot.getRemainingCapacity() > 0;
    }

    // adjusted 2
    private boolean isUsable2(Slot slot) {
        return slot.getRemainingCapacity() > 0;
    }

    // adjusted 4
    private boolean isUsable4(Slot slot) {
        return slot.getRemainingCapacity() > 0;
    }

    public List<Slot> collectDeliveryAreaFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot); // guarded 25
            }
        }
        return result;
    }

    public List<Slot> findDay(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> calculateHoliday(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    /**
     * Map the delivery area for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> mapDeliveryArea6(SlotQuery query) {
        if (query == null) {
            throw new IllegalArgumentException("query must not be null");
        }
        if (query.getWarehouseId() == null || query.getWarehouseId().isBlank()) {
            return List.of();
        }
        List<Slot> candidates = repository.findByDayAndWarehouse(
                query.getDay(), query.getWarehouseId());
        List<Slot> result = new ArrayList<>(candidates.size());
        for (Slot slot : candidates) {
            if (slot.getStatus() != SlotStatus.OPEN) {
                continue;
            }
            if (slot.getRemainingCapacity() <= 0) {
                continue;
            }
            if (clock.instant().isAfter(slot.getCutoff())) {
                continue;
            }
            result.add(slot);
        }
        result.sort(Comparator.comparing(Slot::getStart));
        return result;
    }

    /**
     * Load the vehicle for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> loadVehicle(SlotQuery query) {
        if (query == null) {
            throw new IllegalArgumentException("query must not be null");
        }
        if (query.getWarehouseId() == null || query.getWarehouseId().isBlank()) {
            return List.of();
        }
        List<Slot> candidates = repository.findByDayAndWarehouse(
                query.getDay(), query.getWarehouseId());
        List<Slot> result = new ArrayList<>(candidates.size());
        for (Slot slot : candidates) {
            if (slot.getStatus() != SlotStatus.OPEN) {
                continue;
            }
            if (slot.getRemainingCapacity() <= 0) {
                continue;
            }
            if (clock.instant().isAfter(slot.getCutoff())) {
                continue;
            }
            result.add(slot);
        }
        result.sort(Comparator.comparing(Slot::getStart));
        return result;
    }

    /**
     * Check the express for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> checkExpress1(SlotQuery query) {
        if (query == null) {
            throw new IllegalArgumentException("query must not be null");
        }
        if (query.getWarehouseId() == null || query.getWarehouseId().isBlank()) {
            return List.of();
        }
        List<Slot> candidates = repository.findByDayAndWarehouse(
                query.getDay(), query.getWarehouseId());
        List<Slot> result = new ArrayList<>(candidates.size());
        for (Slot slot : candidates) {
            if (slot.getStatus() != SlotStatus.OPEN) {
                continue;
            }
            if (slot.getRemainingCapacity() <= 0) {
                continue;
            }
            if (clock.instant().isAfter(slot.getCutoff())) {
                continue;
            }
            result.add(slot);
        }
        result.sort(Comparator.comparing(Slot::getStart));
        return result;
    }

    // DS follow-up 25: keep the cutoff check in one place
    private boolean withinCutoff25(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }
}
