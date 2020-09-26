import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class LoginWindow extends Frame implements ActionListener,WindowListener
{
    //Declaration of Textfields and comboboxes
    Label title = new Label("Inventory Management System");
    Label userName = new Label("User Name");
    Label password = new Label("Password");
    Button login = new Button("Login");
    Button signup = new Button("Signup");
    TextField username = new TextField(30);
    TextField Password = new TextField(30);



    public LoginWindow() // Non-parameterized constructor
    {
        //Lebels
        super("Admin Login");
        login.addActionListener(this);
        signup.addActionListener(this);
        add(title);
        add(userName);
        add(username);
        add(password);
        add(Password);
        Password.setEchoChar('*');
        add(login);
        add(signup);
        //---------

        // //Setting up layout,size of window,visibility
        setLayout(new FlowLayout());
        setSize(259, 228);
        setVisible(true);
        //---------

}
    //actionPerformed method for button pressing
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand(); //getting command from button pressing
        if (s.equals("Login")) //Getting string from the button text
        {
            //keeping textfield texts in variable
            String s1 = username.getText();
            String s2 = Password.getText();


            try {
                String q = "select * from logininfo";
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/IMS","Radit", "12345");
                Statement stmt = (Statement) connection.createStatement();
                ResultSet rs = stmt.executeQuery(q);
                while (rs.next()) {
                    String name = rs.getString("UserName");
                    String pas = rs.getString("Password");
                    if (name.equals(s1) && pas.equals(s2))
                    {

                        JOptionPane.showMessageDialog(this, "Successfully Logged in ");
                        InventoryHome inv = new InventoryHome();
                        inv.setVisible(true);
                        this.setVisible(false);
                        break;

                    }

                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Check database/MySQL Connection again !");
                ex.printStackTrace();
            }

        }
        if (s.equals("Signup"))
        {

             Signup signup = new Signup();
             signup.setVisible(true);
             this.setVisible(false);

        }

    }
    public void windowOpened(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowClosing(WindowEvent e){System.exit(0);}
    public void windowIconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}

}