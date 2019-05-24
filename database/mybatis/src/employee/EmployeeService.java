package io.wisoft.seminar.employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> getEmployeeAll();

  List<Employee> getEmployeeSalSumAvg();

  List<Employee> getEmployeeNameByMgt();

  List<Employee> getEmployeeNameSal();

  List<Employee> getEmployeeRoleBySal();

  List<Employee> getEmployeeNameSalBySalAvg();

  int updateEmployeeKimPromotion();

  int insertEmployee(Employee employee);

  int deleteEmployeeByName(String name);
}
