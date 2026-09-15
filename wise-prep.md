# Wise — Senior Full Stack Developer (Scam Prevention, Tallinn)
### Interview Prep Guide — 10 Questions per Round

**Role:** Senior Full Stack Developer, Scam Prevention team, Tallinn
**Split:** ~80% backend, ~20% frontend
**Salary band:** €5,750 – 7,083.33 / month
**Stack (confirmed):** Java/Spring, Kafka, relational + non-relational DBs, React/JS/TS on the frontend side, CI/CD, an internal "microservice chassis" framework (standardized security, DB, Kafka, and observability wiring used across Wise's 1000+ services)
**Domain:** Real-time transaction monitoring, ML-assisted fraud/scam detection, mule-account and fraud-ring identification — 80% of your time is backend fraud-engine work, 20% frontend (likely internal tooling/dashboards for investigators, or customer-facing controls)

---

## The Interview Process

Based on Wise's official careers-site guides plus recent (2025–2026) candidate reports, expect **5 stages**:

1. **Recruiter screen** (~30 min, phone) — role fit, motivation, logistics
2. **Backend Pair Programming** (45–60 min, HackerRank CodePair, 1 interviewer) — hands-on coding
3. **Backend System Design** (60–90 min, 2 interviewers) — architecture + trade-offs
4. **Engineering Product Round** (45–60 min, PM-led) — product mindset, STAR stories
5. **Final / Team round** (with Engineering Lead + hiring manager) — values fit, deeper technical discussion, sometimes called the "manager round"

Notes from real candidates: the pair-programming round is **not LeetCode-style** — it tends to be a practical, realistic problem (e.g., a circuit breaker, a currency-conversion service, a phonebook-style lookup), and interviewers explicitly test Java fundamentals like `ConcurrentHashMap` and concurrency primitives. The system design round is run by two engineers and doubles as a leveling conversation, so depth matters as much as breadth. Since the JD calls out React/JS/TS explicitly, mention your comfort there during the recruiter call in case they want to sample it — you're allowed to request your preferred language for the coding round.

---

## Round 1 — Recruiter Screen

1. Walk me through your 9 years of experience — how has your scope grown from individual contributor to senior ownership?
2. Why Wise, and why the Scam Prevention team specifically?
3. What do you know about Wise's mission and how the company makes money movement cheaper and faster?
4. How does your Java/Spring microservices background map onto a real-time fraud-prevention domain?
5. What's motivating a move right now, and what's missing from your current situation?
6. Are you comfortable with an 80% backend / 20% frontend split, given your background?
7. Does the €5,750–7,083.33/month band work for you?
8. Are you open to relocating to Tallinn, and what's your timeline?
9. If not Java, which language would you prefer for the pair-programming round?
10. What questions do you have about the role, the team, or the process?

---

## Round 2 — Backend Pair Programming

Format: HackerRank CodePair, ~60 min, 1 interviewer. Graded on technical competency, problem-solving/edge-case thinking, and communication — **not** system design, riddles, or resume deep-dives.

1. Implement a rate limiter (token bucket or sliding-window) to throttle suspicious transaction attempts per user.
2. Implement a circuit breaker from scratch (closed/open/half-open states) — a variant of this has been reported by real Wise candidates.
3. Design and implement a thread-safe LRU cache (`LinkedHashMap` or manual doubly-linked-list + hash map).
4. Given a stream of transactions, detect duplicate/replay transactions within a sliding time window.
5. Define an interface for a currency/value-conversion service, implement a sample query, then add caching — a reported real Wise question.
6. Group connected accounts that share an attribute (device ID, IP, phone) using BFS/DFS or Union-Find — a fraud-ring detection warm-up.
7. Implement a producer-consumer queue using `BlockingQueue` or `wait`/`notify`.
8. Solve a classic string/array problem (e.g., longest substring without repeating characters, merge intervals) while narrating your reasoning out loud.
9. Design a lookup structure (e.g., phonebook-style service) where search time doesn't grow with data size — a reported real Wise question.
10. Given a snippet with a subtle concurrency bug (e.g., a non-thread-safe singleton or a race condition in a counter), find and fix it.

---

## Round 3 — Backend System Design

Format: 60–90 min, 2 interviewers. Wise says they don't want textbook answers — they want your reasoning, trade-offs, and how you handle follow-up pressure ("yes, but what else could you do differently?").

1. Design a real-time transaction-monitoring system that scores every payment for fraud risk before it's allowed to complete.
2. Design a rules engine that lets fraud analysts add or update detection rules without a service redeploy.
3. Design a system to detect mule accounts / fraud rings across millions of accounts using relationship graphs.
4. How would you guarantee idempotent payment processing so a transaction is never double-charged or double-flagged on retry?
5. Design the pipeline from "transaction flagged" → investigator queue → decision → feedback loop back into the detection model.
6. How would you scale a Kafka-based event pipeline ingesting all transactions for real-time scoring, handling backpressure and consumer lag?
7. Walk through migrating a legacy fraud-check module from a monolith to microservices (strangler fig), including how you'd split data ownership.
8. Design an anti-abuse rate-limiter to stop scripted account-takeover attempts against customer-facing APIs.
9. How do you keep the fraud-detection service eventually consistent with the core ledger/payments service, and what do you do when they diverge?
10. Relational vs. non-relational storage for fast-changing per-user fraud signals — walk through your schema and indexing choices for both write and read paths.

---

## Round 4 — Engineering Product Round

Format: 45–60 min, led by a PM (sometimes with a designer/analyst). Conversational, not technical — no coding, no system design. Use **STAR** (Situation, Task, Action, Result).

1. Tell me about a project where your engineering work directly reduced customer harm or losses — how did you measure the impact?
2. Describe a time you had to balance a security/fraud control against user friction or conversion — how did you decide?
3. Walk me through a project you're most proud of from the last few years — your role and the outcome.
4. Tell me about a time you disagreed with a PM or stakeholder on priorities — how was it resolved?
5. Describe a time you used data to challenge an assumption and change a project's direction.
6. Tell me about a project that didn't hit its expected impact — what did you learn, and what did you change afterward?
7. How have you partnered with data scientists or ML teams, and what did that collaboration look like day-to-day?
8. How do you prioritize between paying down technical debt and shipping new features when both compete for the same sprint?
9. Tell me about a time you had to explain a complex technical trade-off to a non-technical stakeholder.
10. What metrics would you propose for a new scam-detection control, and how would you avoid false positives hurting genuine customers?

---

## Round 5 — Final / Team & Values Round

Format: with the Engineering Lead and/or hiring manager. Expect open-ended, scenario-based questions on decision-making and values fit, plus deeper technical/architectural probing.

1. What does ownership mean to you? Give an example of owning a project fully end-to-end.
2. How do you approach mentoring less experienced engineers on a team?
3. Tell me about a decision you had to make with incomplete information under time pressure.
4. This system directly protects customer money — walk through how you'd triage a live production incident on-call.
5. Describe a time you pushed back on a decision you thought was wrong, and how you handled it.
6. How do you keep your technical skills current, and what's something recent that changed how you build software?
7. Tell me about a time you challenged a plan because it wasn't good for the customer.
8. Describe your ideal engineering culture, and how you contribute to building one.
9. Given your 9 years of experience, where do you see the biggest growth opportunity for you in this specific role?
10. What questions do you have about how the Scam Prevention team operates or how success is measured here?

---

## Fast Prep Checklist

- **Coding:** Java concurrency (`ConcurrentHashMap`, `BlockingQueue`, locks), rate limiters, caches, circuit breakers, graph traversal (BFS/DFS/Union-Find) — practical, not LeetCode-hard.
- **System design:** idempotency, eventual consistency, Kafka at scale, microservices decomposition, high-volume transaction processing, DB indexing/schema trade-offs.
- **Domain reading:** skim Wise's public engineering blog on their tech stack and microservice chassis framework, and any public material on real-time fraud detection with Kafka — it'll give you shared vocabulary for the system design round.
- **Stories to have ready (STAR):** a measurable customer-impact project, a friction-vs-security trade-off, a disagreement with a stakeholder, a project that missed its mark, and an on-call/incident story.
