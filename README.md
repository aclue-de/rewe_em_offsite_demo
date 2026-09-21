# delivery-slots — and your workshop folder

This repository is two things at once: a small Java service, and your working
folder for the EM offsite session. You cloned it once and have everything.

## What was built here

**The kind of software:** a backend service. Java 21, Spring Boot, Maven. No
user interface and no screens — it is a component that sits behind the online
shop and answers questions for it. Four layers in the usual order: `api` takes
a request, `service` holds the rules, `domain` holds the data, `repository`
would talk to a database.

**What it is for:** `delivery-slots` decides when a customer can book a
delivery. Which time windows are still open for a given day and warehouse, how
much capacity is left in them, and when a window closes for new orders. The
kind of service every one of your teams has three of.

### ⚠️ It is a skeleton, not a running service

Be clear about this before you measure anything. The code was **generated for
this exercise.** The packages, classes and method names carry the structure of
a real service, and the git history behind them is realistic — but the code
does not do the work:

- `SlotRepository.findByDay()` returns an empty list. There is no database.
- Apart from `@SpringBootApplication` there is not a single Spring annotation —
  no `@RestController`, no `@GetMapping`. There is no HTTP.
- Methods with different names share the same body, and a few private helpers
  are defined more than once in the same class.
- The POM names Spring Boot but declares no dependencies.

**What that means for the task:** what you measure here is the *shape* and the
*history* — how much code there is, how it grew, how it was committed. Not
what it does at runtime. Anything that needs a test run — test coverage above
all — is not measurable here.

More under [About the service](#about-the-service) at the bottom.

## What has to be on your machine

| | |
|---|---|
| **Claude Code** | logged in |
| **git** | check with `git --version` |
| **a browser** | to open the dashboard you produce |

**That is the whole list.** No Java, no Maven, no Node, nothing to install —
the exercise reads the git history and the files, and a dashboard is plain
HTML that opens from your hard drive.

If you are reading this on GitHub and have not cloned yet:

```
git clone https://github.com/aclue-de/rewe_em_offsite_demo.git delivery-slots
```

---

## The first steps — we do these together

| | |
|---|---|
| **1** | Open this folder in a terminal, then start `claude`. **It asks whether you trust this folder — say yes.** |
| **2** | `/help` — everything it can do. Not a prompt box. |
| **3** | `/context` — what it knows right now, and how much room is left. |
| **4** | `/permissions` — what it may do here, and what it has to ask for. |
| **5** | Ask: *“What is this project, and what happened here in the last year?”* |
| **6** | When it goes the wrong way: **Esc**. It stops. |

**Step 1 matters more than it looks.** This folder ships with prepared
permissions so you are not clicking "allow" every ten seconds. Those only take
effect once you have confirmed the trust prompt. Answer no and every command
gets refused.

At step 5, watch what it does before it answers. It reads the files, then it
runs `git log` over the history — you can see the commands go past. That is
the thing a chat window cannot do. The history is also the real material in
this repository, which is why the question goes there rather than at what the
code does at runtime.

Step 6 is the one people forget. You never have to sit and wait.

---

## The task — what changed since we went agentic?

Two tags mark the states you compare:

| Tag | What it marks |
|---|---|
| `before-agentic` | the service in June 2025, before the team used agentic tooling — 41 commits over 16 months |
| `after-agentic` | the same service today — 127 commits since then, over 14 months |

Thirty minutes, on your own laptop. Four steps — the same four as on the
slide.

| | | |
|---|---|---|
| **1** | **Think before you type.** | Which numbers would show what changed — and which of them would you actually trust? Two minutes, no terminal. |
| **2** | **Write the brief — the four blocks.** | Ask for a plan first: which metrics, and how to show them. Format is where you decide what the dashboard looks like. |
| **3** | **Choose from its plan, then let it run.** | Take what you trust, drop the rest. It measures both states and builds the dashboard — open it in your browser. |
| **4** | **Check one number, then decide.** | Verify one number by hand — `git log` is right there. Which finding would you act on, and what is the smallest next step? Bring that to the debrief. |

**There is no ready-made prompt in this folder, and no template.** The brief
is the exercise. The four blocks, as on the slide:

- **Context** — where are we, what already exists? *This repository, the two
  tags, who you are and who the result is for.*
- **Goal** — what exactly should be produced? *A plan first — metrics and
  layout. Measuring only after you have chosen.*
- **Constraints** — what has to be observed? *What it may not do, what it must
  not assume, how many metrics you actually want.*
- **Format** — what should the result look like? *Which files land on disk,
  what the dashboard has to look like so that before and after compare at a
  glance, and what it has to state about its own basis.*

Leave one out and the agent guesses at that point — and you cannot tell from
the result where it guessed.

`AGENTS.md` is the part of the brief that does not change from task to task:
what the agent should know about this project, and the house rules it follows
here. Read it once. In your own teams, somebody owns that file.

### If something does not work

- **It asks for permission** — read what it wants, then decide. Reading files,
  `git` and writing `.md` and `.html` files are already allowed; anything
  beyond that is meant to ask.
- **It runs and runs** — press **Esc**, then narrow the question.
- **Nothing works** — raise a hand. Do not debug, that is not today's exercise.

---

## Homework — are we actually compliant?

For your own teams, tomorrow. Same four blocks, your own brief.

We have a rule at REWE: **every commit carries a reference to its Jira
ticket**, so that any change can be traced back to a decision. Ticket keys
look like `DS-1234`.

Find out for your team, over the last 90 days:

- How many commits carry no recognisable ticket reference — the count and the
  share. That is the easy half; Claude does it in a minute.
- **What kind of commits are they?** Dependency bumps, merge commits and
  formatter runs are routine. A substantive change without a ticket is the
  actual finding — look at the diff, not just the message.
- The three cases you would look at yourself, and why.

Two things that belong in your constraints: the unit of analysis is the commit,
never the author — and read only, nothing gets written to Jira or to any
repository.

No access to your team's repositories and Jira yet? Run it against this
repository. Its history carries the same mix of commits with and without a
ticket — you bring a result rather than an excuse.

---

## About the service

Delivery time slots for the online grocery shop: which windows a customer can
pick, how much capacity is left in them, and when a slot closes for new
orders.

The service answers two questions:

- which slots can still take an order for a given day and warehouse
- what happens to a slot when an order is placed or cancelled

| Path | What it stands for |
|---|---|
| `src/main/java/…/api/` | where a request enters, and the types it carries |
| `src/main/java/…/domain/` | slots, warehouses, capacity — the data |
| `src/main/java/…/service/` | availability and booking rules |
| `src/main/java/…/repository/` | where persistence would sit |

Ticket references in commit messages point at the Jira project `DS`.

### The rules the names refer to

These describe the domain the service is modelled on. They are not implemented
in this skeleton — they are here so the class and method names make sense.

- A slot belongs to exactly one warehouse and one day.
- Slots close for new orders at their cutoff time; the cutoff is held per
  warehouse, not per zone.
- Capacity is counted in orders, not in items. A slot with remaining capacity
  0 is full even if the van is not.
- Cancelling an order releases capacity back to the slot it was booked in.
- Overbooking is allowed up to the configured buffer per warehouse.

### ⚠️ This copy does not build

It is a history export for analysis, not a working checkout: no dependencies
are pinned in the POM and no Maven wrapper is committed. Do not try `mvn` or
`./mvnw` — there is nothing to run.

Everything the exercise needs is in the git history and in the files
themselves. Note what that rules out: anything requiring a test run, test
coverage above all.
