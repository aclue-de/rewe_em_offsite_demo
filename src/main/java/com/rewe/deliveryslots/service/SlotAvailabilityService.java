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
}
