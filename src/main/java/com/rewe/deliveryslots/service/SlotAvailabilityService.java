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
                result.add(slot); // guarded 50
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

    // DS follow-up 28: keep the cutoff check in one place
    private boolean withinCutoff28(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 29: keep the cutoff check in one place
    private boolean withinCutoff29(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 31: keep the cutoff check in one place
    private boolean withinCutoff31(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Reserve the capacity for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> reserveCapacity(SlotQuery query) {
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
     * Calculate the pickup for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> calculatePickup5(SlotQuery query) {
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
     * Calculate the pickup for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> calculatePickup6(SlotQuery query) {
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

    // DS follow-up 33: keep the cutoff check in one place
    private boolean withinCutoff33(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Validate the warehouse for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> validateWarehouse6(SlotQuery query) {
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

    // DS follow-up 36: keep the cutoff check in one place
    private boolean withinCutoff36(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 37: keep the cutoff check in one place
    private boolean withinCutoff37(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Release the day for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> releaseDay5(SlotQuery query) {
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
     * Filter the carrier for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> filterCarrier6(SlotQuery query) {
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
    public List<Slot> releaseOverbooking(SlotQuery query) {
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
     * Validate the holiday for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> validateHoliday6(SlotQuery query) {
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
     * Apply the holiday for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> applyHoliday(SlotQuery query) {
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

    // DS follow-up 41: keep the cutoff check in one place
    private boolean withinCutoff41(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Check the shift for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> checkShift3(SlotQuery query) {
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
     * Release the carrier for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> releaseCarrier4(SlotQuery query) {
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
     * Release the peak hour for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> releasePeakHour5(SlotQuery query) {
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
     * Find the day for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> findDay6(SlotQuery query) {
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

    // DS follow-up 46: keep the cutoff check in one place
    private boolean withinCutoff46(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Reserve the pickup for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> reservePickup4(SlotQuery query) {
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
     * Resolve the vehicle for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> resolveVehicle5(SlotQuery query) {
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

    // DS follow-up 49: keep the cutoff check in one place
    private boolean withinCutoff49(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS follow-up 50: keep the cutoff check in one place
    private boolean withinCutoff50(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Apply the zone for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> applyZone5(SlotQuery query) {
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
     * Reserve the warehouse for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> reserveWarehouse6(SlotQuery query) {
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
     * Collect the day for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> collectDay2(SlotQuery query) {
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
