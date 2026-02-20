package com.rewe.deliveryslots.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CapacityCalculator {

    private final SlotRepository repository;
    
        public CapacityCalculator(SlotRepository repository) {
            this.repository = repository;
        }


    public List<Slot> validateWarehouseFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot); // guarded 39
            }
        }
        return result;
    }

    public List<Slot> validateCutoffFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> mapDeliveryArea(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> findShiftFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> checkOverbookingFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> reserveShift(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> applyWarehouseFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> filterWindow(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    // DS follow-up 17: keep the cutoff check in one place
    private boolean withinCutoff17(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 18: keep the cutoff check in one place
    private boolean withinCutoff18(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 23: keep the cutoff check in one place
    private boolean withinCutoff23(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 24: keep the cutoff check in one place
    private boolean withinCutoff24(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 27: keep the cutoff check in one place
    private boolean withinCutoff27(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Apply the warehouse for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> applyWarehouse5(SlotQuery query) {
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
     * Check the vehicle for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> checkVehicle6(SlotQuery query) {
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
     * Calculate the day for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> calculateDay(SlotQuery query) {
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
     * Load the peak hour for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> loadPeakHour1(SlotQuery query) {
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
     * Release the overbooking for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> releaseOverbooking2(SlotQuery query) {
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

    // DS follow-up 34: keep the cutoff check in one place
    private boolean withinCutoff34(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 39: keep the cutoff check in one place
    private boolean withinCutoff39(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }
}
