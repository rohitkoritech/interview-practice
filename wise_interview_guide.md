# Wise Senior Full Stack Engineer Interview Preparation Guide

This definitive, deeply researched interview preparation guide is tailored specifically for a **Senior Full Stack Engineer (80% Backend / 20% Frontend)** entering the **Scam Prevention & Fraud Detection Team** at Wise Tallinn. 

Wise evaluates candidates based on **Product Ownership** (understanding *why* you build a feature for the user), strict **Test-Driven Development (TDD)**, and high-concurrency architecture that handles massive volume without impacting real-time user experience.

---

## 🛠️ Round 1: Live Backend Pair Programming (Java / Spring Boot)
*Wise uses a **HackerRank skeleton code environment**. You are handed a domain-specific class with blank methods and asked to implement the logic interactively with the interviewer. They explicitly grade you on writing your **unit tests first (TDD)** and choosing thread-safe data structures.*

1. **Implement a Time-Window Circuit Breaker** 
   * *The Problem:* Fill out an object-oriented skeleton for a circuit breaker tracking calls to a downstream compliance API. It must trip if the failure rate exceeds X% over a moving 60-second time window. *Focus: Avoid high-lock latency; use `ConcurrentHashMap` or a ring-buffer array.*
2. **Build a Reliable Currency Conversion Rate Aggregator**
   * *The Problem:* Write a thread-safe local service that consumes a mock streaming feed of fluctuating exchange rates. It must store the absolute latest rate per currency pair while ignoring out-of-order, stale updates. 
3. **Design a Safe Multi-Threaded Balance Transfer Engine**
   * *The Problem:* Code a service method `transferFunds(Account from, Account to, Amount money)`. Prevent deadlocks when Thread A executes `Account 1 -> Account 2` at the exact millisecond Thread B executes `Account 2 -> Account 1`. *Focus: Establish a deterministic resource locking order (e.g., sorting by Account ID).*
4. **Implement an Idempotent Transaction Ingestor**
   * *The Problem:* Build a deduplication filter class for an incoming stream of transaction webhooks. The filter must prevent double-processing of identical transaction IDs while dynamically cleaning up ancient keys to avoid an out-of-memory error.
5. **Implement an Asynchronous Retry Manager with Exponential Backoff**
   * *The Problem:* Create a utility using Java's `CompletableFuture` or Spring's `@Async` that retries an unreliable fraud analysis call. It must back off exponentially (1s, 2s, 4s...) and gracefully fall back to an "allow transaction" flag if it hits a maximum retry limit.
6. **Code a Slotted Sliding Window Rate Limiter**
   * *The Problem:* Write an API request throttler for a public endpoint that restricts any single user ID to 10 attempts per minute. Ensure it adapts smoothly across sliding minute boundaries without blocking global throughput.
7. **Build a Dynamic Scam Rule Boolean Evaluator**
   * *The Problem:* Write an engine that executes a list of dynamic risk rules against a user profile (e.g., `isNewUser == true && amount > 5000 && destinationCountry != domestic`). Structure the code cleanly using the Strategy or Specification pattern.
8. **Write a Deterministic Batch Reconciliation Ingestor**
   * *The Problem:* Implement a service that processes a massive file containing a list of bank transfers, enriches each row using a third-party geo-IP stub, and groups them securely for DB persistence.
9. **Build an In-Memory Velocity Spike Tracker**
   * *The Problem:* Track user behaviors over short intervals. Code a component that immediately flags a user if they attempt to add more than 3 new bank recipients within 5 minutes.
10. **Refactor a Monolithic Payment Validation Class via TDD**
    * *The Problem:* The interviewer hands you a long, nested `if-else` method validating transaction risks. Write your unit tests **before** changing anything, then refactor it into testable, modular classes using clean OOP principles.

---

## 🏗️ Round 2: Advanced System Design (HLD & LLD)
*For the Scam Prevention team, the primary conflict is **Latency vs. Security**. How do you check millions of global transactions for fraud using machine learning and complex business rules in **under 100ms** without breaking the user experience?*

1. **Design a Real-Time Scam Scoring Engine**
   * *Core System:* The architecture behind reviewing a transaction at the moment a user clicks "send". Address how your microservices query real-time rule engines, pass data to machine learning models, and handle automated transaction pauses for manual risk team inspection.
