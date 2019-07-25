package io.wisoft.seminar.programmers.bestalbum;

import java.util.*;

public class Solution {

  public int[] solution(String[] genres, int[] plays) {
    LinkedList<Integer> answer = new LinkedList<>();
    HashMap<String, PriorityQueue<Integer>> hash = new HashMap<>();
    HashMap<String, Integer> sumHash = new HashMap<>();
    PriorityQueue<Integer> tempQueue;

    for (int j = 0; j < genres.length; j++) {
      if (!sumHash.containsKey(genres[j])) {
        sumHash.put(genres[j], plays[j]);
      } else {
        sumHash.put(genres[j], sumHash.get(genres[j]) + plays[j]);
      }
    }
    for (int i = 0; i < genres.length; i++) {
      if (!hash.containsKey(genres[i])) {
        hash.put(genres[i], new PriorityQueue<>(Collections.reverseOrder()));
        tempQueue = hash.get(genres[i]);
        tempQueue.offer(plays[i]);
        hash.put(genres[i], tempQueue);
      } else {
        tempQueue = hash.get(genres[i]);
        tempQueue.offer(plays[i]);
        hash.put(genres[i], tempQueue);
      }
    }
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int play : plays) {
      arrayList.add(play);
    }
    sumHash
        .values()
        .stream()
        .sorted(Comparator.reverseOrder())
        .forEach(playSum -> {
          for (int i = 0; i < 2; i++) {
            if (hash.get(getKey(sumHash, playSum)).size() == 1) {
              answer.add(arrayList.indexOf(hash.get(getKey(sumHash, playSum)).peek()));
              arrayList.set(arrayList.indexOf(hash.get(getKey(sumHash, playSum)).poll()), -1);
              break;
            } else {
              answer.add(arrayList.indexOf(hash.get(getKey(sumHash, playSum)).peek()));
              arrayList.set(arrayList.indexOf(hash.get(getKey(sumHash, playSum)).poll()), -1);
            }
          }
        });
    return answer.stream().mapToInt(i -> i).toArray();
  }

  public static String getKey(Map<String, Integer> map, int value) {
    for (String key : map.keySet()) {
      if (map.get(key).equals(value)) {
        return key;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Solution bestAlbum = new Solution();
    int[] ans = bestAlbum.solution(new String[]{"classic", "pop", "classic", "pop", "classic", "classic"}, new int[]{400, 600, 150, 2500, 500, 500});


  }

}
