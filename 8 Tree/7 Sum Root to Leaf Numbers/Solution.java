
// Definition for a binary tree node.
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

class Solution {
    int ans;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        f(root, 0);
        return ans;
    }

    private void f(TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum = sum * 10 + root.val;
            ans += sum;
            return;
        }
        f(root.left, sum * 10 + root.val);
        f(root.right, sum * 10 + root.val);
    }
}