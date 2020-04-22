package LeetCode;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import jdk.nashorn.internal.ir.WhileNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

//判断一个简单二叉树是不是对称的

public class Solution08 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(root);

        while (!nodes.isEmpty()){
            TreeNode t1 = nodes.poll();
            TreeNode t2 = nodes.poll();
            if(t1==null&&t2==null){continue;}
            if(t1==null||t2==null){return false;}
            if(t1.val!=t2.val){return false;}
            nodes.offer(t1.left);
            nodes.offer(t2.right);
            nodes.offer(t1.right);
            nodes.offer(t2.left);
        }
        return true;
    }
//    public boolean isSymmetric(TreeNode root) {
//
//        return isMirrors(root, root);
//    }
//
//    public static boolean isMirrors(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) {
//            return true;
//        }
//        if (t1 == null || t2 == null) {
//            return false;
//        }
//        return (t1.val==t2.val)&&isMirrors(t1.left,t2.right)&&isMirrors(t1.right,t2.left);
//    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(2);
        TreeNode t34 = new TreeNode(2);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t22.right = t34;

        Solution08 a = new Solution08();
        boolean symmetric = a.isSymmetric(t1);
        System.out.println(symmetric);


    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

