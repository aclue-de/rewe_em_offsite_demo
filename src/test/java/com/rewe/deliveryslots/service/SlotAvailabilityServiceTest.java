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
}
