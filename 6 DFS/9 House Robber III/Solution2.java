import java.time.chrono.IsoEra;
import java.util.HashMap;

//------------------------------------MEMOIZATION

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
    public int rob(TreeNode root) {
        HashMap<TreeNode, HashMap<Boolean, Integer>> map = new HashMap<>();
        return dfs(root, false, map);
    }

    int dfs(TreeNode root, boolean isRobbed, HashMap<TreeNode, HashMap<Boolean, Integer>> map) {
        if (root == null)
            return 0;

        if (map.containsKey(root) && map.get(root).containsKey(isRobbed))
            return map.get(root).get(isRobbed);

        int cost = 0;
        if (isRobbed) {
            cost = dfs(root.left, false, map) + dfs(root.right, false, map);
        } else {
            int notpick = dfs(root.left, false, map) + dfs(root.right, false, map);
            int pick = root.val + dfs(root.left, true, map) + dfs(root.right, true, map);
            cost = Math.max(notpick, pick);
        }

        map.put(root, new HashMap<>());
        map.get(root).put(isRobbed, cost);
        return cost;
    }
}
// Time complexity : O(n)
// AS complexity : height of binary tree
