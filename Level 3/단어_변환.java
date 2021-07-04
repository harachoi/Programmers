import java.util.*;

class Solution {
    public static HashSet<HashSet<String>> set = new HashSet<>();
    public ArrayList<String> wordList = new ArrayList<>();
    public ArrayList<ArrayList<String>> list = new ArrayList<>();
    public boolean[] visit;
    String[] words;

    public int solution(String begin, String target, String[] words) {
        this.words = words;

        //check if words contains target word
        if (!checkTarget(target)) return 0;

        //find all paths
        visit = new boolean[wordList.size()];
        findPath(begin, target, new ArrayList<String>());

        //find min path
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(list.get(i).size(), min);
        }
        return min;
    }

    public boolean checkTarget(String target) {
        boolean check = false;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) check = true;
            if (words[i].length() == target.length()) wordList.add(words[i]);
        }
        return check;
    }

    public void findPath(String begin, String target, ArrayList<String> path) {
        if (begin.equals(target)) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (!path.contains(wordList.get(i))) {
                if (compare(begin, wordList.get(i))) {
                    visit[i] = true;
                    path.add(wordList.get(i));
                    findPath(wordList.get(i), target, path);
                    path.remove(wordList.get(i));
                    visit[i] = false;
                }

            }
        }
    }

    public boolean compare(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
       if (count == 1) return true;
        return false;
    }
}
