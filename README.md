# Software Testing For JPacman Game

*Hi all, welcome to the JPacman framework to learn Software Verification and Testing!*

## Introduction

This is a Pacman-like game used for learning software testing. Parts of the original code forked from [UBC-TestingCourse/jpacman-framework](https://github.com/UBC-TestingCourse/jpacman-framework) are well tested, whereas others are left untested intentionally.

Through the whole project, I extended some test suite, or use the framework to build extensions in a test-driven way.

## Learning Objectives
To learn fundamental concepts and challenges with emphasis on:
- principles of software testing,
- static and dynamic analysis,
- different levels of testing including unit, integration, system testing,
- regression testing, test selection and prioritization,
- test adequacy analysis,
- different coverage criteria,
- fault-based analysis and mutation testing,
- control-flow analysis,
- data-flow analysis,
- static bug checkers,
- problem tracking, debugging, and fault localization,
- program repair,
- testing domain-specific software systems such as web app testing, mobile app testing, GUI
testing,
- automation and tool building.

## Install Software
If you plan to run the project on your own machine/laptop follow these instructions.
- Java 8 is a requirement. Install Java 8 if you don’t have it installed.

- Install a recent version of an IDE such as Eclipse from http://www.eclipse.org/downloads/ (you can
also use Intellij from https://www.jetbrains.com/idea/).

- We will use Apache Maven to build and manage the dependencies of our Java projects. Install Maven on
your machine: http://maven.apache.org


## Run Project
- After gitting clone to your own directory, in that directory run: ```mvn compile``` to make sure everything is working.
- Then to run the test suites, run `mvn test`
- Import this project into **Eclipse** or **IntelliJ** as a **Maven Project**.  
  - To import JPacman into **Eclipse**: go to ```File -> Import...```, and choose ```Existing maven projects```. Find the JPacman directory you have cloned and
select it for import.
- Now from **Eclipse**, run `org.jpacman.framework.ui.MainUI` as a **Java Application** in **Eclipse**.
