package LeetCode;

public class Solution20 {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] copy, int left, int right, int[] temp) {

        if (left == right) return 0;

        int mid = left + (right - left) / 2;

        System.out.println("递归处理下一区间:["+left+","+mid+"]");
        int leftPairs = reversePairs(copy, left, mid, temp);

        System.out.println("递归处理下一区间:["+(mid+1)+","+right+"]");
        int rigthPairs = reversePairs(copy, mid + 1, right, temp);


        //若原本的数组的最后一个比另一个数组的第一个小，那么就没必要进行统计，直接合并即可
//        if (copy[mid] <= copy[mid + 1]) {
//            System.out.println("mid= "+mid+"  返回值");
//            return leftPairs + rigthPairs;
//        }

        System.out.println("执行了mergeAddCount方法,对应的区间是: ["+left+","+mid+","+right+"]");
        System.out.println();
        System.out.println();
        System.out.println();
        int crossCounts = mergeAndCount(copy, left, mid, right, temp);

        System.out.println(leftPairs+rigthPairs+crossCounts+"-------------------->");

        return leftPairs+rigthPairs+crossCounts;
    }

    private int mergeAndCount(int[] copy, int left, int mid, int right, int[] temp) {
//        用临时数组储存需要合并的数组的元素
        for (int i = left; i <= right; i++) {
            temp[i] = copy[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;

        for (int k = left; k <= right; k++) {
            if (i == mid+1) {
                copy[k] = temp[j];
                j++;
            } else if (j == right+1) {
                copy[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                copy[k] = temp[i];
                i++;
            } else {
                copy[k] = temp[j];
                j++;
                count += mid - i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] a=  new int[]{8,6,42,2,334,8,6,42,2,334,8,6,42,2,334};
        Solution20 as = new Solution20();
        int i = as.reversePairs(a);
    }

}
