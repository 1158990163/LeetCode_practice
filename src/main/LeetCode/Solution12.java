package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution12 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        String res = "";
        for (int i = 0; i < s2.length() + 10; i++) {
            res = res + s1;
        }
        char[] temp_s2 = s2.toCharArray();
        char[] temp_res = res.toCharArray();
        int len = 0;
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int j = 0; j < res.length(); j++) {

            if (temp_res[j] == temp_s2[len])
                len += 1;
            if (len == temp_s2.length) {
                len = 0;
                list.add(j - index);
                index = j;
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        index = list.get(0);//从index开始出现循环节
        len = list.get(list.size() - 1);//循环节长度为len
        int end_len = len;
        for (int i = 2; i < s1.length(); i++) {
            if (len != list.get(list.size() - i)) {
                end_len += list.get(list.size() - i);
            }
        }

        int S1_len = s1.length() * n1;
        int S2_len_first = end_len * (n2 - 1) + index;
        int S2_len = end_len * n2;


        for (int i = 0; i <= S1_len; i++) {
            if ((S2_len * i) + S2_len_first >= S1_len) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "nlhqgllunmelayl";
        String s2 = "lnl";
//        Solution12 s = new Solution12();
//        s.getMaxRepetitions(s1,1,s2,2)
//        "nlhqgllunmelayl"
//2
//"lnl"
//1



        String res = "";
        int index = 0;
        int index1 = 0;
        int len = 0;

        for (int i = 0; i < s2.length() + 10; i++) {
            res = res + s1;
        }


        char[] temp_s2 = s2.toCharArray();
        char[] temp_res = res.toCharArray();
        int step = 0;
        for (int j = 0; j < res.length(); j++) {

            if (temp_res[j] == temp_s2[step])
                step += 1;
            if (step == temp_s2.length) {
                step = 0;
                index += 1;
                if (j > res.length() / 2) {
                    index1 = j - len;
                    len = j;
                }
                System.out.println(j);
                System.out.println(index);
                System.out.println("-------------------------------");
            }
        }
        System.out.println(index1);
    }
}
