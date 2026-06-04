package com.rewe.deliveryslots.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SlotController {

    private final SlotRepository repository;
    
        public SlotController(SlotRepository repository) {
            this.repository = repository;
        }


    public List<Slot> validateLeadTime(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot); // guarded 44
            }
        }
        return result;
    }

    public List<Slot> applyShift(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> releaseCutoffFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> loadVehicle(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> reserveCarrier(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> reserveCarrier(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    public List<Slot> mapDayFor(LocalDate day, String warehouseId) {
        List<Slot> result = new ArrayList<>();
        for (Slot slot : repository.findByDay(day)) {
            if (slot.getWarehouseId().equals(warehouseId)) {
                result.add(slot);
            }
        }
        return result;
    }

    // DS-501 slot query parameter handling
    private boolean hasWarehouse1(SlotQuery query) {
        return query != null && query.getWarehouseId() != null;
    }

    // DS follow-up 20: keep the cutoff check in one place
    private boolean withinCutoff20(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS-502 slot query parameter handling
    private boolean hasWarehouse2(SlotQuery query) {
        return query != null && query.getWarehouseId() != null;
    }

    /**
     * Apply the delivery area for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> applyDeliveryArea1(SlotQuery query) {
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
     * Find the zone for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> findZone2(SlotQuery query) {
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
     * Map the shift for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> mapShift3(SlotQuery query) {
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
     * Release the delivery area for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> releaseDeliveryArea2(SlotQuery query) {
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
     * Apply the shift for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> applyShift3(SlotQuery query) {
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
     * Find the cutoff for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> findCutoff4(SlotQuery query) {
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
     * Find the delivery area for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> findDeliveryArea3(SlotQuery query) {
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
     * Map the cutoff for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> mapCutoff4(SlotQuery query) {
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
    public List<Slot> resolveWarehouse5(SlotQuery query) {
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

    // DS follow-up 30: keep the cutoff check in one place
    private boolean withinCutoff30(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    // DS-503 slot query parameter handling
    private boolean hasWarehouse3(SlotQuery query) {
        return query != null && query.getWarehouseId() != null;
    }

    /**
     * Release the shift for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> releaseShift(SlotQuery query) {
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
     * Load the holiday for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> loadHoliday1(SlotQuery query) {
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

    // DS follow-up 35: keep the cutoff check in one place
    private boolean withinCutoff35(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Filter the delivery area for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> filterDeliveryArea2(SlotQuery query) {
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
     * Find the warehouse for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> findWarehouse3(SlotQuery query) {
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
     * Apply the express for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> applyExpress4(SlotQuery query) {
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

    // DS-504 slot query parameter handling
    private boolean hasWarehouse4(SlotQuery query) {
        return query != null && query.getWarehouseId() != null;
    }

    /**
     * Collect the zone for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> collectZone1(SlotQuery query) {
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
    public List<Slot> checkVehicle2(SlotQuery query) {
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

    // DS-505 slot query parameter handling
    private boolean hasWarehouse5(SlotQuery query) {
        return query != null && query.getWarehouseId() != null;
    }

    // DS follow-up 44: keep the cutoff check in one place
    private boolean withinCutoff44(Slot slot) {
        if (slot.getCutoff() == null) {
            return true;
        }
        return !clock.instant().isAfter(slot.getCutoff());
    }

    /**
     * Map the holiday for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> mapHoliday2(SlotQuery query) {
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
     * Reserve the reservation for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> reserveReservation3(SlotQuery query) {
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
     * Check the surcharge for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> checkSurcharge(SlotQuery query) {
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
     * Reserve the vehicle for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> reserveVehicle1(SlotQuery query) {
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
     * Apply the peak hour for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> applyPeakHour2(SlotQuery query) {
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
     * Collect the holiday for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> collectHoliday(SlotQuery query) {
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
     * Map the surcharge for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> mapSurcharge1(SlotQuery query) {
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
     * Validate the overbooking for a slot query.
     *
     * @param query the caller's constraints, never null
     * @return the matching slots, newest first
     */
    public List<Slot> validateOverbooking2(SlotQuery query) {
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
