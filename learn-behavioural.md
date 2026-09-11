# Learn Behavioral

## Introduction

Hi, I'm Rohit. I'm currently working as a Senior Java Full-Stack Developer at BICS, a telecom company, and I have over 9 years of experience in software engineering.

I've worked across different domains, including fintech and e-commerce, and my core expertise is in Java, Spring Boot, React, AWS, distributed systems, and event-driven architectures. I've primarily worked on building scalable backend systems and full-stack applications.

I'm now looking for an opportunity where I can work on technically challenging problems at scale and have a stronger impact on the product, which is one of the reasons I'm particularly interested in Wise.

## Why Wise

There are a few reasons I'm interested in Wise.

First, Wise is solving a very real and complex problem at global scale, and that's something I'm looking for in my next role. I have spent the last several years building scalable systems at BICS, where we work with operators across different countries, so I'm familiar with the complexity that comes with connecting systems across borders.

I also have previous experience in fintech, so the financial domain is something I'm genuinely interested in. What particularly attracted me to this role is the strong backend focus. I've spent most of my career working on backend systems, distributed systems, and scalable architectures, while still having full-stack experience.

So for me, Wise is a good combination of the kind of technical challenges I enjoy, a domain I'm interested in, and an opportunity to work at a much larger global scale.

## Why are you looking to leave your current company?

I've had a very good experience at BICS and I've learned a lot there, particularly working on distributed and scalable systems in a global environment.

At this stage of my career, though, I'm looking for a new challenge where I can work on more complex problems and operate at a larger global scale. I also feel that this is a good time for me to explore an international opportunity and experience working in a different environment.

So It's more about the next stage of my career, and I feel that an opportunity like Wise aligns very well with what I'm looking for.

## What is the measure of success?

I would measure success mainly by looking at whether we're reducing scam losses without creating too much friction for genuine customers.

For example, I'd look at how much money we're preventing from being lost to scams, how many scams we're detecting, and how many legitimate transactions we're accidentally blocking or delaying.

So for me, success is not just stopping more scams. It's finding the right balance between protecting customers and giving genuine customers a smooth experience.

## Why are you looking to move to Tallinn / Estonia?

I've had a great experience working with different companies in India, and at this stage of my career, I'm looking to broaden my experience by working internationally.

I'm particularly interested in working in a global product company where I can solve challenging problems at scale and work with people from different backgrounds and cultures.

The opportunity at Wise aligns very well with what I'm looking for, so the international move and the role itself both are important factors for me.

## What are you looking for in your next role?

At this stage of my career, I'm looking for three things.

First, I want to work on technically challenging problems at a larger global scale, particularly around distributed systems, backend engineering, and scalable products.

Second, I'm looking for a strong senior individual-contributor role where I can take ownership of problems, contribute to technical decisions, and also mentor other engineers.

And finally, since I'm looking to make an international move, I'd like to work in a diverse and collaborative environment where I can learn from people with different experiences and perspectives.

So overall, I'm looking for a role that gives me a combination of technical challenge, ownership, learning, and long-term growth.

## Why should we hire you?

I think I bring three things that are particularly relevant to this role.

First, I have over nine years of engineering experience, with strong expertise in Java, Spring, distributed systems, and building scalable backend systems. I've also worked across fintech and other domains, so I have experience with both the technical and business sides of building products.

Second, I bring senior-level ownership. I've worked on complex problems, collaborated across teams, mentored engineers, and been involved in technical decisions rather than focusing only on implementation.

And third, I think my experience at BICS is relevant because I've worked in a global environment where connecting systems across different countries is part of the problem we're solving. Combined with my previous fintech experience, I think that gives me a good foundation for understanding the kinds of challenges Wise is solving.

Of course, I'd still have a lot to learn about Wise's specific systems and domain, but I believe I have the technical foundation, experience, and mindset to contribute quickly and grow into the role.

## What are your strengths?

I'd say my three biggest strengths are problem-solving, collaboration, and ownership.

First, I'm good at breaking down complex problems and making them simpler. I also pay attention to the trade-offs behind technical decisions, rather than focusing only on the immediate solution.

Second, I work well with people. I've collaborated across teams and have also spent time mentoring and supporting other engineers. I enjoy creating an environment where people can work together effectively.

And third, I tend to be proactive about ownership. If I see a potential risk or something that could become a bigger problem, I try to identify it early and bring it to the team's attention rather than waiting for it to become an incident.

