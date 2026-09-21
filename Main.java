public class Main {
    public static void main(String[] args) {

        // ---- Sample data to load into the Purchase Log ----
        PurchaseItem[] sampleItems = {
            new PurchaseItem("Bread", 3.49),
            new PurchaseItem("Milk", 2.99),
            new PurchaseItem("Eggs", 4.29),
            new PurchaseItem("Coffee", 8.99),
            new PurchaseItem("Bananas", 1.29),
            new PurchaseItem("Cereal", 4.79),
            new PurchaseItem("Chicken Breast", 9.99),
            new PurchaseItem("Paper Towels", 6.49)
        };

        PurchaseLog log = new PurchaseLog();

        // TODO: write a loop that adds every item in sampleItems to log using addItem().
        for (PurchaseItem item : sampleItems) {
            log.addItem(item);
        }

        System.out.println("Purchase Log loaded with " + log.itemCount() + " items.");

        // Example test call — findItemByName. Do the same for every other required method.
        PurchaseItem found = log.findItemByName("Coffee");
        System.out.println("Looked up 'Coffee', found: " +
            (found != null ? found.getName() + " $" + found.getPrice() : "NOT FOUND"));

        // TODO: test updatePrice() — update a price, then look it up again and print the new value.
        System.out.println("\n'Milk' price before update: $" + log.findItemByName("Milk").getPrice());
        log.updatePrice("Milk", 3.59);
        System.out.println("'Milk' price after  update: $" + log.findItemByName("Milk").getPrice());

        System.out.println("\nItems scanned before: " + log.itemCount());
        log.addItem(new PurchaseItem("Coffee", 8.99));
        System.out.println("Scanned another Coffee.");
        System.out.println("Items scanned after : " + log.itemCount());

        // TODO: test printDailyReport() — call it and confirm the totals look correct against sampleItems.
        System.out.println();
        log.printDailyReport();


        // ---- Sample data to load into the Checkout Line ----
        Customer[] sampleCustomers = {
            new Customer("Alvarez", 12),
            new Customer("Chen", 3),
            new Customer("Patel", 27),
            new Customer("O'Brien", 1)
        };

        printHeader("PART B: CHECKOUT LINE");

        CheckoutLine line = new CheckoutLine();

        // TODO: write a loop that adds every customer in sampleCustomers to line using addToBack().
        for (Customer c : sampleCustomers) {
            line.addToBack(c);
            System.out.println(c.getName() + " got in line.");
        }

        System.out.println("The size of the line is " + line.size());

        // Example test call — addToFront (O'Brien has 1 item, gets waved to the front).
        Customer express = new Customer("Nguyen", 1);
        System.out.println("Waving " + express.getName() + " to the front...");
        line.addToFront(express);
        System.out.println(express.getName() + " was brought to the front of the line.");

        // TODO: test removeFromFront() — remove and print who gets served first. Should it be Nguyen?
        Customer servedFirst = line.removeFromFront();
        System.out.println(servedFirst.getName() + " was served.");

        // TODO: test removeFromBack() — remove and print who leaves from the back of the line.
        Customer leftFromBack = line.removeFromBack();
        System.out.println(leftFromBack.getName() + " left from the back of the line.");

        // TODO: after your test calls above, print line.size() again and confirm it changed correctly.
        System.out.println("\nThere are " + line.size() + " customers now in line.");
    }

    private static void printHeader(String title) {
        System.out.println("\n==============================================");
        System.out.println(title);
        System.out.println("==============================================");
    }
}
