package io.wisoft.seminar.thisisjava.optional.ex1;

import java.util.Date;

public class Order {

  private Long id;
  private Date date;
  private Members members;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Members getMembers() {
    return members;
  }

  public void setMembers(Members members) {
    this.members = members;
  }

}