2. **Design a High-Throughput Event-Driven Fraud Audit Log**
   * *Core System:* Every user action, login, and device shift must be tracked for compliance auditing. Architect a pipeline (e.g., Kafka -> ClickHouse/S3) that handles tens of thousands of writes per second while allowing fraud investigators to run fast complex query lookups.
3. **Design an Account Takeover (ATO) Detection System**
   * *Core System:* An ingestion infrastructure that streams real-time user behavioral analytics (typing speed, navigation patterns, IP geolocation changes, device fingerprint swaps) to compute an active risk state.
4. **Design a Resilience Framework for Flaky Downstream KYC / Identity Providers**
   * *Core System:* Third-party verification APIs fail or experience severe latency spikes. Design a resilient distributed system using fallback queues, state machines, and local caches to handle user sign-ups safely during provider blackouts.
5. **Design a Distributed, Low-Latency Rate Limiter at the Cloud Edge**
   * *Core System:* A global defense network to prevent malicious card-testing bot attacks targeting public checkout endpoints. Address how you maintain global sync across data centers without introducing heavy cross-region network overhead.
6. **Design a Dynamic Risk Rule Deployment Platform**
   * *Core System:* When an active scam trend is spotted, risk operations managers need to deploy a new blocking rule immediately (without waiting for engineers to run a code release). Design the control panel and safe real-time execution engine.
7. **Design an End-to-End Idempotent Ledger and Payout Service**
   * *Core System:* Microservice communication failures can duplicate messages. Design a payment engine that guarantees exact-once execution across distributed core ledger databases, ensuring users are never double-charged.
8. **Design a Real-Time Transaction Graph Analytics Pipeline**
   * *Core System:* Fraud rings often transfer stolen funds recursively across dozens of proxy accounts instantly to obscure the money. Design a streaming pipeline that can identify money laundering loops or graph connections in near real-time.
9. **Design a Phishing Link Scanning and Sandboxing System**
   * *Core System:* A worker framework that ingests reported phishing links targeting customers. It must securely distribute URLs to isolated sandboxes, execute automated page parsing, scrape payloads, and update a global blocklist cache.
10. **Design a Data-Sharing Network for Inter-Bank Fraud Scores**
    * *Core System:* Design the architecture for a secure API ecosystem that shares point-in-time fraud risk scores with partner financial institutions to intercept Authorized Push Payment (APP) scams safely under GDPR guidelines.

---

## 🎨 Round 3: Live Frontend Pair Programming (React / TypeScript)
*Since the role is an **80/20 mix**, Wise will not grade you on complex CSS styling. They focus heavily on vanilla JavaScript/TypeScript efficiency, handling asynchronous API responses correctly, and preventing performance lag when rendering high-volume streaming data.*

1. **Build a Real-Time Operations Monitoring Dashboard**
   * *The Task:* Implement a React view that consumes a simulated, high-frequency stream of incoming scam alerts. Prevent the browser UI from locking up by optimizing state batching, avoiding unnecessary component re-renders, and using virtual list concepts.
2. **Implement an Autocomplete Lookup with Debounce and Request Race-Condition Cancellation**
   * *The Task:* Create a beneficiary bank routing search input field. You must implement a custom debounce mechanism to minimize API calls and use an `AbortController` to cancel out-of-order, stale network responses.
3. **Write an Asynchronous Promise Runner with Bounded Concurrency**
   * *The Task:* Write a native TypeScript/JavaScript utility function that accepts an array of async functions and an integer `N`. It must execute all functions but guarantee that no more than `N` operations run simultaneously.
4. **Create a Multi-Step Transaction Wizard with Dynamic Validation**
   * *The Task:* Implement a wizard component (Amount -> Beneficiary Info -> Fraud Disclaimer -> Confirm). Ensure the state contract is isolated cleanly per step and deep object state updates do not trigger UI stuttering.
5. **Build a Secure Context-Driven PII Masking Wrapper**
   * *The Task:* Build a React Context provider and structural high-order components/hooks that check user role permissions (e.g., Tier-1 Analyst vs Admin) and automatically mask, blur out, or disable sensitive fields like customer bank details.
6. **Build an Interactive 2FA OTP Input Grid**
   * *The Task:* Create a 6-box security code entry component. You must implement automatic focus shifting to the next box upon typing, backward deletion focus tracking, clipboard copy-paste handling, and a synchronized countdown timer.
