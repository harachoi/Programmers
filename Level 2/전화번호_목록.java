import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        String pre = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].contains(pre)) {
                return false;
            }
        }
        return true;
    }
}
