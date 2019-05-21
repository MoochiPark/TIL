package io.wisoft.seminar.project.coop.admin;

import io.wisoft.seminar.project.coop.user.UserClient;


public class AdminClient extends UserClient{

  public void viewMenu() {
    while (true) {
      System.out.println("=========관리자 메뉴=========");
      System.out.println("1. 책 추가 2. 책 삭제 3. 책 목록 보기 4. 로그아웃");
      System.out.println("선택하세요: ");

      switch (scanner.nextInt()) {
        case 1:
          bookService.add(book);
          break;
        case 2:
          bookService.delete(book);
          break;
        case 3:
          bookService.printList();
          break;
        case 4:
          return;
      }
    }
  }

}