I'd also say I'm a quick learner, which has helped me adapt to new technologies and ways of working throughout my career.

## What is one area you are working to improve?

One area I'm actively working on is my estimation skills.

As I've taken on more complex projects, I've realized that estimating work accurately can sometimes be challenging because of technical uncertainties, dependencies, and unexpected issues.

I'm working on improving this by breaking larger tasks into smaller pieces, identifying risks and dependencies upfront, and making my assumptions clear when I provide estimates. I'm also trying to communicate those assumptions and uncertainties more clearly to the team rather than treating an estimate as an exact number.

At the same time, I've realized that as a senior engineer, it's important to continuously deepen my technical understanding and be able to articulate my reasoning clearly, especially when there are different technical trade-offs involved.

So overall, I'm working on becoming better not only at estimating the work itself, but also at communicating the reasoning and uncertainty behind those estimates.

## Tell me about a challenging situation or failure in your career and what you learned from it.

One challenging situation I faced was when I was implementing a feature where I initially chose a simpler solution because it was easier and faster to implement.

After it was implemented, we noticed that the page was taking significantly longer to load. When I investigated the issue, I found that my approach was causing a large number of database round trips, which was affecting the overall performance.

The alternative solution was more complex because it required changes to a large database table, a materialized view, and some SQL logic. Initially, I had avoided that complexity because I wanted to keep the implementation simple.

Once I understood the performance impact, I changed the approach and went with the more robust solution. It required more implementation effort, but it significantly reduced the database interaction and provided a better foundation for future changes.

The main thing I learned from that experience is that simplicity is important, but it shouldn't be evaluated only based on implementation effort. As a senior engineer, I need to consider the trade-offs between implementation complexity, performance, scalability, and long-term maintainability before making a technical decision.

Since then, I've become more conscious about validating those trade-offs early, especially when a design involves database access or other potential performance bottlenecks.

## Looking back, what would you have done differently before implementing the original solution?

Looking back, I would have done a bit more technical analysis before implementing the initial solution.

In particular, I would have evaluated the expected database access pattern and the potential performance impact, rather than focusing mainly on how simple the implementation would be.

Even a small proof of concept or performance test with realistic data would probably have exposed the number of database round trips and helped me identify the bottleneck earlier.

So today, when I'm making a technical decision, especially one that involves database access or scalability, I try to validate the important assumptions upfront and consider the trade-offs before committing to the implementation.

## Tell me about a time when you had a disagreement with a colleague or teammate.

In one of the projects, we were migrating a routing configuration system from a legacy JSF and Spring application to Spring Boot and React.

During the design discussion, we had a disagreement about what information should be included in the request payload. One of my colleagues suggested sending the existing configuration along with the new or changed configuration.

I had a different view. Since the existing configuration could already be derived on the backend, I felt that sending it from the frontend wasn't necessary. The payload was already relatively large, so sending the complete configuration could increase network usage and potentially create performance issues as the system scaled.

I suggested that we send only the changed configuration and derive the existing configuration on the server side. That would reduce the payload size, lower network bandwidth requirements, and avoid unnecessary data transfer.

I explained the trade-offs to the team, particularly the potential impact at scale, and we discussed the alternative approach. After considering those points, we agreed to send only the changed configuration and handle the existing configuration on the backend.

The main thing I took away from that experience is that technical disagreements are usually resolved better by focusing on the trade-offs and the underlying problem rather than trying to prove that one person is right. At a senior level, I think the goal should be to help the team arrive at the best decision, even if the final solution is different from your initial preference.

## What if your colleague still disagreed with you after you explained your reasoning?

If my colleagues still disagreed after we discussed the trade-offs, I would first try to understand their concerns and make sure we're evaluating the solution against the same criteria.

If the disagreement was still mainly around something measurable, such as performance or scalability, I would try to validate the assumptions with data. For example, I could build a small proof of concept or run a performance test comparing the two approaches.

Then I would share the results with the team and use that evidence to make the decision rather than relying on personal opinions.

And if both approaches had reasonable trade-offs, I'd be comfortable aligning with the team's final decision, even if it wasn't my preferred solution.

## Tell me about a time when you took ownership of something beyond your immediate responsibilities.

One example was when we had a new Product Owner who was part of another entity within our organization, and she needed access to some of our internal tools.

