package io.wisoft.seminar.programmers.unfinishedplayer;

import java.util.*;

public class Solution {

  public String solution(String[] participant, String[] completion) {
    HashMap<String, Integer> hash = new HashMap<>();
    for (String part : participant) {
      if (!hash.containsKey(part)) {
        hash.put(part, 1);
      } else {
        hash.put(part, hash.get(part) + 1);
      }
    }
    for (String comp : completion) {
      if (hash.get(comp) == 1) {
        hash.remove(comp);
      } else {
        hash.replace(comp, hash.get(comp) - 1);
      }
    }

    return hash.keySet().iterator().next();
  }

  public static void main(String[] args) {
    Solution unfinishedPlayer = new Solution();
    System.out.println(unfinishedPlayer.solution(
        new String[]{"leo", "kiki", "eden", "kiki"}, new String[]{"leo", "eden", "kiki"}));
  }

}
