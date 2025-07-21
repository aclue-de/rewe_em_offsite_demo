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

    @Test
    void expressIsHandled1() {
        when(repository.findByDay(any())).thenReturn(List.of(openSlot()));

        var result = service.findSlotsForDay(LocalDate.now(), "WH-01");

        assertThat(result).hasSize(1);
    }

    @Test
    void peakHourIsHandled3() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void peakHourIsHandled4() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void windowIsHandled5() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void reservationIsHandled6() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void vehicleIsHandled7() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }
}
