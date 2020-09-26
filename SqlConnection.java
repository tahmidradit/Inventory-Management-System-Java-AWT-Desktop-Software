import java.sql.*;

class SqlConnection //class for the database connection
{


    public SqlConnection(String q) //parameterized constructor
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); // JDBC driver
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/IMS","Radit", "12345");// connection URL
            Statement stmt = (Statement) connection.createStatement(); //creating statement
            stmt.executeUpdate(q); //executing SQL query
        }
        catch(Exception e)
        {
            e.printStackTrace(); // error log
        }
    }

}
