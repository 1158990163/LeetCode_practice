package JZoffer;

public class Solution01 {
    public String reverseLeftWords(String s, int n) {
        char[] temp_s = s.toCharArray();
        StringBuffer new_s = new StringBuffer();
        for (int i = n; i < s.length(); i++) {
            new_s.append(temp_s[i]);
        }
        for (int i = 0; i < n; i++) {
            new_s.append(temp_s[i]);
        }


        return new_s.toString();
    }

    public static void main(String[] args) {
//        s = "abcdefg", k = 2
        String s = "abcdefg";
        int k = 2;
        Solution01 a = new Solution01();
        String s1 = a.reverseLeftWords(s, k);
        System.out.println(s1);

    }

}
