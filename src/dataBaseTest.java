/**
 * Created by pia on 10/14/2016.
 */


import Model.User;

import java.sql.*;

public class dataBaseTest {

    public static void main(String[] args) throws SQLException {

        try{
            // 1. Load Driver
            Class.forName("org.postgresql.Driver");
            //2. Define connection params to db
            final String URL = "jdbc:postgresql://54.93.65.5/4_Olimpia";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";
            //3. obtain a connection
            Connection connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
            //4. create query statement
            User user = new User("rebeca", "mamamergelapiata");
            insertUserInDB(user, connection);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void insertUserInDB(User user, Connection connection) {

        String INSERT_QUERY = "INSERT INTO booksapp.user (username, user_password) VALUES (?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(INSERT_QUERY);
            stm.setString(1,user.getUsername());
            stm.setString(2,user.getPassword());
            stm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
