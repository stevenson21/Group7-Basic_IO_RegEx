# Group7-Basic IO and RegEx

# Energy Management System

Overview This project is an energy management system developed to simulate data logging and metadata management. The system manages log files for different energy sources (e.g., solar, wind, etc.) and charging stations, simulates data exchange, and provides user interaction to search and retrieve log data based on equipment name or date. The system is designed to support the creation, movement, deletion, and archiving of log files and includes metadata tracking of these operations.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Task Distribution](#Task-Distribution)
  - [Log Management](#Log-Management)
  - [Data Exchange](#Data-Exchange)
  - [User Interaction and Search Functionality](#Search-Functionality)
  - [Metadata and Project Integration](#Metadata)
- [Link and Nat no.](#link-and-mat-no)

## Features
Log management for each day, charging station, and energy source Simulation of data exchange using byte and character streams User interaction for opening log files based on equipment name or date Metadata management to track log operations (create, move, delete, archive) Regular expression-based search functionality

## Installation
1. **Clone the repository**:
    ```bash
    Compile the project using Eclipse IDE.
    Run the main class (Main.java) to simulate the energy management system.
    Use the console interface to interact with the system and search for logs.
    ```

2. **Set up the project**:
    If you're using an IDE (such as IntelliJ IDEA or Eclipse), you can import the project directly. Otherwise, compile and run the Java files manually using the `javac` and `java` commands.

    ```bash
    javac *.java
    ```

3. **Make sure you have Java 8 or higher installed** to run the program.

## Usage
### Log Management
Log Management (Mohammed) Responsible for creating, moving, deleting, and archiving log files. Simulated the creation of log files for each day, each charging station, and each energy source. Implemented file operation methods and metadata tracking.

### Data Exchange
Data Exchange Simulation (Onyedikachi): Focused on simulating the data exchange using byte and character streams. Handled reading and writing of energy data to log files. Ensured that the data streams could interact with the file system and logs created by Mohammed.

### User Interaction and Search Functionality
User Interaction and Search Functionality (Stevenson): Implemented functionality to allow users to search for log files based on equipment name or date. Utilized regular expressions to facilitate log file searches and display content. Managed the user interface and handled input/output interactions through the console.

### Metadata and Project Integration
Metadata and Project Integration (Junaid Ahmad -7222074): Managed the metadata system to track file operations like creation, deletion, movement, and archiving. Integrated all components: log management, data exchange, and user search functionality. Handled the tracking of operations and ensured that metadata logs were correctly generated.


## Link and Matriculation no.
Stevenson Isaac - 7222017 

Screencast Link HA Basic IO and RegEx
 https://drive.google.com/file/d/1AY6SkHqyhPUwaEjknNUR7Br-koyN621V/view?usp=sharing
