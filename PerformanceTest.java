public class PerformanceTest {

    public static void main(String[] args) {

        int logSize = 10000;
        int lookups = 1000;
        int pushes = 1000;

        String target = "Item" + (logSize - 1);

        PurchaseLog arrayLog = new PurchaseLog();
        for (int i = 0; i < logSize; i++) {
            arrayLog.addItem(new PurchaseItem("Item" + i, 1.00 + i));
        }

        long start = System.nanoTime();
        for (int i = 0; i < lookups; i++) {
            arrayLog.findItemByName(target);
        }
        long end = System.nanoTime();
        double arrayLogTime = (end - start) / 1000000.0;

        PurchaseLogLinked linkedLog = new PurchaseLogLinked();
        for (int i = 0; i < logSize; i++) {
            linkedLog.addItem(new PurchaseItem("Item" + i, 1.00 + i));
        }

        start = System.nanoTime();
        for (int i = 0; i < lookups; i++) {
            linkedLog.findItemByName(target);
        }
        end = System.nanoTime();
        double linkedLogTime = (end - start) / 1000000.0;

        CheckoutLine linkedLine = new CheckoutLine();
        int linkedShifts = 0;

        start = System.nanoTime();
        for (int i = 0; i < pushes; i++) {
            linkedLine.addToFront(new Customer("Customer" + i, 5));
        }
        end = System.nanoTime();
        double linkedLineTime = (end - start) / 1000000.0;

        CheckoutLineArray arrayLine = new CheckoutLineArray();
        int arrayShifts = 0;

        start = System.nanoTime();
        for (int i = 0; i < pushes; i++) {
            arrayShifts += arrayLine.size();
            arrayLine.addToFront(new Customer("Customer" + i, 5));
        }
        end = System.nanoTime();
        double arrayLineTime = (end - start) / 1000000.0;

        System.out.println("Purchase Log: " + lookups + " findItemByName lookups on " + logSize + " items");
        System.out.println("  ArrayList  (chosen) : " + arrayLogTime + " ms");
        System.out.println("  LinkedList          : " + linkedLogTime + " ms");
        System.out.println();
        System.out.println("Checkout Line: " + pushes + " addToFront calls");
        System.out.println("  LinkedList (chosen) : " + linkedLineTime + " ms, "
                + linkedShifts + " customers shifted");
        System.out.println("  ArrayList           : " + arrayLineTime + " ms, "
                + arrayShifts + " customers shifted");
    }
}
