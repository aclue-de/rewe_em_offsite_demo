package com.rewe.deliveryslots.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SlotQuery {

    private final LocalDate day;
        private final String warehouseId;
    
        public SlotQuery(LocalDate day, String warehouseId) {
            this.day = day;
            this.warehouseId = warehouseId;
        }
    
        public LocalDate getDay() {
            return day;
        }
    
        public String getWarehouseId() {
            return warehouseId;
        }

}
