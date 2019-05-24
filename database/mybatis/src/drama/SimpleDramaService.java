package io.wisoft.seminar.drama;

import io.wisoft.seminar.configure.ConnectionMaker;
import io.wisoft.seminar.student.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SimpleDramaService implements DramaService {

  final ConnectionMaker connectionMaker = new ConnectionMaker();

  @Override
  public List<Drama> getDramaByPrd() {
    List<Drama> dramaList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final DramaService service = sqlSession.getMapper(DramaService.class);
      dramaList = service.getDramaByPrd();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return dramaList;
  }

  public List<Drama> getDramaByBrd() {
    List<Drama> dramaList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final DramaService service = sqlSession.getMapper(DramaService.class);
      dramaList = service.getDramaByBrd();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return dramaList;
  }

  public List<Drama> getDramaPrd() {
    List<Drama> dramaList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final DramaService service = sqlSession.getMapper(DramaService.class);
      dramaList = service.getDramaPrd();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return dramaList;
  }

  public List<Drama> getDramaNameByOpDateIsNull() {
    List<Drama> dramaList = new ArrayList<>();

    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final DramaService service = sqlSession.getMapper(DramaService.class);
      dramaList = service.getDramaNameByOpDateIsNull();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return dramaList;
  }

  public int updateDramaOpDate(String opDate) {
    int result = 0;
    try (final SqlSession sqlSession = connectionMaker.getSqlSession()) {
      final DramaService service = sqlSession.getMapper(DramaService.class);
      result = service.updateDramaOpDate(opDate);
      sqlSession.commit();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return result;
  }

}
