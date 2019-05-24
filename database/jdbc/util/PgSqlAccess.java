package io.wisoft.seminar.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgSqlAccess {

  private static Connection connection = null;

  public void init() {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection setConnection() {
    String url = "jdbc:postgresql://localhost:5432/exercise";
    String username = "scott";
    String password = "tiger";

    try {
      connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return connection;
  }

}
