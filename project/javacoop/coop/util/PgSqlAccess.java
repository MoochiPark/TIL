package io.wisoft.seminar.project.coop.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgSqlAccess {

  private static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
  private static final String ID = "scott";
  private static final String PASS = "tiger";

  private static Connection connection = null;

  public void init() {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection setConnection() {
    try {
      connection = DriverManager.getConnection(URL, ID, PASS);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return connection;
  }

}
