import java.util.ArrayList;

public class CheckoutLineArray {

    private ArrayList<Customer> line = new ArrayList<>();

    public void addToBack(Customer c) {
        line.add(c);
    }

    public void addToFront(Customer c) {
        line.add(0, c);
    }

    public Customer removeFromFront() {
        if (line.isEmpty()) {
            return null;
        }
        return line.remove(0);
    }

    public Customer removeFromBack() {
        if (line.isEmpty()) {
            return null;
        }
        return line.remove(line.size() - 1);
    }

    public int size() {
        return line.size();
    }
}
