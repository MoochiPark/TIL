package io.wisoft.seminar.department;

import org.apache.ibatis.session.SqlSession;
import io.wisoft.seminar.configure.ConnectionMaker;
import java.util.ArrayList;
import java.util.List;

public class SimpleDepartmentService implements DepartmentService {

  final ConnectionMaker connectionMaker = new ConnectionMaker();
  @Override
  public List<Department> getDepartmentAll() {
    List<Department> departmentList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final DepartmentService service = sqlSession.getMapper(DepartmentService.class);
      departmentList = service.getDepartmentAll();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return departmentList;
  }

}
