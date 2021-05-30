class Solution {
    public int solution(String s) {
        int leng = s.length();
        int min = Integer.MAX_VALUE;
        int countNoMatch = 0;
        for (int i = 1; i <= leng/2; i++) {
            Boolean visit = false;
            int count = 0;
            for (int j = 0; j < s.length(); j = j + i) {
                if (j + i < s.length()) {
                    String key = s.substring(j, j + i);
                    int match = 0;
                    for (int k = j + i; k < s.length(); k = k + i) {
                        if (k + i <= s.length()) {
                            int diff = key.compareTo(s.substring(k, k + i));
                            if (key.compareTo(s.substring(k, k + i)) == 0) {
                                visit = true;
                                match++;
                            }
                            if (k+i == s.length() || diff != 0){
                                j += match * key.length();
                                if (match == 0) {
                                    count += key.length();
                                } else {
                                    count += 1 + key.length(); //number & string
                                }
                                if (k+i > s.length()) {
                                    count+=s.length() - k;
                                }
                                break;
                            }

                        } else {
                            count += s.length() - k;
                            break;
                        }
                    }
                } else {
                    if (j + i >= s.length()) {
                        count += s.length() - j;
                    }
                }
            }
            if (!visit) {
                countNoMatch++;
            }
            if (count < min) {
                min = count;
            }
        }
        if (countNoMatch == s.length()/2) {
            min = s.length();
        }
        return min;
    }
}
