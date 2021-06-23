import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        int remainNumber = len - k;
        int maxIdx = 0;

        while(remainNumber > 0) {
            char maxChar = '0';
            for(int i=maxIdx; i<=len-remainNumber; i++) { 
                if(number.charAt(i) > maxChar) { 
                    maxChar = number.charAt(i);
                    maxIdx = i;
                }
            }
            sb.append(maxChar);
            maxIdx++;
            remainNumber--;
        }

        return sb.toString();
    }
}
