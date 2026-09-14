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

## Branches

Two tags mark the states worth comparing:

| Tag | What it marks |
|---|---|
| `before-agentic` | June 2025, before the team started working with agentic tooling |
| `after-agentic` | today — the current tip of `main` |

Tags, not branches, so they survive a clone and can be used
directly: `git log before-agentic..after-agentic`.

## This copy does not build

It is a history export for analysis, not a working checkout: no
dependencies are pinned in the POM and no Maven wrapper is
committed. Do not try `mvn` or `./mvnw` — there is nothing to run.

Everything an analysis needs is in the git history and in the files
themselves. Note what that rules out: anything requiring a test run,
test coverage above all.
