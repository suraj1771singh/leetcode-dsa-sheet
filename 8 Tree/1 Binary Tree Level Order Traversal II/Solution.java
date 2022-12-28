
import java.util.*;

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
    List<List<Integer>> ans;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        ans = new ArrayList<>();
        if (root == null)
            return ans;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        f(list);
        return ans;

    }

    private void f(ArrayList<TreeNode> prev_list) {
        if (prev_list.size() == 0)
            return;
        ArrayList<TreeNode> list = new ArrayList<>();
        for (TreeNode node : prev_list) {
            if (node.left != null)
                list.add(node.left);
            if (node.right != null)
                list.add(node.right);
        }
        f(list);
        List<Integer> int_list = new ArrayList<>();
        for (TreeNode node : prev_list)
            int_list.add(node.val);
        ans.add(int_list);
    }
}