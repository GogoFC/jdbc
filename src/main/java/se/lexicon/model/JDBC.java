package se.lexicon.model;

import se.lexicon.db.SQLConnection;

import java.sql.*;
import java.time.LocalDate;

public class JDBC {

    public static void main (String[] args){
        summary();
    }

    public static void summary() {

        try {
            Connection jdbcConnection = SQLConnection.getConnection();
            Statement jdbcStatement = jdbcConnection.createStatement();
            ResultSet jdbcResult = jdbcStatement.executeQuery("SELECT * FROM users");

            while (jdbcResult.next()){
                int user_id = jdbcResult.getInt("user_id");
                String first_name = jdbcResult.getString("first_name");
                String last_name = jdbcResult.getString("last_name");
                String email = jdbcResult.getString("email");
                LocalDate creationDate = jdbcResult.getDate("create_date").toLocalDate();

                User user = new User(user_id,first_name,last_name,email,creationDate);
                System.out.println(user);
            }

        }catch (SQLException e){
            e.printStackTrace();
        };


    }

    public static void addUser(){
        User user = new User("Goran","Muminovic","goran@aol.com");
        String insertQuery = "INSERT INTO users (first_name, last_name, email) VALUES(?,?,?)";

        try (
            Connection jdbcConnection = SQLConnection.getConnection();
            PreparedStatement preparedStatement = jdbcConnection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        ){
            preparedStatement.setString(1,user.getFirst_name());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.setString(3, user.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User created!");
            }

            try (ResultSet generatedId = preparedStatement.getGeneratedKeys()){
                if (generatedId.next()){
                    int userId = generatedId.getInt(1);
                    System.out.println("userId = " + userId);
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
