import java.util.Date;
import java.util.List;

public class Invoice {
    private int invoiceId;
    private String customerName;
    private String phoneNumber;
    private Date invoiceDate;
    private List<Product> products;
    private double totalAmount;
    private double paidAmount;
    private double balance;

    // Constructor
    public Invoice(int invoiceId, String customerName, String phoneNumber, Date invoiceDate, List<Product> products) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.products = products;
        this.totalAmount = calculateTotalAmount();
        this.paidAmount = 0;
        this.balance = this.totalAmount;
    }

    // Getters and setters
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        this.totalAmount = calculateTotalAmount();
        this.balance = this.totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
        this.balance = this.totalAmount - this.paidAmount;
    }

    public double getBalance() {
        return balance;
    }

    // Calculate the total amount of the invoice
    private double calculateTotalAmount() {
        double total = 0;
        for (Product product : products) {
            total += product.getQtyAmount();
        }
        return total;
    }
}


