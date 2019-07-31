## 베스트 앨범 LV.3

###### 문제 설명

스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

##### 제한사항

- genres[i]는 고유번호가 i인 노래의 장르입니다.
- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
- 장르 종류는 100개 미만입니다.
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
- 모든 장르는 재생된 횟수가 다릅니다.

##### 입출력 예

| genres                                | plays                      | return       |
| :------------------------------------ | :------------------------- | :----------- |
| [classic, pop, classic, classic, pop] | [500, 600, 150, 800, 2500] | [4, 1, 3, 0] |

##### 입출력 예 설명

classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

- 고유 번호 3: 800회 재생
- 고유 번호 0: 500회 재생
- 고유 번호 2: 150회 재생

pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

- 고유 번호 4: 2,500회 재생
- 고유 번호 1: 600회 재생

따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

> #### 소스 코드
```java
package io.wisoft.seminar.programmers.bestalbum;

import java.util.*;

public class Solution {

  public int[] solution(String[] genres, int[] plays) {
    LinkedList<Integer> answer = new LinkedList<>();
    HashMap<String, PriorityQueue<Music>> classifiedHash = new HashMap<>();
    HashMap<String, Integer> sumHash = new HashMap<>();

    for (int j = 0; j < genres.length; j++) {
      if (!sumHash.containsKey(genres[j])) {
        sumHash.put(genres[j], plays[j]);
      } else {
        sumHash.put(genres[j], sumHash.get(genres[j]) + plays[j]);
      }
    }
    for (int i = 0; i < genres.length; i++) {
      if (!classifiedHash.containsKey(genres[i])) {
        classifiedHash.put(genres[i], new PriorityQueue<>(Comparator.comparing(Music::getPlay, Comparator.reverseOrder())));
      }
        classifiedHash.get(genres[i]).offer(new Music(i, plays[i]));
    }
    sumHash
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
        .forEach(entry -> {
          String genre = entry.getKey();
          answer.add(classifiedHash.get(genre).poll().getIndex());
            if (classifiedHash.get(genre).size() >= 1) {
              answer.add(classifiedHash.get(genre).poll().getIndex());
            }
        });

    return answer.stream().mapToInt(i -> i).toArray();
  }

  class Music {

    private int index;
    private int play;

    public Music(int index, int play) {
      this.index = index;
      this.play = play;
    }

    public int getIndex() {
      return index;
    }

    public int getPlay() {
      return play;
    }

  }

  public static void main(String[] args) {
    Solution bestAlbum = new Solution();
    int[] ans = bestAlbum.solution(new String[]{"classic", "pop", "classic", "pop", "classic", "classic"}, new int[]{400, 600, 150, 2500, 500, 500});
    System.out.println(Arrays.toString(ans));

  }

}

```
