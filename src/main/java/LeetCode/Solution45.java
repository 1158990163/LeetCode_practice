package LeetCode;

//  680. 验证回文字符串 Ⅱ

public class Solution45 {
    public boolean validPalindrome(String s) {

        byte[] bytes = s.getBytes();
        int len = bytes.length;
        for (int i = 0; i < len; i++) {
            if (bytes[i] != bytes[len - 1 - i]) return isPalindrome(bytes, i) || isPalindrome(bytes, len - 1 - i);
        }
        return true;
    }

    public boolean isPalindrome(byte[] bytes, int out) {
        byte[] new_bytes = new byte[bytes.length - 1];
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (i == out) continue;

            new_bytes[index++] = bytes[i];
        }
        for (int i = 0; i < new_bytes.length; i++) {
            if (new_bytes[i]!=new_bytes[new_bytes.length-1-i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution45 a = new Solution45();
        boolean b = a.validPalindrome("1");
        System.out.println(b);
    }
}