This wasn't something that I was directly responsible for, and there wasn't an established process for giving people from another entity access to these internal tools. Since she had approached me about the problem, I decided to take ownership of finding a solution rather than simply directing her to another team.

I initiated discussions with our DevOps team and a Principal Engineer to understand how we could solve this in a secure and reusable way. We eventually worked on setting up an identity-federation approach, where users from another entity could authenticate through their own identity provider and, after successful authentication and authorization, get appropriate access to our internal tools.

My role wasn't to implement the entire identity-federation setup myself. My contribution was identifying the gap, bringing the right people together, and helping drive the solution until we had a proper process in place.

What I liked about this experience was that the original problem was specific to one person, but we were able to turn it into a more general process that could support similar situations in the future.

For me, that's an important part of ownership as a senior engineer: if I see a problem that affects the team's ability to work, even if it isn't formally assigned to me, I try to help drive it toward a solution.

## What was the outcome or impact of this initiative?

The immediate outcome was that we were able to set up the required access for the Product Owner.

More importantly, we established a reusable process for users from other entities within the organization who may need similar access in the future. Previously, there wasn't a defined process for this, so each request could require a lot of coordination.

Now, we have a clearer approach for handling these requests, which reduces the friction for both the users and the teams involved. So although the initial problem was for one person, the solution addressed a broader organizational gap.

## Tell me about a time you worked under pressure or had a tight deadline?

One example was when I was working on a feature with a tight deadline, and in the middle of the work, we received a production issue from a customer who was having problems uploading a large Excel file.

I immediately investigated the production issue and identified that the problem was related to the size of the file. I looked for a way to unblock the customer without immediately interrupting the committed work. We identified a workaround where the customer could split the file into smaller parts and upload them separately.

At the same time, I didn't want the workaround to become the permanent solution, so I discussed the issue with the team and proposed that we address the underlying problem properly. We agreed to plan the permanent fix after completing the immediate committed work.

By prioritizing the customer issue appropriately, providing a workaround, and planning the permanent solution separately, we were able to address the customer's immediate problem while still delivering the feature that was committed for the sprint.

The experience reinforced for me that working under pressure isn't necessarily about doing everything immediately. It's about understanding the impact, identifying what genuinely needs immediate attention, looking for safe workarounds, and then prioritizing the permanent solution appropriately.

## How do you generally prioritize when you have a production issue and a committed deadline?

I first assess customer impact, severity, business impact, and urgency. Then I look for a safe workaround and determine whether the issue needs immediate attention or can be planned. I also consider whether work can be delegated or whether the committed deadline needs to be renegotiated. The important thing is to make the trade-off explicit rather than simply dropping the planned work whenever something urgent comes up.

## Tell me about a time you mentored or helped another engineer grow.

One example from my recent experience was when my company was building a new messaging team in India. There were already distributed teams working from different locations, but I was one of the first engineers to join the new team in India.

As I was one of the first people joining, I went through a lot of challenges while understanding the system, the processes, and the existing architecture. When new engineers joined later, I didn't want them to go through the same challenges again.

So I created documentation around the system, the development process, and some of the common challenges I had faced. I also helped new team members understand the architecture and technology, and I regularly supported them through discussions and pair programming.

Earlier in my career, I also had a similar experience at a startup where I mentored freshers. I helped them understand the system and technology through documentation, knowledge-sharing sessions, and pair programming. Over time, they became comfortable enough to implement features end-to-end independently.

So mentoring has been something I've consistently done throughout my career. For me, good mentoring isn't about solving the problem for someone. It's about helping them understand the problem and the system well enough that they can solve similar problems independently in the future.

## How do you mentor someone who is struggling, but you don't have much time yourself?

If I have someone I'm mentoring but the team is under time pressure, I would first make the situation visible rather than trying to handle everything on my own.

For example, I could raise it during stand-up and discuss with the team how we can allocate some focused time for mentoring without affecting the most critical deliverables. I might reserve a specific time for pair programming, debugging together, or walking through a design.

At the same time, I try to make mentoring part of the normal workflow. For example, I can involve the person in code reviews or design discussions, or help them understand a problem while we're already working on it, rather than always scheduling separate sessions.

My goal would be to give them enough guidance to become independent, while also making sure the team's delivery commitments are not affected. If the mentoring requires more time than we can reasonably accommodate, I'd discuss the priority and trade-off with the team rather than silently taking on additional work.

