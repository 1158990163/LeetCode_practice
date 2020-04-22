package JZoffer;

public class Solution04 {
    public int maxDepth(TreeNode root) {
        return root==null? 0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
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
