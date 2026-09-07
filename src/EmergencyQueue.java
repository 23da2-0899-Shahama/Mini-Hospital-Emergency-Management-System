import java.util.LinkedList;

public class EmergencyQueue {

    private LinkedList<Patient> queue;

    public EmergencyQueue() {
        queue = new LinkedList<>();
    }

    // Add patient to the queue
    public void enqueue(Patient patient) {
        queue.addLast(patient);
        System.out.println("Patient added to emergency queue.");
    }

    // Remove the next patient
    public Patient dequeue() {

        if (queue.isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = queue.removeFirst();

        System.out.println("Patient removed from emergency queue.");

        return patient;
    }

    // Display all waiting patients
    public void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("No patients are waiting in the emergency queue.");
            return;
        }

        System.out.println("\n===== EMERGENCY WAITING QUEUE =====");

        for (Patient patient : queue) {
            patient.displayPatient();
        }
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}