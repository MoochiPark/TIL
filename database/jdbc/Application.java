package io.wisoft.seminar;

import io.wisoft.seminar.student.*;

public class Application {

  public static void main(String[] args) {
    final StudentSelectService selectService = new StudentSelectService();

    System.out.println("전체 학생을 조회합니다.");
    selectService.getStudentAll2();
    System.out.println();

    String no = "20110301";
    System.out.println(no + "학번으로 조회합니다.");
    selectService.getStudentByNo(no);
    System.out.println();

    String name = "일지매";
    System.out.println(name + "이름으로 조회합니다.");
    selectService.getStudentByName(name);
    System.out.println();

    String birthday = "1991-02-08";
    System.out.println(birthday + "생일으로 조회합니다.");
    selectService.getStudentByBirthday(birthday);
    System.out.println();
    StudentInsertService insertService = new StudentInsertService();

    final Student student = new Student();
    final Student[] students = new Student[8];

    for (int i = 0; i < students.length; i++) {
      students[i] = new Student();
    }

    System.out.println("학번이 20190401이고, 이름이 이순신인 학생을 추가합니다.");
    student.setNo("20190401");
    student.setName("이순신");
    insertService.insertStudent(student);
    System.out.println();;

    System.out.println("학번이 20190401이고, 이름이 이순신인 학생을 추가합니다.");
    students[0].setNo("20190501");
    students[0].setName("이율곡");

    System.out.println("학번이 20190501이고, 이름이 이수일인 학생을 추가합니다.");
    students[1].setNo("20190601");
    students[1].setName("이수일");

    System.out.println("학번이 20190601이고, 이름이 심순애인 학생을 추가합니다.");
    students[2].setNo("20190701");
    students[2].setName("심순애");

    System.out.println("학번이 20190701이고, 이름이 임꺽정인 학생을 추가합니다.");
    students[3].setNo("20190801");
    students[3].setName("임꺽정");

    insertService.insertStudentMulti(students);

    System.out.println("학번이 20190901이고, 이름이 박대원인 학생을 추가합니다.");
    students[0].setNo("20190901");
    students[0].setName("박대원");

    System.out.println("학번이 20191001이고, 이름이 박민영인 학생을 추가합니다.");
    students[1].setNo("20191001");
    students[1].setName("박민영");

    System.out.println("학번이 20191101이고, 이름이 조은엽인 학생을 추가합니다.");
    students[2].setNo("20191101");
    students[2].setName("조은엽");

    System.out.println("학번이 20191201이고, 이름이 안홍범인 학생을 추가합니다.");
    students[3].setNo("20191201");
    students[3].setName("안홍범");

    insertService.insertStudentMultiBatch(students);

    final StudentUpdateService updateService = new StudentUpdateService();
    System.out.println("학번이 20190401인 학생의 생일을 2000-03-25으로 변경합니다.");
    student.setNo("20190401");
    student.setBirthday("2000-03-25");
    updateService.updateStudentBirthday(student);
    System.out.println();

    System.out.println("학번이 20190501인 학생의 생일을 2000-03-25로 변경합니다.");
    students[0].setNo("20190501");
    students[0].setBirthday("2000-03-25");

    System.out.println("학번이 20190601인 학생의 생일을 2000-04-25로 변경합니다.");
    students[1].setNo("20190601");
    students[1].setBirthday("2000-04-25");

    System.out.println("학번이 20190701인 학생의 생일을 2000-05-25로 변경합니다.");
    students[2].setNo("20190701");
    students[2].setBirthday("2000-05-25");

    System.out.println("학번이 20190801인 학생의 생일을 2000-06-25로 변경합니다.");
    students[3].setNo("20190801");
    students[3].setBirthday("2000-06-25");

    updateService.updateStudentBirthdayMultiBatch(students);
    System.out.println();

    StudentDeleteService deleteService = new StudentDeleteService();
    System.out.println("학번이 20190401~20191201인 학생을 목록에서 제거합니다.");
    String[] numbers = {"20190401", "20190501", "20190601", "20190701",
        "20190801", "20190901", "20191001", "20191101", "20191201"};
    deleteService.deleteStudentNoMultiBatch(numbers);
    deleteService.deleteStudentNo("2019501");
    System.out.println();

  }

}
