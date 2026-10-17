# CS 320 Software Testing and Automation Portfolio

## Overview

This repository contains my portfolio artifacts for CS 320: Software Test, Automation, and Quality Assurance. The included Java source files and JUnit tests demonstrate the implementation and verification of a contact management service, while the Project Two report evaluates the effectiveness of unit testing, code coverage, and different software testing strategies.

Together, these artifacts demonstrate my ability to translate software requirements into testable conditions, develop automated tests to identify defects, and evaluate software functionality, reliability, and maintainability.

## Portfolio Artifacts

**Project One – Contact Service Implementation and Testing**

- `Contact.java`: Defines the contact data model and enforces validation requirements for contact identifiers, names, phone numbers, and addresses.
- `ContactService.java`: Implements in-memory contact management using a HashMap, supporting contact creation, retrieval, updates, and deletion while enforcing unique identifiers.
- `ContactTest.java`: Contains JUnit tests verifying constructor validation, field constraints, boundary values, and setter behavior.
- `ContactServiceTest.java`: Contains JUnit tests verifying service operations, duplicate ID handling, invalid input rejection, and successful record modifications.

**Project Two – Summary and Reflections Report**

- `Project 2 Report.docx`: Evaluates the testing strategies developed throughout Project One, including 97 JUnit test methods across the contact, task, and appointment services. The report examines code coverage, requirements-based testing, boundary value analysis, test effectiveness, and opportunities for improving software quality.

## Technologies and Testing Techniques

- Java
- JUnit 5
- Object-Oriented Programming
- Unit Testing and Test Automation
- Boundary Value Analysis
- Equivalence Partitioning
- Negative Testing and Input Validation
- Code Coverage and Conditional Branch Analysis

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

I ensure software functionality and security by treating requirements as measurable conditions and verifying both expected behavior and invalid input handling. In Project One, I used JUnit tests to verify field constraints, unique identifiers, and contact management operations. I applied boundary value analysis and negative testing to identify potential defects that might otherwise go unnoticed during normal execution.

In Project Two, I evaluated 97 test methods across six test classes, achieving 100% line and conditional branch coverage through local instrumentation. Although these results demonstrate thorough execution of the implemented logic, they also reinforced that code coverage alone cannot guarantee defect-free software. Maintaining software quality requires continued testing, careful input validation, independent review, and regression testing as requirements evolve.

### How do I interpret user needs and incorporate them into a program?

I interpret user needs by translating functional requirements into clearly defined behaviors and constraints that can be implemented and tested. For the contact service, requirements such as unique contact identifiers, maximum field lengths, and properly formatted phone numbers established specific validation rules. These rules informed both the implementation and the automated tests used to verify compliance.

I also recognize the importance of considering invalid or unexpected user interactions rather than testing only successful operations. By developing tests for null values, duplicate identifiers, malformed inputs, and nonexistent records, I can evaluate whether the program behaves consistently with its requirements and protects the integrity of its data.

### How do I approach designing software?

I approach software design by breaking requirements into manageable components with clearly defined responsibilities. In Project One, I separated the contact data model from the service responsible for managing records. This structure allowed validation logic to remain within the Contact class while the ContactService class handled storage and record operations, improving organization and testability.

I also consider testing during the design process rather than treating it as a final step. Developing independent unit tests for constructors, setters, and service operations helped isolate defects and evaluate individual requirements. Moving forward, I intend to incorporate automated regression testing, continuous integration, and additional testing techniques to improve reliability and maintainability as software becomes more complex.

## Author

Tristin Claus
