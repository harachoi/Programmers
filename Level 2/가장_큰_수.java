import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> st = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            st.add(String.valueOf(numbers[i]));
        }
        Collections.sort(st, (o1, o2) -> (o2+o1).compareTo((o1 + o2)));
        if (st.get(0).equals("0")) {
            return "0";
        }

        String result = "";
        for (String i : st) {
            result += i;
        }
        return result;
    }
}
