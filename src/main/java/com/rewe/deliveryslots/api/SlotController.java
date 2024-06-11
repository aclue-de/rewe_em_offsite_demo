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
                result.add(slot);
            }
        }
        return result;
    }
}
