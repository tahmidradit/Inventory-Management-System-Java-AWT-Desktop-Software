import java.awt.*;
import java.awt.event.*;


class InventoryHome extends Frame implements ActionListener,WindowListener
{
    //calling classes
    public BalanceSheet balanceSheet;
    public CurrentStock currentStock;

    public LoginWindow loginWindow;
    public SalaryManagement salaryManagement;
    //-------

    public InventoryHome() //// Non-parameterized constructor
    {
        super("Inventory Home");//Window title

        //Label,button
        Label title = new Label("Inventory Management System Home");
        Button ButtonBalanceSheet = new Button("Balance Sheet");
        Button ButtonSalaryManagement = new Button("Salary Management");
        Button ButtonProductsList = new Button("Current Stock");
        Button ButtonEmployeeRecords = new Button("Employee Records");
        Button ButtonExit = new Button("Exit");
        //------------
        //Adding window listener,action listener and buttons for clickable activity
        add(title);
        add(ButtonBalanceSheet);
        add(ButtonSalaryManagement);
        add(ButtonProductsList);
        add(ButtonEmployeeRecords);
        add(ButtonExit);

        ButtonBalanceSheet.addActionListener(this);
        ButtonSalaryManagement.addActionListener(this);
        ButtonExit.addActionListener(this);
        ButtonProductsList.addActionListener(this);
        ButtonEmployeeRecords.addActionListener(this);

        addWindowListener(this);
        setLayout(new FlowLayout());
        setSize(245,255);
        //setVisible(true);
        //-------

    }
    //actionPerformed method for button pressing
    public void actionPerformed(ActionEvent actionEvent)
    {
        String s = actionEvent.getActionCommand();//getting command from button pressing
        if(s.equals("Balance Sheet")) //Getting string from the button text
        {
            balanceSheet = new BalanceSheet(); //calling classes
            this.setVisible(false);
        }
        if(s.equals("Current Stock"))
        {
            currentStock = new CurrentStock();
            this.setVisible(false);
        }
        if(s.equals("Salary Management"))
        {
            salaryManagement = new SalaryManagement();
            this.setVisible(false);
        }
        if(s.equals("Employee Records"))
        {
            EmployeeProfile employeeProfile = new EmployeeProfile();
            employeeProfile.setVisible(true);
            this.setVisible(false);
        }
        if(s.equals("Exit"))
        {
            LoginWindow login = new LoginWindow();
            login.setVisible(true);
            this.setVisible(false);
        }

    }
    //windowListeners
    public void windowActivated(WindowEvent w){}
    public void windowDeactivated(WindowEvent w){}
    public void windowClosed(WindowEvent w){}
    public void windowClosing(WindowEvent w){System.exit(0);}
    public void windowOpened(WindowEvent w){}
    public void windowIconified(WindowEvent w){}
    public void windowDeiconified(WindowEvent w){}
    //-------
}