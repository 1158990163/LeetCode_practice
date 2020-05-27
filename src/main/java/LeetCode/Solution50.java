package LeetCode;


public class Solution50 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int next = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            next += i >= 0 ? a.charAt(i) - '0' : 0;
            next += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(next % 2);
            next = next / 2;
        }
        if (next > 0) {
            res.append(next);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010101";
        String b = "111110111";
        Solution50 solution50 = new Solution50();
        System.out.println(solution50.addBinary(a, b));

    }
}
