package io.wisoft.seminar.project.coop.user;

import io.wisoft.seminar.project.coop.book.Book;
import io.wisoft.seminar.project.coop.ViewInterface;
import io.wisoft.seminar.project.coop.book.BookService;

import java.util.Scanner;

public class UserClient implements ViewInterface {

  protected Book book = new Book();
  protected BookService bookService = new BookService();
  protected Scanner scanner = new Scanner(System.in);


  public void viewMenu() {
    while (true) {
      System.out.println("=========메뉴=========");
      System.out.println("1.대여 2.반납 3.도서 찾기 4.전체 목록 5.내 대여 목록 6.로그아웃");
      System.out.print("선택하세요 : ");

      switch (scanner.nextInt()) {
        case 1:
          bookService.rental(book);
          break;
        case 2:
          bookService.giveBack(book);
          break;
        case 3:
          bookService.find(book);
          break;
        case 4:
          bookService.printList();
          break;
        case 5:
          bookService.myRentalList();
          break;
        case 6:
          return;
      }
    }
  }

}