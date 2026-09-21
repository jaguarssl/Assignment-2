import java.util.LinkedList;

public class CheckoutLine {

    // TODO: declare the field that stores your Customer records.
    // Decide: ArrayList<Customer> or LinkedList<Customer>?
    private LinkedList<Customer> line = new LinkedList<>();

    public void addToBack(Customer c) {
        // TODO
        line.addLast(c);
    }

    public void addToFront(Customer c) {
        // TODO
        line.addFirst(c);
    }

    public Customer removeFromFront() {
        // TODO
        if (line.isEmpty()) {
            return null;
        }
        return line.removeFirst();
    }

    public Customer removeFromBack() {
        // TODO
        if (line.isEmpty()) {
            return null;
        }
        return line.removeLast();
    }

    public int size() {
        // TODO
        return line.size();
    }
}
