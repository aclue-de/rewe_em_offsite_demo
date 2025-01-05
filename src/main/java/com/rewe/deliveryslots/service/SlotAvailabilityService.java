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
                result.add(slot);
            }
        }
        return result;
    }
}
