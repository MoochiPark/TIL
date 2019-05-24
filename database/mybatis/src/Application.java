package io.wisoft.seminar;

import io.wisoft.seminar.department.Department;
import io.wisoft.seminar.department.DepartmentService;
import io.wisoft.seminar.department.SimpleDepartmentService;
import io.wisoft.seminar.drama.Drama;
import io.wisoft.seminar.drama.DramaService;
import io.wisoft.seminar.drama.SimpleDramaService;
import io.wisoft.seminar.employee.Employee;
import io.wisoft.seminar.employee.EmployeeService;
import io.wisoft.seminar.employee.SimpleEmployeeService;
import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

public class Application {

  public static void main(String... args) {
    DepartmentService departmentService = new SimpleDepartmentService();
    DramaService dramaService = new SimpleDramaService();
    EmployeeService employeeService = new SimpleEmployeeService();

    List<Department> departmentList;
    List<Drama> dramaList;
    List<Employee> employeeList;

    System.out.println("1. HNU Entertainment의 부서 코드, 이름, 위치를 검색하시오.");
    departmentList = departmentService.getDepartmentAll();
    departmentList.forEach(System.out::println);
    System.out.println();

    System.out.println("2. HNU Entertainment의 연예관계자 코드, 이름, 관리자, 급여를 검색하시오.");
    employeeList = employeeService.getEmployeeAll();
    employeeList.forEach(System.out::println);
    System.out.println();

    System.out.println("3. HNU-E에서 제작한 드라마의 코드와 이름을 검색하시오.");

    dramaList = dramaService.getDramaByPrd();
    dramaList.forEach(System.out::println);
    System.out.println();

    System.out.println("4. 드라마 방영사가 KBC이거나 SBC인 드라마를 검색하시오.");

    dramaList = dramaService.getDramaByBrd();
    dramaList.forEach(System.out::println);
    System.out.println();

    System.out.println("5. 드라마 제작사를 검색하시오. 단, 중복된 값이 있으면 제거하시오.");

    dramaList = dramaService.getDramaPrd();
    dramaList.forEach(System.out::println);
    System.out.println();

    System.out.println("6. 연예관계자들의 급여의 총합과 평균 급여액을 계산하시오.");

    employeeList = employeeService.getEmployeeSalSumAvg();
    employeeList.forEach(System.out::println);
    System.out.println();

    System.out.println("7. 방영일자가 아직 확정되지 않은 드라마의 이름을 검색하시오.");

    dramaList = dramaService.getDramaNameByOpDateIsNull();
    dramaList.forEach(System.out::println);
    System.out.println();

    System.out.println("8. 연예관계자에 대해 연예관계자의 이름과 직속 상사의 이름을 검색하시오.");

    employeeList = employeeService.getEmployeeNameByMgt();
    employeeList.forEach(System.out::println);
    System.out.println();

    System.out.println("9. 연예관계자에 대해 이름과 급여를 출력하고, 급여의 내림차순으로 정렬하시오. 단, 동일 급여일 때는 이름의 오름차순으로 정렬하시오.");

    employeeList = employeeService.getEmployeeNameSal();
    employeeList.forEach(System.out::println);
    System.out.println();

    System.out.println("10. 모든 연예관계자를 직급별로 그룹화하고, 평균 급여액이 5000 이상인 직급에 대해 연예 관계자의 직급, 평균 급여액, 최소 급여액, 최대 급여액을 검색하시오.");

    employeeList = employeeService.getEmployeeRoleBySal();
    employeeList.forEach(System.out::println);
    System.out.println();

    System.out.println("11. 모든 연예관계자의 평균 급여액보다 많은 급여를 받는 연예관계자의 이름과 급여를 검색하라.");

    employeeList = employeeService.getEmployeeNameSalBySalAvg();
    employeeList.forEach(System.out::println);
    System.out.println();

    System.out.println("12. 방영일자가 확정되지 않은 드라마의 방영일자가 2013-05-01로 편성되었습니다. 알맞게 변경하시오.");

    int count = dramaService.updateDramaOpDate("2013-05-01");
    System.out.println(count + "건 변경되었습니다.");
    System.out.println();

//    System.out.println("13. 연예관계자 김수현 씨가 대리에서 실장으로 승진하고 급여가 20% 증가되었습니다. 알맞게 변경하시오.");

//    count = employeeService.updateEmployeeKimPromotion();
//    System.out.println(count + "건 변경되었습니다.");
//    System.out.println();

//    System.out.println("14. 우리 회사에 한 명의 임원이 등록되었습니다. 코드는 E903, 이름은 손진현, 관리자는 E901, 급여는 4000입니다. 알맞게 등록하시오.");

//    Employee employee = new Employee("E903", "손진현", "E901", 4000, "R006");
//    count = employeeService.insertEmployee(employee);
//    System.out.println(count + "건 추가되었습니다.");
//    System.out.println();

    System.out.println("15. 연예관계자인 손진현님이 퇴직했습니다. 연예관계자 목록에서 제거하시오.");

    count = employeeService.deleteEmployeeByName("손진현");
    System.out.println(count + "건 제거되었습니다.");
    System.out.println();
  }

}



