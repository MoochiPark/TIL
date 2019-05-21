package io.wisoft.seminar.project.coop;

import io.wisoft.seminar.project.coop.admin.AdminClient;
import io.wisoft.seminar.project.coop.user.User;
import io.wisoft.seminar.project.coop.user.UserClient;
import io.wisoft.seminar.project.coop.util.PgSqlAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountService implements ViewInterface {

  private static final String ADMIN_ID = "scott";
  private Scanner scanner = new Scanner(System.in);
  public static final User user = new User();

  @Override
  public void viewMenu() {
    while (true) {
      System.out.println("1.로그인 2.회원가입 3.종료");
      System.out.print("선택하세요 : ");
      int number = scanner.nextInt();
      switch (number) {
        case 1:
          inputUserInfo();
          signIn();
          break;
        case 2:
          inputUserInfo();
          signUp();
          break;
        case 3:
          return;
      }
    }
  }

  private void signUp() {
    System.out.print("name: ");
    final String name = scanner.next();
    final String query = "INSERT INTO user_data VALUES (?, ?, ?)";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
      conn.setAutoCommit(false);

      ps.setString(1, user.getId());
      ps.setString(2, user.getPass());
      ps.setString(3, name);

      ps.executeUpdate();
      conn.commit();

    } catch (SQLException e) {
      System.out.println("이미 사용중인 ID입니다.");
    }
  }

  private void signIn() {

    final String query = "SELECT * FROM user_data where usr_id = '"+user.getId()+"' and usr_pass = '"+user.getPass()+"'";
    try (Connection conn = PgSqlAccess.setConnection();
         PreparedStatement ps = conn.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

      if (rs.next()) {
        if (user.getId().equals(rs.getString(1)) && user.getPass().equals(rs.getString(2))) {
          if (user.getId().equals(ADMIN_ID)) {
            System.out.println("관리자 "+ rs.getString(3) + "님 환영합니다.");
            AdminClient adminClient = new AdminClient();
            adminClient.viewMenu();
          } else {
            System.out.println(rs.getString(3) + "님 환영합니다.");
            UserClient userClient = new UserClient();
            userClient.viewMenu();
          }
        }
      } else System.out.println("아이디와 비밀번호를 확인해주세요.");

    } catch (SQLException e) {
      System.out.format("SQLException: %s, SQLState: %s", e.getMessage(), e.getSQLState());
    }
  }

  private void inputUserInfo() {
    System.out.print("id: ");
    user.setId(scanner.next());
    System.out.print("pass: ");
    user.setPass(scanner.next());
  }

}
