class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') index = -1;
            sb.append(index % 2 == 0 ? Character.toUpperCase(s.charAt(i)): Character.toLowerCase(s.charAt(i)));
            index++;
        }
        return sb.toString();
    }
}
