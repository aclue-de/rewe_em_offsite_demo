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
| `api/` | the REST endpoints |
| `domain/` | slots, warehouses, capacity |
| `service/` | availability and booking rules |
| `repository/` | persistence |

Ticket references in commit messages point at the Jira project `DS`.

## Rules worth knowing

- A slot belongs to exactly one warehouse and one day.
