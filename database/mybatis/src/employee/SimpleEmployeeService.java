package io.wisoft.seminar.employee;

import io.wisoft.seminar.configure.ConnectionMaker;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmployeeService implements EmployeeService {

  final ConnectionMaker connectionMaker = new ConnectionMaker();

  @Override
  public List<Employee> getEmployeeAll() {
    List<Employee> departmentList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      departmentList = service.getEmployeeAll();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return departmentList;
  }

  @Override
  public List<Employee> getEmployeeSalSumAvg() {
    List<Employee> departmentList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      departmentList = service.getEmployeeSalSumAvg();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return departmentList;
  }

  @Override
  public List<Employee> getEmployeeNameByMgt() {
    List<Employee> departmentList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      departmentList = service.getEmployeeNameByMgt();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return departmentList;
  }

  @Override
  public List<Employee> getEmployeeNameSal() {
    List<Employee> departmentList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      departmentList = service.getEmployeeNameSal();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return departmentList;
  }

  @Override
  public List<Employee> getEmployeeRoleBySal() {
    List<Employee> departmentList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      departmentList = service.getEmployeeRoleBySal();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return departmentList;
  }

  @Override
  public List<Employee> getEmployeeNameSalBySalAvg() {
    List<Employee> departmentList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      departmentList = service.getEmployeeNameSalBySalAvg();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return departmentList;
  }

  @Override
  public int updateEmployeeKimPromotion() {
    int result = 0;

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      result = service.updateEmployeeKimPromotion();
      sqlSession.commit();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public int insertEmployee(Employee employee) {
    int result = 0;

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      result = service.insertEmployee(employee);
      sqlSession.commit();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public int deleteEmployeeByName(String name) {
    int result = 0;

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final EmployeeService service = sqlSession.getMapper(EmployeeService.class);
      result = service.deleteEmployeeByName(name);
      sqlSession.commit();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return result;
  }


}
