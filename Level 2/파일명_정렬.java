class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};

        for (int i = 1; i < files.length; i++) {
            for (int k = i; k > 0; k--) {
                String[] curr = files[k].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                String[] pre = files[k - 1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                if (curr[0].toLowerCase().compareTo(pre[0].toLowerCase()) < 0) {
                    swap(files,  k - 1, k);
                } else if (curr[0].toLowerCase().compareTo(pre[0].toLowerCase())== 0) {
                    //compare number
                    String num1 = String.valueOf(Integer.parseInt(pre[1]));
                    String num2 = String.valueOf(Integer.parseInt(curr[1]));

                    if (Integer.parseInt(num1) > Integer.parseInt(num2)) {
                        swap(files, k - 1, k);
                    }
                }
            }
        }
        return files;
    }

    public void swap(String[] files, int i, int j) {
        String tmp = files[i];
        files[i] = files[j];
        files[j] = tmp;
    }
}
