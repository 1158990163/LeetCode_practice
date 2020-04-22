package LeetCode;

import java.util.*;

//给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
//        图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

public class Solution15 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    public static Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) return null;
        if (lookup.containsKey(node)) return lookup.get(node);
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);//放置对应的映射，使得后续通过Map寻找能找到新的Node的地址。
        for (Node n : node.neighbors)
            clone.neighbors.add(dfs(n, lookup));
        return clone;
    }
}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
