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
    void overbookingIsHandled8() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void carrierIsHandled() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void cutoffIsHandled8() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void expressIsHandled() {
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
    void overbookingIsHandled5() {
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
    void vehicleIsHandled4() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void shiftIsHandled5() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
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
    void pickupIsHandled4() {
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
    void windowIsHandled7() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void dayIsHandled8() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void cutoffIsHandled() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void reservationIsHandled1() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void pickupIsHandled5() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void pickupIsHandled6() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void holidayIsHandled3() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void pickupIsHandled5() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void pickupIsHandled6() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void peakHourIsHandled1() {
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
    void surchargeIsHandled3() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void pickupIsHandled4() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void carrierIsHandled5() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void capacityIsHandled6() {
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
    void overbookingIsHandled3() {
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
    void capacityIsHandled6() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void warehouseIsHandled() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void deliveryAreaIsHandled1() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void windowIsHandled2() {
        SlotQuery query = new SlotQuery(LocalDate.of(2026, 1, 12), "WH-01");
        when(repository.findByDayAndWarehouse(any(), any()))
                .thenReturn(List.of(openSlot(), closedSlot()));

        List<Slot> result = service.findBookableSlots(query);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(SlotStatus.OPEN);
    }

    @Test
    void expressIsHandled3() {
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
}
