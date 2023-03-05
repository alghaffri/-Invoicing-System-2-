import java.util.ArrayList;

public class Invoice {
    private int invoiceNumber;
    private String customerName;
    private ArrayList<Product> products;

    public Invoice(int invoiceNumber, String customerName) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.products = new ArrayList<Product>();
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}