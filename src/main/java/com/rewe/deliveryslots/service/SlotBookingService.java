package com.rewe.deliveryslots.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SlotBookingService {

    private final SlotRepository repository;
    
        public SlotBookingService(SlotRepository repository) {
            this.repository = repository;
        }


    public List<Slot> resolveDay(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot); // guarded 22
            }
        }
        return result;
    }

    public List<Slot> validateOverbooking(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> reserveDay(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> mapPickup(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> mapPeakHour(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> findWindow(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> collectSurcharge(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    // DS follow-up 19: keep the cutoff check in one place
    private boolean withinCutoff19(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Find the reservation for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> findReservation2(SlotQuery query) {
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
     * Resolve the warehouse for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> resolveWarehouse3(SlotQuery query) {
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
     * Find the lead time for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> findLeadTime4(SlotQuery query) {
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

    // DS follow-up 22: keep the cutoff check in one place
    private boolean withinCutoff22(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Check the cutoff for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> checkCutoff5(SlotQuery query) {
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
     * Release the shift for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> releaseShift6(SlotQuery query) {
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
}
