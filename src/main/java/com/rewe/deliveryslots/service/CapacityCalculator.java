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
                result.add(slot); // guarded 6
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
}
