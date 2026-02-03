public class ProductWarehouseWithHistory extends ProductWarehouse{

    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.history = new ChangeHistory();
        super.addToWarehouse(initialBalance);
    }

    public String history() {
        return this.history.toString();
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.history.add(getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        this.history.add(getBalance());
        return amountTaken;
    }

    public void printAnalysis() {
        String output = "Product: " + super.getName() +
                        "\nHistory: " + history() +
                        "\nLargest amount of product: " + this.history.maxValue() +
                        "\nSmallest amount of product: " + this.history.minValue() +
                        "\nAverage: " + this.history.average();

        System.out.println(output);
    }
}
