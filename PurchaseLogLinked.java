import java.util.LinkedList;

public class PurchaseLogLinked {

    private LinkedList<PurchaseItem> items = new LinkedList<>();

    public void addItem(PurchaseItem item) {
        items.add(item);
    }

    public PurchaseItem findItemByName(String name) {
        for (PurchaseItem item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void updatePrice(String name, double newPrice) {
        PurchaseItem item = findItemByName(name);
        if (item != null) {
            item.setPrice(newPrice);
        }
    }

    public void printDailyReport() {
        double totalRevenue = 0;
        for (PurchaseItem item : items) {
            totalRevenue += item.getPrice();
        }
        System.out.println("Total items scanned : " + items.size());
        System.out.println("Total revenue       : $" + totalRevenue);
    }

    public int itemCount() {
        return items.size();
    }
}
