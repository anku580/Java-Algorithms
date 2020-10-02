/*
This code has been written by - Amrit Raj

This is a functional code with the following specifications:-
Arguments - Root node of the Tree defined by class TreeNode
Return - An int signifying the second minimum node in the given tree. In case
it is not found, it returns -1
*/

public int findSecondMinimumValue(TreeNode root) {
        //A queue to store the nodes..
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null)
            return -1;
        int min = root.val;
        int secondMin = Integer.MAX_VALUE;
        boolean found = false;

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.val > min) {
                    secondMin = Math.min(node.val, secondMin);
                    found = true;
                    continue;
                }
                //Left subtree..
                if (node.left != null && node.left.val <= secondMin)
                    q.add(node.left);
                //Right Subtree
                if (node.right != null && node.right.val <= secondMin)
                    q.add(node.right);
            }
        }
        //Returning second min, else -1...
        return found? secondMin : -1;
    }
