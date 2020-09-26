import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BalanceSheet extends Frame implements ActionListener,WindowListener
{
        //Declaration of Textfields and comboboxes
        TextField serialNo = new TextField(30);
        TextField accountName = new TextField(30);
        TextField date = new TextField(30);
        TextField amount = new TextField(30);
        String category[]={" ---Select---","Assets","Liabilities/Owners Equity"}; //Combobox dropdown menu items in array
        JComboBox categoryCombobox = new JComboBox(category);
        //---------



    public BalanceSheet() // Non-parameterized constructor
    {
        //Lebels
        super("Balance Sheet");
        Label LabelSerialNo = new Label("Serial No");
        Label LabelAccountName = new Label("Account Name ");
        Label LabelDate = new Label("Date");
        Label LabelCategory = new Label("Category");
        Label LabelAmount = new Label("Amount");
        //----

        //Buttons
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button update = new Button("Update");
        Button reset = new Button("Reset");
        Button back = new Button("Back");
        //--------

        //Adding window listener,action listener and buttons for clickable activity
        addWindowListener(this);
        back.addActionListener(this);
        insert.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        reset.addActionListener(this);

        add(LabelSerialNo);
        add(serialNo);
        add(LabelAccountName);
        add(accountName);
        add(LabelDate);
        add(date);
        add(LabelCategory);
        add(categoryCombobox);
        add(LabelAmount);
        add(amount);
        add(insert);
        add(delete);
        add(update);
        add(reset);
        add(back);
        //-----

        //Setting up layout,size of window,visibility
        setLayout(new FlowLayout());
        setSize(288,350);
        setVisible(true);
        //----------
    }

    //actionPerformed method for button pressing
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand(); //getting command from button pressing
        if (s.equals("Insert")) //Getting string from the button text
        {
            try
            {
                //keeping textfield texts in variable
                String serialno = serialNo.getText();
                String accountname = accountName.getText();
                String Date = date.getText();
                String categorycombobox = categoryCombobox.getSelectedItem().toString();
                String Amount = amount.getText();
                //------

                //keeping sql query in variable q and simply calling SqlConnection class to establish connection to the database
                String q = "Insert into balancesheet values('"+serialno+"', '"+accountname+"','"+Date+"', '"+categorycombobox+"','"+Amount+"')";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data inserted successfully !");

            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace(); //printing error logs by ex variable
            }

        }
        if (s.equals("Update")) //Getting string from the button text
        {
            try
            {
                //keeping textfield texts in variable
                String serialno = serialNo.getText();
                String accountname = accountName.getText();
                String Date = date.getText();
                String categorycombobox = categoryCombobox.getSelectedItem().toString();
                String Amount = amount.getText();
                //----------

                //keeping sql query in variable q and simply calling SqlConnection class to establish connection to the database
                String q = "Update balancesheet set AccountName = '"+accountname+"', Date ='"+Date+"',Category ='"+categorycombobox+"', AmountInUSD = '"+Amount+"' where SlNo = '"+serialno+"' ";
                SqlConnection sqlConnection = new SqlConnection(q);

                JOptionPane.showMessageDialog(null,"Data updateded successfully !");

            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace();//printing error logs by ex variable
            }

        }
        if (s.equals("Reset"))//Getting string from the button text
        {
            try
            {   // setting empty string to clear textboxes for reset button
                serialNo.setText(" ");
                accountName.setText(" ");
                date.setText(" ");
                amount .setText(" ");
                categoryCombobox.setSelectedItem(null);//setting null to comboboxes
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace();
            }

        }
        if (s.equals("Delete"))//Getting string from the button text
        {
            try
            {
                //keeping sql query in variable q and simply calling SqlConnection class to establish connection to the database
                String q = "Delete from balancesheet where SlNo='"+serialNo.getText()+"'";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data deleteded successfully !");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace();
            }

        }

        else if (s.equals("Back"))
        {
            //returning to previous page
            InventoryHome inventoryHome = new InventoryHome();
            inventoryHome.setVisible(true);
            this.setVisible(false);
        }
    }
    //WindowListeners
    public void windowActivated(WindowEvent w){}
    public void windowDeactivated(WindowEvent w){}
    public void windowClosed(WindowEvent w){}
    public void windowClosing(WindowEvent w){System.exit(0);} // X button command to exit
    public void windowOpened(WindowEvent w){}
    public void windowIconified(WindowEvent w){}
    public void windowDeiconified(WindowEvent w){}
}