package com.rewe.deliveryslots.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Slot {

    private String id;
        private String warehouseId;
        private LocalDate day;
        private int remainingCapacity;
    
        public String getId() {
            return id;
        }
    
        public String getWarehouseId() {
            return warehouseId;
        }
    
        public LocalDate getDay() {
            return day;
        }
    
        public int getRemainingCapacity() {
            return remainingCapacity;
        }

}
