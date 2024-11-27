# Process Monitor

## Overview

The Process Monitor is a Java application that displays information about the top 10 processes sorted by CPU usage. It uses the OSHI library to gather system information and display details such as process ID, type, CPU usage, memory usage, I/O usage, and whether the process is CPU-bound or I/O-bound.

## Prerequisites

- Java 21 or higher
- Maven 3.6.0 or higher

## Dependencies

The project uses the following dependencies:

- OSHI (Operating System and Hardware Information)
- SLF4J (Simple Logging Facade for Java)
- Log4j (Logging framework)

These dependencies are defined in the `pom.xml` file.

## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/process-monitor.git
    cd process-monitor
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

## Usage

To run the Process Monitor application, execute the following command:

```sh
java -cp [process-monitor-1.0-SNAPSHOT.jar](http://_vscodecontentref_/6) com.example.Main
