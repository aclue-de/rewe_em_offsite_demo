# delivery-slots

Delivery time slots for the online grocery shop: which windows a
customer can pick, how much capacity is left in them, and when a slot
closes for new orders.

The service answers two questions:

- which slots can still take an order for a given day and warehouse
- what happens to a slot when an order is placed or cancelled

## Layout

| Path | What is in there |
|---|---|
| `api/` | the REST endpoints and their DTOs |
| `domain/` | slots, warehouses, capacity |
| `service/` | availability and booking rules |
| `repository/` | persistence |

Ticket references in commit messages point at the Jira project `DS`.

## Rules worth knowing

- A slot belongs to exactly one warehouse and one day.
- Slots close for new orders at their cutoff time; the cutoff is held per warehouse, not per zone.
- Capacity is counted in orders, not in items. A slot with remaining capacity 0 is full even if the van is not.
- Express slots use the same model with a shorter lead time.
- Cancelling an order releases capacity back to the slot it was booked in.
- Holidays are loaded from the warehouse calendar, not hard-coded.
- Pickup slots have no carrier and no delivery area.
- A slot that is CLOSED never becomes OPEN again — a new slot is created instead.
- Overbooking is allowed up to the configured buffer per warehouse.
