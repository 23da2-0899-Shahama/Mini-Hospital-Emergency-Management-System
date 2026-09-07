# Mini Hospital Emergency Management System

## Introduction

The Mini Hospital Emergency Management System is a Java console application developed using different data structures.

The system is designed to manage basic hospital activities such as patient records, emergency patients, treatment history and patient visit history.

## Objectives

The main objectives of this project are:

* To implement different data structures using Java.
* To manage patient records.
* To manage emergency patients using a Queue.
* To store treatment history using a Stack.
* To store patient visit history using a Singly Linked List.
* To understand how data structures can be used in a real-world system.

## Technologies Used

* Java
* Visual Studio Code
* Git
* GitHub

## Data Structures Used

### 1. Binary Search Tree

A Binary Search Tree is used for patient records.

Patient ID is used as the key.

Operations:

* Insert patient
* Search patient
* Delete patient
* Display patients in ascending Patient ID order

### 2. Queue

A Queue is used for emergency patients.

The Queue follows FIFO (First In, First Out).

Operations:

* Enqueue patient
* Dequeue patient
* Display waiting patients
* Check empty queue

### 3. Stack

A Stack is used for treatment history.

The Stack follows LIFO (Last In, First Out).

Operations:

* Push treatment
* Pop latest treatment
* Display treatment history
* Check empty stack

### 4. Singly Linked List

A Singly Linked List is used for patient visit history.

Each visit contains:

* Visit ID
* Visit Date
* Doctor Name
* Diagnosis
* Treatment

Operations:

* Add visit
* Search visit
* Remove visit
* Display visit history

## Main Features

The system provides the following main features:

1. Patient Records
2. Emergency Queue
3. Treatment History
4. Patient Visit History

## Project Structure

```text
Mini-Hospital-Emergency-Management-System
│
├── src
│   ├── Main.java
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── Treatment.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   └── VisitLinkedList.java
│
├── README.md
├── 7.png
├── 8.png
├── 9.png
├── 10.png
└── 11.png
```

## How to Run the Project

Open the project folder in Visual Studio Code.

Open the terminal and compile the Java files:

```text
javac src/*.java
```

Then run the main program:

```text
java -cp src Main
```

The main menu will be displayed in the terminal.

## Testing

The system was tested using different operations.

### Patient Records

Patient records were added, searched, deleted and displayed using the Binary Search Tree.

### Emergency Queue

Patients were added to the Queue and treated according to FIFO order.

### Treatment Stack

Treatment records were added and removed according to LIFO order.

### Patient Visit History

Visits were added, searched, removed and displayed using the Singly Linked List.

Empty Queue and empty Stack conditions were also tested.

## GitHub Development

Git and GitHub were used to manage the project development.

Meaningful commits were created during development.

Examples of commits include:

* Created project structure
* Added Patient class
* Implemented emergency queue
* Implemented treatment stack
* Implemented patient visit linked list
* Added complete hospital management menu
* Added project screenshots

## Learning Reflection

Through this project, I learned how different data structures can be used for different purposes.

I also improved my Java programming skills and learned how to use Git and GitHub for version control.

## Conclusion

The Mini Hospital Emergency Management System successfully demonstrates the use of Binary Search Tree, Queue, Stack and Singly Linked List in a real-world application.

The system provides basic hospital management functions through a simple console interface.
