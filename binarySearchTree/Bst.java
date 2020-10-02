public class Bst
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) 
        {
            this.val = val;
            this.right=null;
            this.left=null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    TreeNode root;
    
    public void insert(int data)
    {
        this.root=insertnode(this.root,data);    
    }
    
    private TreeNode insertnode(TreeNode root,int data)
    {
        if (root == null)
        {	
            root=new TreeNode(data);
        	return root;
        }
        else if (data < root.val) 
            root.left=insertnode(root.left, data); 
        else if (data > root.val) 
            root.right=insertnode(root.right, data); 
        return root;
    }
    
    public Boolean search(int data)
    {
        TreeNode node=searchnode(this.root,data);
        return node!=null;
    }
    
    private TreeNode searchnode(TreeNode root,int data)
    {
        if (root==null || root.val==data) 
        	return root; 
        if (root.val>data) 
            return searchnode(root.left,data); 
        return searchnode(root.right, data); 
    }
    
    public static void main(String[] args)
    {
        Bst bst=new Bst();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(14);
        bst.insert(6);
        bst.insert(4);
        System.out.println(bst.search(14)?"Found":"Not Found");
    }
}