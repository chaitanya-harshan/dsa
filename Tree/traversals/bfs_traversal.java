package Tree.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class bfs_traversal {
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i=0; i<len; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                list.add(q.poll().val);
            }
            tree.add(list);
        }

        return tree;
    }
}


