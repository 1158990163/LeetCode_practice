package LeetCode;




//572. 另一个树的子树

public class Solution34 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        } else if (s.val == t.val && isSameTree(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == q) || (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {

        TreeNode a  = new TreeNode(2);
        System.out.println(a.right==a.left);
    }
}
