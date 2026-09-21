# How to work in this folder

This is a workshop folder for engineering managers. You are helping someone who
leads a software team and does not read code every day. **They write the brief
themselves.** There is no prepared task, prompt or template in this folder — do
not look for one, and do not assume what the result should look like beyond
what they tell you.

## What this project is

A backend service in Java 21 with Spring Boot: `delivery-slots`, which decides
when a customer can book a delivery — which time windows are open for a day
and warehouse, how much capacity is left, when a window closes.

**It is a skeleton, generated for this exercise.** Say so when you are asked
what it does. The package structure, the class names and the git history are
realistic; the behaviour is not. `SlotRepository.findByDay()` returns an empty
list, there are no Spring annotations beyond `@SpringBootApplication`, no HTTP
layer, no database, several methods share the same body, and some private
helpers (`withinCutoff`, `isUsable`, `hasWarehouse`) are defined more than once
in the same class — a fix commit in the history re-adds them rather than
changing them. Describe what the code is *modelled on* and be explicit that it
does not run — do not present it as a working REST service. Repeated fix
commits and duplicated helpers are artefacts of how the history was generated;
say so when you find them, and do not read them as six real regressions.

**It does not build.** No dependencies are pinned in the POM and there is no
Maven wrapper. Anything that needs a test run — test coverage above all — is
not measurable here. Say so instead of estimating.

## What is here

| Path | What it is |
|---|---|
| `src/` | the Java service itself, with a real git history and **two tagged states** |
| `README.md` | the workshop steps and the project description — written for the person you are helping, not as instructions for you |
| `AGENTS.md` | this file: what you should know here, and the house rules |

The two tagged states — tags, so they survive a clone:

- **`before-agentic`** — the service as of June 2025, before the team worked
  with agentic tooling
- **`after-agentic`** — the same service today (the same code as `main`)

### How to compare them

`before-agentic` is an **ancestor** of `after-agentic` — the second tag
contains the first. That matters for every count:

| Question | What to measure |
|---|---|
| What does the code look like in each state? | `git ls-tree -r <tag>` and `git show <tag>:<file>` — a clean snapshot comparison, no pitfall |
| How was each state produced? | `git log before-agentic` **against** `git log before-agentic..after-agentic` |

**Never compare `git log before-agentic` with `git log after-agentic`.** The
second includes the first, so it reports roughly four times the commits and
twice the time span, and any "×" you derive from it is wrong.

With the correct ranges the two periods are almost the same length —
16 months against 14 — so per-month figures are directly comparable.

## How to answer

**Name the source of every number.** The git command or the file it came from,
in brackets after the number. A number without a source is not usable here.

**Say when the data does not reach.** If a question cannot be answered from
this repository, write that down instead of estimating. Do not present a
guess in the same voice as a measurement.

**Do not claim cause and effect the history cannot show.** Two things changing
at the same time is not proof that one caused the other. Say "changed at the
same time as", not "was caused by".

**Aggregate with git.** Use `git log --numstat`, `git ls-tree`, `git show
--stat` and similar over the whole range. Do not inspect commits one at a
time — on this history that takes minutes and the person is waiting.

**Explain in the language of the job, not the tool.** "The largest file tripled
in size" lands; "LOC delta of 1024 in module X" does not.

## Rules

- **The unit of analysis is the commit and the file, never the author.** Who
  wrote a commit is not part of any question here. Leave author fields out of
  every table and every chart.
- **Install nothing.** Only git and the files themselves. No package managers,
  no analysis tools, no downloads.
- **Write your results as new files in this folder.** Never modify the project
  files, `README.md`, `AGENTS.md` or the git history, and never commit.
- **What the result looks like is the person's decision, not yours.** If the
  brief does not say which files to write or how a dashboard should look, ask
  — do not fill the gap with a default.
