package io.wisoft.seminar.employee;

public class Employee {

  private String code;
  private String name;
  private String name2;
  private String rname;
  private String rcode;
  private String mgt;
  private Integer sal;
  private String sum;
  private String avg;
  private String min;
  private String max;

  public Employee() { }

  public Employee(String code, String name, String mgt, Integer sal, String rcode) {
    this.code = code;
    this.name = name;
    this.mgt = mgt;
    this.sal = sal;
    this.rcode = rcode;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("[ ");
    if (code != null) sb.append("| CODE='").append(code).append("\' |");
    if (name != null) sb.append("| NAME='").append(name).append("\' |");
    if (name2 != null) sb.append("| NAME='").append(name2).append("\' |");
    if (rname != null) sb.append("| RNAME='").append(rname).append("\' |");
    if (mgt != null) sb.append("| MGT='").append(mgt).append("\' |");
    if (sal != null) sb.append("| SAL='").append(sal).append("\' |");
    if (sum != null) sb.append("| SUM='").append(sum).append("\' |");
    if (avg != null) sb.append("| AVG='").append(avg).append("\' |");
    if (min != null) sb.append("| MIN='").append(min).append("\' |");
    if (max != null) sb.append("| MAX='").append(max).append("\' |");
    sb.append(" ]");
    return sb.toString();
  }

}
