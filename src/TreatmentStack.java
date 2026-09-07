import java.util.Stack;

public class TreatmentStack {

    private Stack<Treatment> treatmentStack;

    public TreatmentStack() {
        treatmentStack = new Stack<>();
    }

    // Push a completed treatment
    public void push(Treatment treatment) {

        treatmentStack.push(treatment);

        System.out.println("Treatment record added to history.");
    }

    // Pop the most recently completed treatment
    public Treatment pop() {

        if (treatmentStack.isEmpty()) {

            System.out.println("Treatment history is empty.");
            return null;
        }

        Treatment treatment = treatmentStack.pop();

        System.out.println("Latest treatment record removed.");

        return treatment;
    }

    // Display treatment records
    public void displayStack() {

        if (treatmentStack.isEmpty()) {

            System.out.println("No treatment records found.");
            return;
        }

        System.out.println("\n===== TREATMENT HISTORY =====");

        for (int i = treatmentStack.size() - 1; i >= 0; i--) {

            treatmentStack.get(i).displayTreatment();
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {

        return treatmentStack.isEmpty();
    }
}