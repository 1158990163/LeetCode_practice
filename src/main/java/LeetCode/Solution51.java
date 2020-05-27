package LeetCode;

public class Solution51 {
    public int strStr(String haystack, String needle) {
        byte[] h = haystack.getBytes();
        byte[] n = needle.getBytes();
        int length = n.length;
        if (length == 0) return 0;
        for (int i = 0; i < h.length; i++) {
            if (h[i] == n[0]) {
                if (i + length > h.length) {
                    return -1;
                }
                for (int j = 0; j < length; j++) {
                    if (h[i + j] != n[j]) break;
                    if (j == length - 1) return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaaa";
        Solution51 s = new Solution51();
        System.out.println(s.strStr(a, b));
    }
}
