
//--------------------------------RECURSIVE SOLUTION

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

class Solution1 {
    public int rob(TreeNode root) {
        return dfs(root, false);
    }

    int dfs(TreeNode root, boolean isRobbed) {
        if (root == null)
            return 0;
        if (isRobbed)
            return dfs(root.left, false) + dfs(root.right, false);

        int notpick = dfs(root.left, false) + dfs(root.right, false);
        int pick = root.val + dfs(root.left, true) + dfs(root.right, true);

        return Math.max(notpick, pick);
    }
}
// Time complexity : exponential
// AS complexity : height of binary tree