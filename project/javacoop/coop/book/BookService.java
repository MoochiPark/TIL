package io.wisoft.seminar.project.coop.book;

import io.wisoft.seminar.project.coop.AccountService;
import io.wisoft.seminar.project.coop.util.PgSqlAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookService {

  private Scanner scanner = new Scanner(System.in);

  public void rental(final Book book) {
    System.out.println("=========Rental Book=========");
    if (!isRented(book)) {
      final String query = "UPDATE book_data SET loan_id = ? WHERE book_name = ?";
      try (Connection conn = PgSqlAccess.setConnection();
           PreparedStatement ps = conn.prepareStatement(query)) {
        conn.setAutoCommit(false);

        ps.setString(1, AccountService.user.getId());
        ps.setString(2, inputCode(book));

        ps.executeUpdate();
        conn.commit();
        System.out.println(book.getName() + "을 대여하였습니다.");
      } catch (SQLException e) {
        System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
      }
    }
  }

  public void giveBack(final Book book) {
    System.out.println("=========Return Book=========");
    if (find(book)) {
      final String query = "UPDATE book_data SET loan_id = ? WHERE book_name = ?";
      try (Connection conn = PgSqlAccess.setConnection();
           PreparedStatement ps = conn.prepareStatement(query)) {
        conn.setAutoCommit(false);

        ps.setString(1, null);
        ps.setString(2, inputName(book));

        ps.executeUpdate();
        conn.commit();
        System.out.println(book.getName() + "을 반납하였습니다.");
      } catch (SQLException e) {
        System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
      }
    }

  }

  public boolean find(final Book book) {
    final String query = "SELECT * FROM book_data where book_name = '" + inputName(book) + "'";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
      if (rs.next()) {
        print(rs);
      } else {
        System.out.println(book.getName() + " 책이 존재하지 않습니다.");
        return false;
      }
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
    return true;
  }

  private boolean isRented(final Book book) {
    final String query = "SELECT * FROM book_data where book_name = '" + inputName(book) + "'";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
      if (rs.next()) {
        if (rs.getString(3) != null) {
          System.out.println("이미 대여중인 책입니다.");
          return true;
        }
      } else {
        System.out.println(book.getName() + " 책이 존재하지 않습니다.");
        return true;
      }
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
    return false;
  }

  public void printList() {
    System.out.println("=========Print Book List=========");
    final String query = "SELECT * FROM book_data";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        print(rs);
      }
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
  }

  public void myRentalList() {
    System.out.println("=========Print My Rental List=========");
    final String query = "SELECT * FROM book_data WHERE loan_id = '" + AccountService.user.getId() + "'";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        print(rs);
      }
    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
  }

  public void print(final ResultSet resultSet) throws SQLException {
    System.out.print("[코드] " + resultSet.getString(1) + " || ");
    System.out.print("[책 이름] " + resultSet.getString(2) + "" + " || ");
    if (resultSet.getString(3) == null) {
      System.out.println("[빌린 사람] 없음");
    } else System.out.println("[빌린 사람] " + resultSet.getString(3));
  }


  public void add(final Book book) {
    System.out.println("=========Insert Book=========");
    final String query = "INSERT INTO book_data (book_code, book_name) VALUES (?, ?)";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
      conn.setAutoCommit(false);
      ps.setString(1, inputCode(book));
      ps.setString(2, inputName(book));

      ps.executeUpdate();
      conn.commit();
      System.out.println(book.getName() + "이 추가되었습니다.");

    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
  }


  public void delete(final Book book) {
    System.out.println("=========Delete Book=========");
    final String query = "DELETE FROM book_data WHERE book_code = ?";
    if (find(book)) {
      try (Connection conn = PgSqlAccess.setConnection();
           PreparedStatement ps = conn.prepareStatement(query)) {
        conn.setAutoCommit(false);

        ps.setString(1, inputCode(book));
        ps.executeUpdate();
        conn.commit();

        System.out.println("삭제 처리되었습니다.");
      } catch (SQLException e) {
        System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
      }
    }
  }

  public String inputName(final Book book) {
    System.out.print("책 이름 : ");
    book.setName(scanner.nextLine());

    return book.getName();
  }

  private String inputCode(final Book book) {
    System.out.print("책 코드 : ");
    book.setCode(scanner.next());
    scanner.nextLine();

    return book.getCode();
  }

  public void inputInfo(Book book) {
    inputName(book);
    System.out.print("책 코드 : ");
    book.setCode(scanner.next());
    scanner.nextLine();
  }

}
