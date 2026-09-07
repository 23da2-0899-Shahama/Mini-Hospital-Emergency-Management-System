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
    }}