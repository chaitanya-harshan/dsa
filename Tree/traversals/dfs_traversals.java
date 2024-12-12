package Tree.traversals;

import java.util.ArrayList;
import java.util.List;

public class dfs_traversals {
    
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        in_order(root, list);
        result.add(new ArrayList<>(list));
        list.clear();

        pre_order(root, list);
        result.add(new ArrayList<>(list));
        list.clear();

        post_order(root, list);
        result.add(list);

        return result;
    }

    public static void in_order(TreeNode root, List<Integer> list) {
        if (root == null) return;

        in_order(root.left, list);
        list.add(root.val);
        in_order(root.right, list);
    }

    public static void pre_order(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        pre_order(root.left, list);
        pre_order(root.right, list);
    }

    public static void post_order(TreeNode root, List<Integer> list) {
        if (root == null) return;

        post_order(root.left, list);
        post_order(root.right, list);
        list.add(root.val);
    }
}
