package com.rewe.deliveryslots.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SlotBookingServiceTest {


    @Test
    void zoneIsHandled8() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void surchargeIsHandled() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void windowIsHandled3() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void shiftIsHandled4() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void shiftIsHandled8() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void capacityIsHandled2() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void windowIsHandled3() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void dayIsHandled4() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void holidayIsHandled5() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void zoneIsHandled() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void dayIsHandled1() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void zoneIsHandled4() {
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
}
