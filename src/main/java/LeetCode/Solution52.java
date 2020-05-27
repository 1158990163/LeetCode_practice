package LeetCode;

public class Solution52 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        res.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (res.length() == 0) return "";
            if (res.length() > strs[i].length()) res.delete(strs[i].length(), res.length());
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    res.delete(j, res.length());
                    break;
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"aa", "a"};
        Solution52 solution52 = new Solution52();
        System.out.println(solution52.longestCommonPrefix(strings));
    }
}
