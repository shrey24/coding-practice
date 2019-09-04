class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinaryTreeDepth {
    
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    

    public int minDepth(TreeNode root) {
        if (root == null) return 0; 
        if(root.left == null && root.right == null) return 1;
        if(root.left == null){
            return  1 + minDepth(root.right);
        }
        else if(root.right == null){
            return  1 + minDepth(root.left);            
        } 
        return  1 + Math.min(minDepth(root.right), minDepth(root.left));
    }
}