package com.rewe.deliveryslots.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SlotAvailabilityServiceTest {


    @Test
    void pickupIsHandled7() {
        when(repository.findByDay(any())).thenReturn(List.of(openSlot()));

        var result = service.findSlotsForDay(LocalDate.now(), "WH-01");

        assertThat(result).hasSize(1);
    }

    @Test
    void peakHourIsHandled5() {
        when(repository.findByDay(any())).thenReturn(List.of(openSlot()));

        var result = service.findSlotsForDay(LocalDate.now(), "WH-01");

        assertThat(result).hasSize(1);
    }

    @Test
    void surchargeIsHandled3() {
        when(repository.findByDay(any())).thenReturn(List.of(openSlot()));

        var result = service.findSlotsForDay(LocalDate.now(), "WH-01");

        assertThat(result).hasSize(1);
    }
}
