package io.wisoft.seminar.student;

import io.wisoft.seminar.util.PgSqlAccess;

import java.sql.*;

public class StudentSelectService {

  public void getStudentAll() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      connection = PgSqlAccess.setConnection();

      final String query = "SELECT * FROM student";
      preparedStatement = connection.prepareStatement(query);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        printStudent(resultSet);
      }
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }

      if (preparedStatement != null) {
        try {
          preparedStatement.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }

      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }
    }
  }

  public void getStudentAll2() {
    final String query = "SELECT * FROM student";

    try (Connection connection = PgSqlAccess.setConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        printStudent(resultSet);
      }

    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
  }

  public void getStudentByNo(final String no) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      conn = PgSqlAccess.setConnection();

      final String query = "SELECT * FROM student WHERE no = ?";
      ps = conn.prepareStatement(query);
      ps.setString(1, no);
      rs = ps.executeQuery();

      if (rs.next()) {    //primary key는 while 말고 if 사용.
        printStudent(rs);
      }
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }

      if (ps != null) {
        try {
          ps.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }
    }
  }

  public void getStudentByName(final String name) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      conn = PgSqlAccess.setConnection();
      final String query = "SELECT * FROM student WHERE name = ?";
      ps = conn.prepareStatement(query);
      ps.setString(1, name);
      rs = ps.executeQuery();

      while (rs.next()) {
        printStudent(rs);
      }
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }

      if (ps != null) {
        try {
          ps.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
        }
      }
    }
  }

  public void getStudentByBirthday(final String birthday) {
    final String query = "SELECT * FROM student WHERE birthday ='" + Date.valueOf(birthday) + "'";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery();) {
      while (rs.next()) {
        printStudent(rs);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void printStudent(ResultSet resultSet) throws SQLException {
    System.out.print("[학번] " + resultSet.getString(1) + "||");
    System.out.print("[이름] " + resultSet.getString(2) + "||");
    System.out.println("[생일] " + resultSet.getString(3));
  }

}
