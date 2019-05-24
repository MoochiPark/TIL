package io.wisoft.seminar.department;

public class Department {

  private String code;
  private String name;
  private String loc;

  public Department(String code, String name, String loc) {
    this.code = code;
    this.name = name;
    this.loc = loc;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("[ ");
    if (code != null) sb.append("| CODE='").append(code).append("\' |");
    if (name != null) sb.append("| NAME='").append(name).append("\' |");
    if (loc != null) sb.append("| LOC='").append(loc).append("\' |");
    sb.append(" ]");
    return sb.toString();
  }

}
