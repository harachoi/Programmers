class Solution {
   public int solution(String name) {
        int answer = 0;
        int min_cursor = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A' , 'Z' - name.charAt(i) + 1);
            
            int index = i + 1;
            for (int j = index; j < name.length(); j++) {
                if (name.charAt(j) == 'A') index++;
                else break;
            }
            min_cursor = Math.min(min_cursor, i + name.length() - index + i);
        }
        answer += min_cursor;
        return answer;
    }
}
