import java.util.Stack;

//* Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class ValidateBST{

    // One compares the node value with its upper and lower limits if they are available. 
    // Then one repeats the same step recursively for left and right subtrees.
    public boolean isValidBST(TreeNode root) {
        return validBSTRec(root, null, null);
    }

    // recursive
    public boolean validBSTRec(TreeNode node, Integer lower, Integer upper){
        if(node == null) return true;
        
        if(lower != null && node.val <= lower) return false;
        if(upper != null && node.val >= upper) return false;
        
        if(! validBSTRec(node.left, lower, node.val)) return false;
        if(! validBSTRec(node.right, node.val, upper)) return false;
        
        return true;
    }

    /* 
    //Iterative using InOrder traversal
    // InOrder = left => root => right. So check left < root < right
    public boolean isValidBST_Inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        int prev_inorder = Integer.MIN_VALUE;
        while(!stack.empty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= prev_inorder) return false;

            prev_inorder = root.val;
            root = root.right;
        }
        return true;       
    }

    // public int prev=Integer.MIN_VALUE;
    //NOTE: This recursive calls doesnot change primitive (int) prev
    // as Java is CALL BY VALUE. So, In order to pass variable prev and 
    // recursively change its value, we pass it as an int array of size 1.
    public boolean inOrder(TreeNode root, int[] prev){ 
        if(root.left != null) inOrder(root.left, prev);
        
        System.out.println(prev[0]);
        if(root.val <= prev[0]) return false;
        prev[0] = root.val;
        
        if(root.right != null) return inOrder(root.right, prev);
        return true;
        
    }

    */
    public void change(Integer[] x){
     x[0] = -1;   
    }

    /*
    public void helpInorder(TreeNode root, int[] prev, boolean res){
        if(root != null && res){
            if(root.left != null){
                helpInorder(root.left, prev, res);
            }
            if(root.val <= prev[0]) {res = false;}
            prev[0] = root.val;
            if(root.right != null){
                helpInorder(root.right, prev, res);
            }
        }
    }
    */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        TreeNode r = new TreeNode(4);
        r.left = new TreeNode(3);
        r.right = new TreeNode(6);
        root.right = r;

        ValidateBST o = new ValidateBST();
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(1);
        int[] prev = {Integer.MIN_VALUE};
        System.out.println(o.inOrder(root2, prev));

        Integer x[] = {0};
        o.change(x);
        // System.out.println(x[0]); 

        boolean ans = true;
        int[] p  ={Integer.MIN_VALUE};
        o.helpInorder(root2, p, ans );
        System.out.println("help In: "+ ans);
        
    }

}