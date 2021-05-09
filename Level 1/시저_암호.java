class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char c = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') c = ' ';
            else if (Character.isLowerCase(s.charAt(i)) && s.charAt(i) + n > 'z') c = (char) ('a' + (s.charAt(i) + n) - 'z' - 1);
            else if (Character.isUpperCase(s.charAt(i)) && s.charAt(i) + n > 'Z') c = (char) ('A' + (s.charAt(i) + n) - 'Z' - 1);
            else c = (char) (s.charAt(i) + n);
            sb.append(c);
        }
        return sb.toString();
    }
}