## How do you handle receiving negative feedback or criticism?

There was a time when I received feedback from my manager that one of my presentations was too technical.

The audience was mixed, with both technical and non-technical people, and I had focused more on explaining the technical details rather than first giving enough context and explaining the key points at the right level for everyone.

I took that feedback positively and started being more conscious about understanding my audience before communicating. Before a presentation or a team discussion, I now think about who I'm speaking to, what context they already have, and what level of detail they actually need.

I've also applied the same thinking to other forms of communication, such as meetings and written communication. Over time, it has become a natural part of how I communicate.

The main thing I learned is that effective communication isn't just about explaining something correctly. It's also about explaining it in a way that is appropriate for the audience.

## How do you handle feedback you disagree with?

During one of my one-on-one discussions with my manager, my manager gave me feedback that I should focus more on the testing and automation side to reduce the manual effort involved in testing.

Initially, I disagreed with the feedback because I felt that I had already been contributing significantly in areas such as unit testing, integration testing, and test automation. So I shared a few specific examples of the work I had been doing.

During the discussion, we realized that there was actually a gap in understanding. My manager had a different perspective on my contribution to automation than I did based on the work I had been doing.

What I learned from that experience is that doing good work is not always enough. You also need to make your work and its impact visible to the people you work with, especially your manager. If something isn't visible, it can create a gap between the work you're actually doing and how your contribution is perceived.

Since then, I've become more conscious about communicating my contributions, progress, and impact rather than assuming that everyone is aware of what I'm working on.

## How do you handle competing priorities?

*(Reuse production incident answer, then add the following.)*

I usually prioritize based on customer impact, business impact, urgency, and the effort involved. I first understand which items genuinely require immediate attention and which can be planned. I also consider whether something can be delegated or whether we need to adjust the existing commitment. If there are significant trade-offs, I discuss them with the relevant stakeholders and make sure expectations are aligned.

## Why should we hire you over other candidates?

I think what differentiates me is the combination of strong technical depth, broad experience, and adaptability.

I have over nine years of experience, with strong expertise in Java, Spring, distributed systems, and scalable backend systems, while also having hands-on full-stack experience and exposure to technologies like JavaScript, Node.js, and C++.

I've also worked across different domains, including fintech and e-commerce, and with distributed global teams. At BICS, I've worked in a global environment where connecting systems and services across different countries is part of the problem we're solving. While the product is different from <Target Company>, I think that experience gives me useful context for a global, cross-border product.

Beyond the technical side, I've taken ownership beyond my immediate responsibilities, worked across teams, mentored engineers, and dealt with different kinds of technical and business challenges throughout my career.

So I think the combination of technical depth, breadth of experience, global collaboration, and the ability to adapt quickly to new problems is what I would uniquely bring to the Wise team.

## Where do you see yourself in 3–5 years?

In the next three to five years, I want to grow into a stronger technical leadership role where I'm making technical decisions that have a direct impact on the business and the customers.

I want to be involved in larger and more complex problems, contribute to architectural and technical decisions, and be able to evaluate trade-offs and make decisions that improve the product and customer experience.

At the same time, I want to continue mentoring engineers and helping them become more independent, so that I'm not only contributing through my own work but also helping the people around me grow.

Longer term, I'm open to taking on people-management responsibilities as well, but my immediate focus is becoming a strong technical leader with broader ownership and impact.

So overall, in three to five years, I'd like to be in a position where I have significant technical ownership, I'm influencing important product and engineering decisions, and I'm helping both the team and the business grow.

## What motivates you as an engineer?

What motivates me most as an engineer is seeing the positive impact of what I build.

That impact can come in different forms. It could be improving the customer experience, solving an important business problem, improving revenue or efficiency, or making a product more reliable and scalable.

I'm also motivated by helping people. For example, if someone is struggling with a technical problem and I can help them understand it or find a solution, and I see that they become more confident or independent, that gives me a strong sense of achievement.

I also enjoy taking new ideas and thinking about how they can be applied to an existing product or business to create a better outcome. For me, the most rewarding part is seeing that the engineering decisions and collaboration actually lead to something positive.

So, if I had to summarize it, the impact I create through engineering, whether for customers, the business, or the people I work with, is what motivates me most.

