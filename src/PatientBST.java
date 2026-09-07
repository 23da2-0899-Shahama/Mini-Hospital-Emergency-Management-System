public class PatientBST {

    private class Node {

        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    // Insert a new patient
    public void insert(Patient patient) {

        root = insertNode(root, patient);

        System.out.println("Patient added successfully.");
    }

    private Node insertNode(Node root, Patient patient) {

        if (root == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertNode(root.left, patient);
        }
        else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertNode(root.right, patient);
        }
        else {
            System.out.println("Patient ID already exists.");
        }

        return root;
    }

    // Search patient
    public Patient search(int patientId) {

        Node result = searchNode(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchNode(Node root, int patientId) {

        if (root == null || root.patient.getPatientId() == patientId) {
            return root;
        }

        if (patientId < root.patient.getPatientId()) {
            return searchNode(root.left, patientId);
        }

        return searchNode(root.right, patientId);
    }

    // Display patients in ascending order
    public void displayInOrder() {

        if (root == null) {
            System.out.println("No patients found.");
            return;
        }

        inOrder(root);
    }

    private void inOrder(Node root) {

        if (root != null) {

            inOrder(root.left);

            root.patient.displayPatient();

            inOrder(root.right);
        }
    }

    // Delete patient
    public void delete(int patientId) {

        if (search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        root = deleteNode(root, patientId);

        System.out.println("Patient deleted successfully.");
    }

    private Node deleteNode(Node root, int patientId) {

        if (root == null) {
            return null;
        }

        if (patientId < root.patient.getPatientId()) {

            root.left = deleteNode(root.left, patientId);
        }
        else if (patientId > root.patient.getPatientId()) {

            root.right = deleteNode(root.right, patientId);
        }
        else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node successor = findMinimum(root.right);

            root.patient = successor.patient;

            root.right = deleteNode(
                    root.right,
                    successor.patient.getPatientId()
            );
        }

        return root;
    }

    private Node findMinimum(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}