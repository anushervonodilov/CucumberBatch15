package DBTest;

import java.sql.*;

public class DatabaseTestTwo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");

            Statement statement = conn.createStatement();
//            ResultSet rset = statement.executeQuery("select FirstName, LastName from person");


            ResultSet rset = statement.executeQuery("SELECT firstname, lastname, age, city " +
                    "FROM person WHERE city IS NOT null");
//            while (rset.next()) {
//                String fName = rset.getString("FirstName");
//                String lName = rset.getString("LastName");
//                System.out.println(fName + " " + lName);
//            }
            ResultSetMetaData metaData = rset.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }

            while (rset.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String value = rset.getString(metaData.getColumnName(i));
                }

                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