## Describe a situation you messed up and the steps taken to rectify the mistakes.

*(Already answered in: "Tell me about a challenging situation or failure in your career and what you learned from it.")*

## How do you prioritize what to build?

I usually prioritize what to build based on customer impact, business impact, urgency, effort, and the risks or dependencies involved.

First, I try to understand the problem we're solving and the expected outcome. Then I look at how many customers are affected, how significant the problem is, and what business value we expect from solving it.

I also consider the effort and technical complexity involved. If two initiatives have similar impact, but one can be delivered significantly faster or enables other important work, that can influence the priority.

For competing priorities, I discuss the trade-offs with Product and the relevant engineering teams rather than making the decision in isolation. I also consider things like reliability, security, compliance, and technical debt when they have a meaningful impact on customers or the business.

So I don't prioritize simply based on what is most urgent or easiest to build. I try to maximize the value and impact we can deliver while making the trade-offs explicit.

## Why this particular role/team at Wise?

What particularly attracted me to this role is the combination of the technical challenges and the direct customer impact.

The Scam Prevention team is solving a very meaningful problem: protecting customers from scams and helping secure their money. I find that particularly interesting because it combines engineering with a real customer and business problem. You have to think about things like real-time detection, automation, scalability, and also how to protect customers without creating unnecessary friction for genuine transactions.

From a technical perspective, the role also aligns very well with my experience. It's strongly backend focused, which matches most of my experience in Java, Spring, distributed systems, and scalable systems, while still giving me the opportunity to use my full-stack experience with React.

What I particularly like is the ownership aspect of the role. It's not just about implementing a technical solution. The role involves understanding the customer problem, making data-driven decisions, considering trade-offs, and working with Product, Data Science, and Investigations to solve the problem end-to-end.

That's the kind of role I'm looking for at this stage of my career: technically challenging problems where the decisions I make can directly improve customer security and have a measurable impact on the product and the business.

## Tell me about a project you're particularly proud of and the impact it had.

One project I'm particularly proud of was separating a critical barring service from a monolithic application at BICS.

The monolith contained multiple domains, including routing and barring, and they were tightly coupled. This created a significant reliability problem because the monolith was a single point of failure. Whenever there was an issue, it could affect both services, and we were receiving frequent complaints about downtime. The barring service was also business-critical because it directly impacted revenue.

I led the separation project end to end. I was involved in the architecture and design decisions, project estimation, cross-team and cross-stream collaboration, coordination with upstream and downstream teams, and the overall transition.

We separated the barring service into its own microservice and database. Since the new service was business-critical, I also designed it to run with multiple instances behind a load balancer instead of having a single instance. I set up monitoring and alerting so that we could detect failures quickly.

During the migration, we also encountered several technical challenges. For example, some scheduled operations were running multiple times after we introduced multiple instances, so I implemented distributed locking to make sure only one instance executed them. We also had some communication issues with downstream systems after upgrading the service from Java 8 to Java 17, which I investigated and resolved.

We used a gradual migration approach, following the strangler pattern, so that we could transition without disrupting the existing system. I also created architecture documentation and diagrams and gave a technical demo to the team to make the new architecture easier to understand.

The outcome was that we removed the single point of failure, significantly improved the availability of the barring service, and separated it from routing so the two services could evolve independently. We also stopped receiving the recurring downtime complaints we had seen with the monolith.

For me, what makes this project particularly meaningful is that it wasn't just a technical modernization exercise. It directly improved reliability for a business-critical service, reduced customer impact, and allowed the teams to work more independently. I also had ownership of the project from the initial design through implementation and transition, which is something I'm particularly proud of.

## Overall HR Questions

- Tell me about yourself / Walk me through your career.
- Why Wise?
- Why are you leaving BICS?
- Why this particular role/team at Wise?
- Why Tallinn / Estonia?
- What are you looking for in your next role?
- Why are you a strong fit for this role, and what differentiates you from other candidates?
- What motivates you as an engineer?
- Tell me about a project you're particularly proud of and the impact it had.
- Tell me about a mistake or failure, what you did to fix it, and what you learned.
- Tell me about a disagreement or conflict with a colleague or manager and how you handled it.
- Tell me about a time you took ownership beyond your immediate responsibilities.
- Tell me about a time you had to work under pressure or balance competing priorities.
- Tell me about a time you mentored or helped another engineer grow.
