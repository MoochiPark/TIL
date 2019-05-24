package io.wisoft.seminar.drama;

public class Drama {

  private String code;
  private String name;
  private String prd;
  private String brd;
  private String opDate;

  public Drama() { }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("[ ");
    if (code != null) sb.append("| CODE='").append(code).append("\' |");
    if (name != null) sb.append("| NAME='").append(name).append("\' |");
    if (prd != null) sb.append("| PRD='").append(prd).append("\' |");
    if (brd != null) sb.append("| BRD='").append(brd).append("\' |");
    if (opDate != null) sb.append("| OPDATE='").append(opDate).append("\' |");
    sb.append(" ]");
    return sb.toString();
  }

}
