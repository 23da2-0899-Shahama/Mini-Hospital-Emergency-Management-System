public class VisitLinkedList {

    private class Node {

        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;

    public VisitLinkedList() {
        head = null;
    }

    // Add a new visit
    public void addVisit(Visit visit) {

        Node newNode = new Node(visit);

        if (head == null) {

            head = newNode;

        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // Search for a visit
    public Visit searchVisit(int visitId) {

        Node current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Remove a visit
    public void removeVisit(int visitId) {

        if (head == null) {

            System.out.println("Visit history is empty.");
            return;
        }

        // If the first visit needs to be removed
        if (head.visit.getVisitId() == visitId) {

            head = head.next;

            System.out.println("Visit removed successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {

                current.next = current.next.next;

                System.out.println("Visit removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Display all visits
    public void displayVisits() {

        if (head == null) {

            System.out.println("No visit history found.");
            return;
        }

        System.out.println("\n===== PATIENT VISIT HISTORY =====");

        Node current = head;

        while (current != null) {

            current.visit.displayVisit();

            current = current.next;
        }
    }

    // Check whether list is empty
    public boolean isEmpty() {

        return head == null;
    }
}