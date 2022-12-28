import java.util.*;

//Definition for a binary tree node.
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

// -----------DFS SOLUTION
class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        f(root, ans, 0);
        return ans;

    }

    private void f(TreeNode root, List<Integer> ans, int level) {
        if (root == null)
            return;
        if (ans.size() == level) {
            ans.add(root.val);
        }
        f(root.right, ans, level + 1);
        f(root.left, ans, level + 1);
    }

}