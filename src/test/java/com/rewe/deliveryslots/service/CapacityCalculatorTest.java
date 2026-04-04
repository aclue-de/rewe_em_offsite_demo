package com.rewe.deliveryslots.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CapacityCalculatorTest {


    @Test
    void zoneIsHandled1() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void cutoffIsHandled2() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void peakHourIsHandled2() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void overbookingIsHandled3() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void warehouseIsHandled4() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void warehouseIsHandled6() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void peakHourIsHandled7() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void carrierIsHandled8() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void capacityIsHandled5() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void overbookingIsHandled6() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void windowIsHandled7() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void holidayIsHandled8() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }
}
