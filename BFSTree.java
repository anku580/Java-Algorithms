import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}
public class BFSTree {
    public List<Integer> BFStraversal(TreeNode tree)
    {
        Queue<TreeNode> queue  = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        if(tree == null)
        {
            return list;
        }

        queue.add(tree);

        while(!queue.isEmpty())
        {
            TreeNode t = queue.poll();
            list.add(t.val);

            if(t.left != null)
            {
                queue.add(t.left);
            }
            if(t.right != null)
            {
                queue.add(t.right);
            }
        }

        return list;

    }
}

class BFSTreeDemo
{
    public static void main(String[] args) {
      

        BFSTree b = new BFSTree();
        TreeNode tree = null;
        tree = new TreeNode(10);
        tree.left = new TreeNode(11);
        tree.right = new TreeNode(15);
        tree.left.left = new TreeNode(16);
        tree.right.right = new TreeNode(17);
        tree.left.right= new TreeNode(19);
        tree.right.left = new TreeNode(20);
        System.out.println(b.BFStraversal(tree));
    }
}
