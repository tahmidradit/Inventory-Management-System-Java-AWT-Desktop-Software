import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class CurrentStock extends Frame implements ActionListener,WindowListener
{
    ////Declaration of Textfields and comboboxes
    String categoryJcombobox[] ={" ---Select---","Monitor","Mouse","Keyboard","Processor","Motherboard","RAM","DVD RW","Accessories","Power Supply"};
    String avaivalityJcombobox[] ={" ---Select---","In Stock","Out of Stock"};
    JComboBox CategoryJComboBox = new JComboBox(categoryJcombobox);
    JComboBox AvailableJcombobox  = new JComboBox(avaivalityJcombobox);


    TextField serialNo = new TextField(23);
    TextField productName = new TextField(23);
    TextField price = new TextField(23);
    public CurrentStock() // Non-parameterized constructor
    {
        super("Current Stock"); //title

        //Lebels
        Label LabelProductId = new Label("Product Id");
        Label LabelProductName = new Label("Product Name");
        Label LabelPrice = new Label("Price(USD$)");
        Label LabelCategory = new Label("Category");
        Label LabelAvailablity = new Label("Availablity");
        //---------




        //Buttons
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button update = new Button("Update");
        Button reset = new Button("Reset");
        Button back = new Button("Back");
        //----------

        ////Adding window listener,action listener and buttons for clickable activity
        back.addActionListener(this);
        insert.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        reset.addActionListener(this);
        addWindowListener(this);

        add(LabelProductId);
        add(serialNo);
        add(LabelProductName);
        add(productName);
        add(LabelPrice);
        add(price);
        add(LabelCategory);
        add(CategoryJComboBox);
        add(LabelAvailablity);
        add(AvailableJcombobox);


        add(insert);
        add(delete);
        add(update);
        add(reset);
        add(back);
        //-----

        //Setting up layout,size of window,visibility
        setLayout(new FlowLayout());
        setSize(242,339);
        setVisible(true);
        //----------
    }

    //actionPerformed method for button pressing
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();  //getting command from button pressing
        if (s.equals("Insert"))//Getting string from the button text
        {
            //keeping textfield texts in variable
            String SerialNo = serialNo.getText();
            String ProductName = productName.getText();
            String Price = price.getText();
            String categoryjcomboBox = CategoryJComboBox.getSelectedItem().toString();
            String availablejcombobox = AvailableJcombobox.getSelectedItem().toString();
            //------

            //keeping sql query in variable q and simply calling SqlConnection class to establish connection to the database
            try
            {
                String q = "Insert into currentstock values('"+SerialNo+"', '"+ProductName+"','"+Price+"', '"+categoryjcomboBox+"','"+availablejcombobox+"')";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data inserted successfully !");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR in inserting data !");
                ex.printStackTrace(); //printing error logs by ex variable
            }

        }

        if (s.equals("Update"))
        {
            try
            {
                String ProductName =  productName.getText();
                String Price =  price.getText();
                String categoryjcomboBox =  CategoryJComboBox.getSelectedItem().toString();
                String availablejcombobox =  AvailableJcombobox.getSelectedItem().toString();
                String SerialNo =  serialNo.getText();

                String q = "Update currentstock set ProductName = '"+ProductName+"',PriceUSD = '"+Price+"',Category = '"+categoryjcomboBox+"',Availability = '"+availablejcombobox+"' where SlNo = '"+SerialNo+"' ";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data updated successfully !");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR in Updating data !");
                ex.printStackTrace();
            }

        }

        if (s.equals("Delete"))
        {
            try
            {

                String q = "Delete from currentstock where SlNo = '"+serialNo.getText()+"' ";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data deleted successfully !");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR in Deleted data !");
                ex.printStackTrace();
            }

        }

        if (s.equals("Reset"))
        {
            try
            {
                serialNo.setText(" ");
                productName.setText(" ");
                price.setText(" ");
                CategoryJComboBox.setSelectedItem(null);
                AvailableJcombobox.setSelectedItem(null);


            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace();
            }

        }

        if (s.equals("Back"))
        {
            InventoryHome inventoryHome = new InventoryHome();
            inventoryHome.setVisible(true);
            this.setVisible(false);
        }
    }
    public void windowActivated(WindowEvent w){}
    public void windowDeactivated(WindowEvent w){}
    public void windowClosed(WindowEvent w){}
    public void windowClosing(WindowEvent w){System.exit(0);}
    public void windowOpened(WindowEvent w){}
    public void windowIconified(WindowEvent w){}
    public void windowDeiconified(WindowEvent w){}
}