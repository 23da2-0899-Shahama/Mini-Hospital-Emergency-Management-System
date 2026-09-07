import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    // Each patient can have their own visit history
    static VisitLinkedList[] visitHistories = new VisitLinkedList[1000];

    public static void main(String[] args) {

        int choice;

        do {

            displayMainMenu();

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    emergencyQueueMenu();
                    break;

                case 3:
                    treatmentStackMenu();
                    break;

                case 4:
                    visitHistoryMenu();
                    break;

                case 5:
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // ================= MAIN MENU =================

    public static void displayMainMenu() {

        System.out.println("\n==============================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Patient Records (BST)");
        System.out.println("2. Emergency Queue");
        System.out.println("3. Treatment History (Stack)");
        System.out.println("4. Patient Visit History (Linked List)");
        System.out.println("5. Exit");
        System.out.println("==============================================");
    }

    // ================= PATIENT BST MENU =================

    public static void patientMenu() {

        int choice;

        do {

            System.out.println("\n========== PATIENT RECORDS ==========");
            System.out.println("1. Add New Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Back to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // Add patient
    public static void addPatient() {

        int patientId = getIntInput("Enter Patient ID: ");

        if (patientBST.search(patientId) != null) {

            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = getIntInput("Enter Age: ");

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                patientId,
                name,
                age,
                contact,
                condition
        );

        patientBST.insert(patient);

        // Create visit history for this patient
        if (patientId >= 0 && patientId < visitHistories.length) {
            visitHistories[patientId] = new VisitLinkedList();
        }
    }

    // Search patient
    public static void searchPatient() {

        int patientId = getIntInput("Enter Patient ID to search: ");

        Patient patient = patientBST.search(patientId);

        if (patient != null) {

            System.out.println("\nPatient found:");
            patient.displayPatient();

        } else {

            System.out.println("Patient not found.");
        }
    }

    // Delete patient
    public static void deletePatient() {

        int patientId = getIntInput("Enter Patient ID to delete: ");

        patientBST.delete(patientId);
    }

    // ================= EMERGENCY QUEUE MENU =================

    public static void emergencyQueueMenu() {

        int choice;

        do {

            System.out.println("\n========== EMERGENCY QUEUE ==========");
            System.out.println("1. Add Patient to Queue");
            System.out.println("2. Treat Next Patient");
            System.out.println("3. Display Waiting Patients");
            System.out.println("4. Back to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    addPatientToQueue();
                    break;

                case 2:
                    treatNextPatient();
                    break;

                case 3:
                    emergencyQueue.displayQueue();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    // Add patient to emergency queue
    public static void addPatientToQueue() {

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient does not exist.");
            System.out.println("Please register the patient first.");

            return;
        }

        emergencyQueue.enqueue(patient);
    }

    // Treat next patient
    public static void treatNextPatient() {

        Patient patient = emergencyQueue.dequeue();

        if (patient == null) {
            return;
        }

        System.out.println("\nTreating patient:");
        patient.displayPatient();

        System.out.println("Treatment can now be completed and recorded.");
    }

    // ================= TREATMENT STACK MENU =================

    public static void treatmentStackMenu() {

        int choice;

        do {

            System.out.println("\n========== TREATMENT HISTORY ==========");
            System.out.println("1. Add Completed Treatment");
            System.out.println("2. Remove Latest Treatment");
            System.out.println("3. Display Treatment History");
            System.out.println("4. Back to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    addTreatment();
                    break;

                case 2:
                    removeLatestTreatment();
                    break;

                case 3:
                    treatmentStack.displayStack();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    // Add treatment
    public static void addTreatment() {

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        int treatmentId = getIntInput("Enter Treatment ID: ");

        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Treatment Details: ");
        String treatmentDetails = scanner.nextLine();

        Treatment treatment = new Treatment(
                treatmentId,
                patientId,
                patient.getPatientName(),
                doctorName,
                treatmentDetails
        );

        treatmentStack.push(treatment);
    }

    // Remove latest treatment
    public static void removeLatestTreatment() {

        Treatment treatment = treatmentStack.pop();

        if (treatment != null) {

            System.out.println("\nRemoved Treatment:");
            treatment.displayTreatment();
        }
    }

    // ================= VISIT HISTORY MENU =================

    public static void visitHistoryMenu() {

        int patientId = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        if (patientId < 0 || patientId >= visitHistories.length) {

            System.out.println("Invalid Patient ID for visit history.");
            return;
        }

        if (visitHistories[patientId] == null) {
            visitHistories[patientId] = new VisitLinkedList();
        }

        VisitLinkedList history = visitHistories[patientId];

        int choice;

        do {

            System.out.println("\n========== VISIT HISTORY ==========");
            System.out.println("Patient: " + patient.getPatientName());
            System.out.println("1. Add Visit");
            System.out.println("2. Search Visit");
            System.out.println("3. Remove Visit");
            System.out.println("4. Display Visit History");
            System.out.println("5. Back to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    addVisit(history);
                    break;

                case 2:
                    searchVisit(history);
                    break;

                case 3:
                    removeVisit(history);
                    break;

                case 4:
                    history.displayVisits();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // Add visit
    public static void addVisit(VisitLinkedList history) {

        int visitId = getIntInput("Enter Visit ID: ");

        if (history.searchVisit(visitId) != null) {

            System.out.println("Visit ID already exists.");
            return;
        }

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        history.addVisit(visit);
    }

    // Search visit
    public static void searchVisit(VisitLinkedList history) {

        int visitId = getIntInput("Enter Visit ID to search: ");

        Visit visit = history.searchVisit(visitId);

        if (visit != null) {

            System.out.println("\nVisit found:");
            visit.displayVisit();

        } else {

            System.out.println("Visit not found.");
        }
    }

    // Remove visit
    public static void removeVisit(VisitLinkedList history) {

        int visitId = getIntInput("Enter Visit ID to remove: ");

        history.removeVisit(visitId);
    }

    // ================= INPUT METHOD =================

    public static int getIntInput(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value = Integer.parseInt(scanner.nextLine());

                return value;

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }
}