7. **Create a Custom Hook for Controlled API Polling with Exponential Backoff**
   * *The Task:* Write a reusable React hook that polls a transaction approval endpoint every few seconds. It must feature automatic backoff intervals, max attempt failure cleanups, and clean components for manual pause/resume actions.
8. **Build an Expandable Transaction Graph Tree Viewer**
   * *The Task:* Given a raw JSON payload of linked proxy accounts and transfers, map it into an efficient, interactive tree view that allows fraud analysts to expand/collapse payment chains without re-rendering the entire viewport.
9. **Build a Dynamic Form Generator from a Backend Metadata JSON**
   * *The Task:* Take a dynamic JSON schema sent from the backend describing variable compliance questions and map it cleanly into a functional React form using native controls and structural regex validations.
10. **Implement a Virtualized Historical Log Table**
    * *The Task:* Build a historical list component displaying thousands of fraud logs. Optimize memory usage by ensuring DOM elements are only rendered for items currently within the user's visible viewport boundary.

---

## 📈 Round 4: The Engineering Product Round (Behavioral)
*This unique, highly critical round evaluates your **Product Mindset**. It is often conducted by Product Managers or Product Leads. They want to see that you understand the business impact of your architectural choices, know how to measure success with real metrics, and look out for the end-user.*

1. **Tell me about a time you used technical data to change a feature decision made by a Product Manager.**
   * *Preparation Focus:* Think of a time at BICS when you pulled performance data, query speeds, or error metrics to prove a PM's roadmap feature would degrade system health or cause user drop-off.
2. **Describe a scenario where you had to choose short-term technical debt to launch a feature quickly. How did you manage the risk?**
   * *Preparation Focus:* In fraud prevention, launching an immediate, simple rule to stop an ongoing attack is often better than spending months building a perfect system. Show how you managed this balance and scheduled the eventual clean-up.
3. **How do you communicate the necessity of a massive architectural refactor to non-technical business stakeholders?**
   * *Preparation Focus:* Explain how you translate technical terms into business outcomes (e.g., explaining that refactoring a slow backend database cuts checkout drop-off rates or lowers infrastructure overhead costs).
4. **Walk me through a major post-deployment incident you owned. How did you protect the user experience and what did you fix long term?**
   * *Preparation Focus:* Demonstrate absolute ownership. Focus on your rapid mitigation process, clear cross-team communication during the issue, and the structural automated testing implemented afterward.
5. **Describe a time you collaborated with deeply non-technical teams (like Compliance, Risk, or Legal) to design a software solution.**
   * *Preparation Focus:* Showcase empathy and translation skills. How did you turn complex, ambiguous financial regulations or anti-money laundering requirements into concrete software logic?
6. **How do you measure the explicit business success of the code you ship? What are your current team's core North Star metrics?**
   * *Preparation Focus:* Do not just say "the code worked." Connect your work directly to high-level goals: *"We optimized our data consumer pipeline, which reduced transaction false-positives by X%, saving our support team Y hours of manual reviews."*
7. **Tell me about a time you disagreed with the technical direction proposed by another senior engineer or architect. How did you find alignment?**
   * *Preparation Focus:* Wise has a very flat hierarchy. Avoid personal conflict stories; show how you structured collaborative experiments, benchmarked performance metrics together, and made an objective, data-driven choice.
8. **Give an example of a project where you recognized a hidden friction point for the customer and took the initiative to fix it yourself.**
   * *Preparation Focus:* This displays true product ownership. Emphasize how you looked past your backend code tickets, noticed a poor end-user flow, and coordinated with design or product to fix the system proactively.
9. **How do you approach mentoring junior team members and managing code review quality without becoming a bottleneck?**
   * *Preparation Focus:* Highlight building scalable engineering habits: setting up clear automated linting pipelines, conducting system design reviews before coding begins, and mentoring through pairing rather than nitpicking pull requests.
10. **Why do you want to transition from telecom tech at BICS to global fintech at Wise, and what does our mission of "Money Without Borders" mean to you?**
    * *Preparation Focus:* Ground your answer in Wise's actual values: driving down costs for international customers, maximizing transparency, and eliminating predatory hidden exchange fees.