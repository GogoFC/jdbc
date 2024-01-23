package se.lexicon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class JdbcDemo {


    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "goran", "Blue300@");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT user_id, first_name, last_name FROM users");
            //executeQuery used for SELECT queries.
            // executeUpdate used for INSERT, DELETE, UPDATE
//            int rowsAffected = statement.executeUpdate

            while (resultSet.next()){
                //ColumnIndex
//                int student_id = resultSet.getInt(1);
//                String firstName = resultSet.getString(2);
//                String lastName = resultSet.getString(3);

                //ColumnLabel
                int user_id = resultSet.getInt("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                System.out.print("user_id = " + user_id);
                System.out.print(", firstName = " + firstName);
                System.out.print(", lastName = " + lastName);
                System.out.println();
            }


        }catch (SQLException e){
            e.printStackTrace();
        }



    }


}
