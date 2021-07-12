import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> record = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        //장르별 플레이 횟수 저장
        for (int i = 0; i < genres.length; i++) {
            record.put(genres[i], record.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> sort = new ArrayList<>(record.keySet());
        Collections.sort(sort, (o1, o2) -> (record.get(o2).compareTo(record.get(o1))));

        for (int i = 0; i < sort.size(); i++) {
            String gen = sort.get(i);
            int firstIdx = 0;
            int secondIdx = 0;
            int max = 0;
            for (int j = 0; j < genres.length; j++) {
                if (gen.equals(genres[j])) {
                    if (plays[j] > max) {
                        max = plays[j];
                        firstIdx = j;
                    }
                }
            }

            max = -1;
            for (int j = 0; j < genres.length; j++) {
                if (gen.equals(genres[j])) {
                    if (j != firstIdx && plays[j] > max) {
                        max = plays[j];
                        secondIdx = j;
                    }
                }
            }

            answer.add(firstIdx);
            if (max != -1) {
                answer.add(secondIdx);
            }
        }
        return  answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
