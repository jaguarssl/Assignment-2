import java.util.ArrayList;

public class PurchaseLog {

    // TODO: declare the field that stores your PurchaseItem records.
    // Decide: ArrayList<PurchaseItem> or LinkedList<PurchaseItem>?
    private ArrayList<PurchaseItem> items = new ArrayList<>();

    public void addItem(PurchaseItem item) {
        // TODO
        items.add(item);
    }

    public PurchaseItem findItemByName(String name) {
        // TODO
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                return items.get(i);
            }
        }
        return null;
    }

    public void updatePrice(String name, double newPrice) {
        // TODO
        PurchaseItem item = findItemByName(name);
        if (item != null) {
            item.setPrice(newPrice);
        }
    }

    public void printDailyReport() {
        // TODO: loop through every item — total count, total revenue, best seller
        double totalRevenue = 0;
        for (int i = 0; i < items.size(); i++) {
            totalRevenue += items.get(i).getPrice();
        }

        String bestName = "none";
        int bestCount = 0;
        for (int i = 0; i < items.size(); i++) {
            String name = items.get(i).getName();
            int count = 0;
            for (int j = 0; j < items.size(); j++) {
                if (items.get(j).getName().equalsIgnoreCase(name)) {
                    count++;
                }
            }

            if (count > bestCount) {
                bestName = name;
                bestCount = count;
            }
        }

        System.out.println("===== DAILY REPORT =====");
        System.out.println("Total items scanned : " + items.size());
        System.out.printf("Total revenue       : $%.2f\n", totalRevenue);
        System.out.println("Best seller         : " + bestName + " (" + bestCount + " scanned)");
        System.out.println("========================");
    }

    public int itemCount() {
        // TODO
        return items.size();
    }
}
