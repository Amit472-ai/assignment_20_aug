import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class Solution {
    class Pair {
        TreeNode node;
        long idx; 
        public Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int width = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            long minIdx = q.peek().idx;
            int size = q.size();
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                long curIdx = p.idx - minIdx;
                if (i == 0) first = curIdx;
                if (i == size - 1) last = curIdx;
                if (p.node.left != null) {
                    q.add(new Pair(p.node.left, 2 * curIdx + 1));
                }
                if (p.node.right != null) {
                    q.add(new Pair(p.node.right, 2 * curIdx + 2));
                }
            }
            width = Math.max(width, (int)(last - first + 1));
        }
        return width;
    }
}
