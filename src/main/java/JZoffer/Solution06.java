package JZoffer;

public class Solution06 {
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    public static void main(String[] args) {
        String s= "we are the world";
        Solution06 a = new Solution06();
        String s1 = a.replaceSpace(s);
        System.out.println(s1);
    }
}
