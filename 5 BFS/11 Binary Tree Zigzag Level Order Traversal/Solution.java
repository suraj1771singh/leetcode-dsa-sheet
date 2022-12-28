import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// NOTE : for zig, pop_back, push_front, left then right,
// for zag, pop_front, push_back, right then left

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean isLR = false;
        TreeNode cur = null;
        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            int count = deque.size();
            while (count-- > 0) {
                if (isLR) {
                    cur = deque.removeFirst();
                    if (cur.right != null)
                        deque.addLast(cur.right);
                    if (cur.left != null)
                        deque.addLast(cur.left);
                } else {
                    cur = deque.removeLast();
                    if (cur.left != null)
                        deque.addFirst(cur.left);
                    if (cur.right != null)
                        deque.addFirst(cur.right);
                }
                list.add(cur.val);
            }
            isLR = !isLR;

            res.add(new ArrayList<Integer>(list));
            list.clear();
        }
        return res;
    }
}