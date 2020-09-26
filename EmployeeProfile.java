import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class EmployeeProfile extends Frame implements ActionListener,WindowListener
{
    //Declaration of Textfields and comboboxes
    TextField employeeName = new TextField(30);
    TextField employeeId = new TextField(30);
    String designation[]={" ---Select---","CEO","Manager","Brand Manager","Project Manager","Sales manager","Production Manager","Managing Director","Customer Relationship Executive","Accountant Officer","Chief Customer Officer","Chief Marketing Officer","Chief Revenue Officer"};
    JComboBox designationCombobox = new JComboBox(designation);
    String department[]={" ---Select---","Chief Execution Unit","Sales & Production","Organization Management","Customer Affairs","Accounts","Marketing & Revenue"};
    JComboBox departmentCombobox = new JComboBox(department);
    TextField Salary = new TextField(30);
    TextField JoiningDate = new TextField(30);
    //---------

    public EmployeeProfile() // Non-parameterized constructor
    {
        //Lebels
        super("Employee Records");
        Label LabelemployeeName = new Label("Name");
        Label LabelemployeeId = new Label("Id");
        Label LabelDesignation = new Label("Designation");
        Label LabelDepartment = new Label("Department");
        Label LabelSalary = new Label("Salary");
        Label LabelJoiningDate = new Label("Joining Date");
        //----

        //Buttons
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");
        Button update = new Button("Update");
        Button reset = new Button("Reset");
        Button back = new Button("Back");
        //--------

        //Adding window listener,action listener and buttons for clickable activity
        insert.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        reset.addActionListener(this);
        back.addActionListener(this);
        addWindowListener(this);
        add(LabelemployeeId);
        add(employeeId);
        add(LabelemployeeName);
        add(employeeName);

        add(LabelDesignation);
        add(designationCombobox);
        add(LabelDepartment);
        add(departmentCombobox);
        add(LabelSalary);
        add(Salary);
        add(LabelJoiningDate);
        add(JoiningDate);
        add(insert);
        add(update);
        add(delete);
        add(reset);
        add(back);
        //-----

        //Setting up layout,size of window,visibility
        setLayout(new FlowLayout());
        setSize(261,454);
        setVisible(true);
        //---------

    }
    //actionPerformed method for button pressing
    public void actionPerformed(ActionEvent ae)
    {
        String s = ae.getActionCommand(); //getting command from button pressing
        //keeping textfield texts in variable
        String EmployeeName = employeeName.getText();
        String EmployeeId = employeeId.getText();
        String DesignationCombobox = designationCombobox.getSelectedItem().toString();
        String DepartmentCombobox = departmentCombobox.getSelectedItem().toString();
        String salary = Salary.getText();
        String joiningDate = JoiningDate.getText();
        //------
        if(s.equals("Insert"))
        {


            //keeping sql query in variable q and simply calling SqlConnection class to establish connection to the database
            try
            {
                String q = "Insert into Employees values('"+EmployeeId+"', '"+EmployeeName+"','"+DesignationCombobox+"', '"+DepartmentCombobox+"','"+salary+"','"+joiningDate+"')";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data inserted successfully !");
            }
            catch (Exception e)
            {
                e.printStackTrace();//printing error logs by ex variable
                JOptionPane.showMessageDialog(null,e);
            }

        }
        if(s.equals("Update"))
        {
            try
            {
                String q = "Update Employees set EmployeeName= '"+EmployeeName+"',Designation='"+DesignationCombobox+"',Department= '"+DepartmentCombobox+"',Salary='"+salary+"',JoiningDate='"+joiningDate+"' where EmployeeId = '"+EmployeeId+"' ";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data updated successfully !");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,e);
            }

        }

        if(s.equals("Delete"))
        {
            try
            {
                String q = "Delete from Employees where EmployeeId = '"+EmployeeId+"' ";
                SqlConnection sqlConnection = new SqlConnection(q);
                JOptionPane.showMessageDialog(null,"Data Deleted successfully !");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,e);
            }

        }
        if(s.equals("Reset"))
        {
            employeeName.setText(" ");
            employeeId.setText(" ");
            designationCombobox.setSelectedItem(null);
            departmentCombobox.setSelectedItem(null);
            Salary.setText(" ");
            JoiningDate.setText(" ");

        }

        if(s.equals("Back"))
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
