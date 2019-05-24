package io.wisoft.seminar;

import java.sql.*;

public class BadJdbcExample {

  public static void main(String[] args) {
    try {
      Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exercise", "scott", "tiger");

      Statement statement;
      statement = connection.createStatement();

      ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

      while (resultSet.next()) {
        System.out.print("[학번] " + resultSet.getString(1) + "||");
        System.out.print("[이름] " + resultSet.getString(2) + "||");
        System.out.println("[생일] " + resultSet.getString(3));
      }

      resultSet.close();
      statement.close();
      connection.close();
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
  }
}


