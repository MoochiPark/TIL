package io.wisoft.seminar.drama;

import java.util.List;

public interface DramaService {

  List<Drama> getDramaByPrd();

  List<Drama> getDramaByBrd();

  List<Drama> getDramaPrd();

  List<Drama> getDramaNameByOpDateIsNull();

  int updateDramaOpDate(String opDate);

}
