import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillingSystem extends JFrame {

    private JTextField txtName;
    private JTextField txtPrice;
    private JTextArea txtBill;
    private double totalBill;

    public BillingSystem() {
        super("Billing System");

        // Create and configure GUI components
        JLabel lblName = new JLabel("Product Name:");
        JLabel lblPrice = new JLabel("Product Price:");
        txtName = new JTextField(20);
        txtPrice = new JTextField(10);
        JButton btnAdd = new JButton("Add to Bill");
        JButton btnGenerate = new JButton("Generate Receipt");
        txtBill = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(txtBill);

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(lblName);
        add(txtName);
        add(lblPrice);
        add(txtPrice);
        add(btnAdd);
        add(btnGenerate);
        add(scrollPane);

        // Add event listeners
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToBill();
            }
        });

        btnGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateReceipt();
            }
        });
    }

    private void addToBill() {
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());

        // Add the product to the bill
        txtBill.append(name + "\t$" + price + "\n");

        // Update the total bill amount
        totalBill += price;

        // Clear the input fields
        txtName.setText("");
        txtPrice.setText("");
    }

    private void generateReceipt() {
        // Create a receipt with the total bill amount
        String receipt = "-------------------------\n";
        receipt += "      Receipt\n";
        receipt += "-------------------------\n";
        receipt += txtBill.getText();
        receipt += "-------------------------\n";
        receipt += "Total: $" + totalBill + "\n";
        receipt += "-------------------------\n";

        // Display the receipt
        JOptionPane.showMessageDialog(this, receipt);

        // Reset the bill
        txtBill.setText("");
        totalBill = 0;
    }

    public static void main(String[] args) {
        BillingSystem billingSystem = new BillingSystem();
        billingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billingSystem.setSize(400, 400);
        billingSystem.setVisible(true);
    }
}
