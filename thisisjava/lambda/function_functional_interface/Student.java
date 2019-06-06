package io.wisoft.seminar.thisisjava.lambda.function_functional_interface;

public class Student {

  private String name;
  private int englishScore;
  private int mathScore;

  public Student(final String name, final int englishScore, final int mathScore) {
    this.name = name;
    this.englishScore = englishScore;
    this.mathScore = mathScore;
  }

  public String getName() { return name; }
  public int getEnglishScore() { return  englishScore; }
  public int getMathScore() { return  mathScore; }

}
