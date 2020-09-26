import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class SalaryManagement extends Frame implements ActionListener,WindowListener
{
    //Declaration of Textfields and comboboxes
    TextField serialNo = new TextField(30);
    TextField employeeName = new TextField(30);
    TextField salary = new TextField(30);
    String designation[]={" ---Select---","CEO","Manager","Brand Manager","Project Manager","Sales manager","Production Manager","Managing Director","Customer Relationship Executive","Accountant Officer","Chief Customer Officer","Chief Marketing Officer","Chief Revenue Officer"};
    String paymentStatus[]={" ---Select---","Paid","Unpaid"};
    String department[]={" ---Select---","Chief Execution Unit","Sales & Production","Organization Management","Customer Affairs","Accounts","Marketing & Revenue"};
    JComboBox designationCombobox = new JComboBox(designation);
    JComboBox paymentStatusCombobox = new JComboBox(paymentStatus);
    JComboBox departmentCombobox = new JComboBox(department);
    //--------

    public SalaryManagement() // Non-parameterized constructor
    {
        //Lebels
        super("Salary Management");

        Label LabelSerialNo = new Label("Employee Id");
        Label LabelEmployeeName = new Label("Employee Name");
        Label LabelDesignation = new Label("Designation");
        Label LabelSalary = new Label("Salary");
        Label LabelPaymentStatus = new Label("Payment Status");
        Label LabelDepartment = new Label("Department");
        //----

        //Buttons

        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button update = new Button("Update");
        Button reset = new Button("Reset");
        Button back = new Button("Back");

        insert.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);
        //--------

        //Adding window listener,action listener and buttons for clickable activity
        addWindowListener(this);

        add(LabelSerialNo);
        add(serialNo);
        add(LabelEmployeeName);
        add(employeeName);
        add(LabelDesignation);
        add(designationCombobox);
        add(LabelSalary);
        add(salary);
        add(LabelPaymentStatus);
        add(paymentStatusCombobox);
        add(LabelDepartment);
        add(departmentCombobox);
        add(insert);
        add(delete);
        add(update);
        add(reset);
        add(back);
        //-----

        //Setting up layout,size of window,visibility
        setLayout(new FlowLayout());
        setSize(303,374);
        setVisible(true);
        //----------
    }
    //actionPerformed method for button pressing
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();//getting command from button pressing
        //keeping textfield texts in variable
        String SerialNo = serialNo.getText();
        String EmployeeName = employeeName.getText();
        String Designationcombobox = designationCombobox.getSelectedItem().toString();
        String Salary = salary.getText();
        String paymentstatuscombobox = paymentStatusCombobox.getSelectedItem().toString();
        String Departmentcombobox = departmentCombobox.getSelectedItem().toString();

        if (s.equals("Insert")) //Getting string from the button text
        {
            try
            {
                //keeping sql query in variable q and simply calling SqlConnection class to establish connection to the database
                String q = "Insert into salarymanagement values('"+SerialNo+"', '"+EmployeeName+"','"+Designationcombobox+"', '"+Salary+"','"+paymentstatuscombobox+"','"+Departmentcombobox+"')";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data inserted successfully !");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace(); //printing error logs by ex variable
            }

        }

        if (s.equals("Update"))
        {
            try
            {

                String q = "Update salarymanagement set EmployeeName = '"+EmployeeName+"',Designation = '"+Designationcombobox+"', Salary = '"+Salary+"',PaymentStatus = '"+paymentstatuscombobox+"',Department = '"+Departmentcombobox+"' where SlNo = '"+SerialNo+"' ";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data updated successfully !");
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace();
            }

        }

        if (s.equals("Delete"))
        {
            try
            {
                String q = "Delete from salarymanagement where SlNo='"+SerialNo+"' ";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data deleteded successfully !");


            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR !");
                ex.printStackTrace();
            }

        }

        if (s.equals("Reset"))
        {
            try
            {
                serialNo.setText(" ");
                employeeName.setText(" ");
                salary.setText(" ");
                designationCombobox.setSelectedItem(null) ;
                paymentStatusCombobox.setSelectedItem(null);
                departmentCombobox.setSelectedItem(null);

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