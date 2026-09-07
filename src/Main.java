public class Main {

    public static void main(String[] args) {

        PatientBST patientBST = new PatientBST();

        Patient p1 = new Patient(
                105,
                "Ahmed",
                25,
                "0771234567",
                "Fever"
        );

        Patient p2 = new Patient(
                101,
                "Sara",
                30,
                "0772345678",
                "Headache"
        );

        Patient p3 = new Patient(
                110,
                "Kamal",
                45,
                "0773456789",
                "Chest Pain"
        );

        // BST testing
        patientBST.insert(p1);
        patientBST.insert(p2);
        patientBST.insert(p3);

        System.out.println("\nPatients in ascending order:");
        patientBST.displayInOrder();

        System.out.println("\nSearching Patient ID 101:");

        Patient foundPatient = patientBST.search(101);

        if (foundPatient != null) {
            foundPatient.displayPatient();
        } else {
            System.out.println("Patient not found.");
        }

        System.out.println("\nDeleting Patient ID 105:");

        patientBST.delete(105);

        System.out.println("\nPatients after deletion:");
        patientBST.displayInOrder();


        // Queue testing
        System.out.println("\n\n===== EMERGENCY QUEUE TEST =====");

        EmergencyQueue emergencyQueue = new EmergencyQueue();

        emergencyQueue.enqueue(p1);
        emergencyQueue.enqueue(p2);
        emergencyQueue.enqueue(p3);

        emergencyQueue.displayQueue();

        System.out.println("\nTreating next patient:");

        Patient nextPatient = emergencyQueue.dequeue();

        if (nextPatient != null) {
            nextPatient.displayPatient();
        }

        System.out.println("\nRemaining patients:");

       // Stack testing
System.out.println("\n\n===== TREATMENT STACK TEST =====");

TreatmentStack treatmentStack = new TreatmentStack();

Treatment treatment1 = new Treatment(
        1,
        105,
        "Ahmed",
        "Dr. Perera",
        "Medication given"
);

Treatment treatment2 = new Treatment(
        2,
        101,
        "Sara",
        "Dr. Silva",
        "Blood test completed"
);

Treatment treatment3 = new Treatment(
        3,
        110,
        "Kamal",
        "Dr. Fernando",
        "Emergency treatment completed"
);

treatmentStack.push(treatment1);
treatmentStack.push(treatment2);
treatmentStack.push(treatment3);

treatmentStack.displayStack();

System.out.println("\nRemoving latest treatment:");

Treatment removedTreatment = treatmentStack.pop();

if (removedTreatment != null) {
    removedTreatment.displayTreatment();
}

System.out.println("\nTreatment history after pop:");

treatmentStack.displayStack();
   // Linked List testing
System.out.println("\n\n===== PATIENT VISIT HISTORY TEST =====");

VisitLinkedList visitHistory = new VisitLinkedList();

Visit visit1 = new Visit(
        1,
        "2026-09-01",
        "Dr. Perera",
        "Fever",
        "Medication"
);

Visit visit2 = new Visit(
        2,
        "2026-09-03",
        "Dr. Silva",
        "Headache",
        "Pain relief tablets"
);

Visit visit3 = new Visit(
        3,
        "2026-09-05",
        "Dr. Fernando",
        "Chest Pain",
        "ECG and observation"
);

visitHistory.addVisit(visit1);
visitHistory.addVisit(visit2);
visitHistory.addVisit(visit3);

visitHistory.displayVisits();

System.out.println("\nSearching for Visit ID 2:");

Visit foundVisit = visitHistory.searchVisit(2);

if (foundVisit != null) {
    foundVisit.displayVisit();
} else {
    System.out.println("Visit not found.");
}

System.out.println("\nRemoving Visit ID 1:");

visitHistory.removeVisit(1);

System.out.println("\nVisit history after removal:");

visitHistory.displayVisits();}}