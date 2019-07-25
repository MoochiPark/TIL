package io.wisoft.seminar.programmers.largestnumber;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution implements Comparator<String> {

  public String solution(int[] numbers) {
    ArrayList<String> arrayList = new ArrayList<>();
    Solution largestNumber = new Solution();
    StringBuilder sb = new StringBuilder();

    for (int number : numbers) {
      arrayList.add(Integer.toString(number));
    }
    arrayList.sort(largestNumber);

    for (String str : arrayList) {
      sb.append(str);
    }
    if (sb.substring(0, 1).equals("0")) {
      return "0";
    }
    return sb.toString();
  }

  @Override
  public int compare(String a, String b) {
    return (b + a).compareTo(a + b);
  }

  public static void main(String[] args) {
    Solution largestNumber = new Solution();
    System.out.println(
//        largestNumber.Solution(new int[]{21, 212}));
        largestNumber.solution(new int[]{3, 30, 34, 5, 9}));
  }

}
