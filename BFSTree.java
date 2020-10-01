import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode3
{
    int val;
    TreeNode3 left;
    TreeNode3 right;

    TreeNode3(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}
public class BFSTree {
    public List<Integer> BFStraversal(TreeNode3 tree)
    {
        Queue<TreeNode3> queue  = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        if(tree == null)
        {
            return list;
        }

        queue.add(tree);

        while(!queue.isEmpty())
        {
            TreeNode3 t = queue.poll();
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
        TreeNode3 tree = null;
        tree = new TreeNode3(10);
        tree.left = new TreeNode3(11);
        tree.right = new TreeNode3(15);
        tree.left.left = new TreeNode3(16);
        tree.right.right = new TreeNode3(17);
        tree.left.right= new TreeNode3(19);
        tree.right.left = new TreeNode3(20);
        System.out.println(b.BFStraversal(tree));
    }
}