import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Signup extends Frame implements ActionListener, WindowListener
{
    //Declaration of Textfields and buttons
    TextField UserName = new TextField(30);
    TextField Email = new TextField(30);
    TextField Password = new TextField(30);

    Button signup = new Button("Signup");
    Button back = new Button("Back");



    public Signup() // Non-parameterized constructor
    {
        //Lebels
        super("User Registration");
        signup.addActionListener(this);
        Label title = new Label("Inventory Management System");
        Label LabelUserName = new Label("User Name");
        Label LabelEmail = new Label("E-mail");
        Label LabelPassword = new Label("Password");
        //----

        //Adding window listener,action listener and buttons for clickable activity
        back.addActionListener(this);
        addWindowListener(this);
        add(title);
        add(LabelUserName);
        add(UserName);
        add(LabelEmail);
        add(Email);
        add(LabelPassword);
        add(Password);
        Password.setEchoChar('*');
        add(signup);
        add(back);
        //-----

        //Setting up layout,size of window,visibility
        setLayout(new FlowLayout());
        setSize(274, 350);
        setVisible(true);
        //-------

    }
    //actionPerformed method for button pressing
    public void actionPerformed(ActionEvent ae)
    {
        String s = ae.getActionCommand(); //getting command from button pressing
        if(s.equals("Signup")) //Getting string from the button text
        {
            //keeping textfield texts in variable
            String username = UserName.getText();
            String email = Email.getText();
            String password = Password.getText();
            //------

                 try
                 {
                    //keeping sql query in variable q and simply calling SqlConnection class to establish connection to the database
                     String q = "Insert into logininfo values('" + username + "','" + email + "','" + password + "')";
                     SqlConnection sqlConnection = new SqlConnection(q);
                     JOptionPane.showMessageDialog(null, "Account created successfully !");
                 }
                 catch (Exception ex)
                 {
                     JOptionPane.showMessageDialog(null, "Check database/MySQL Connection again !");
                     ex.printStackTrace(); //printing error logs by ex variable
                 }



        }
        if(s.equals("Back"))
        {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.setVisible(true);
            this.setVisible(false);
        }
    }
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowClosing(WindowEvent e){System.exit(0);}
}
