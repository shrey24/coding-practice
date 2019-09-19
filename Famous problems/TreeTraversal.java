import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//* Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(){};
}

class TreeTraversal{

    public void inOrderRec(TreeNode root){
        if(root != null){
            inOrderRec(root.left);
            System.out.print(root.val+" ");
            inOrderRec(root.right);
        }
    }

    public void inOrder(TreeNode root){
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val+" ");

            curr = curr.right;
        }
    }


    public void preOrderRec(TreeNode root){
        if(root != null){
            System.out.print(root.val+" ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void preOrder(TreeNode root){
        TreeNode curr = root;
        if(curr == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);

        while(!stack.isEmpty()){
            curr = stack.pop();
            
            System.out.print(curr.val+" ");
            
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
    }

    public void postOrderRec(TreeNode root){
        if(root != null){
            preOrderRec(root.left);
            preOrderRec(root.right);
            System.out.print(root.val+" ");
        }
    }

    public void postOrder(TreeNode root){
        TreeNode curr = root;
        if(curr == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);

        
    }


    public void bfs(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            System.out.print(curr.val+" ");
            
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // make binary tree from given array
    public TreeNode makeTree(Integer[] arr){
        TreeNode[] treeList = new TreeNode[arr.length];
        for(int i=0; i<treeList.length; i++){
            
            if(arr[i] == null) continue;

            if(treeList[i] == null){
                treeList[i] = new TreeNode(arr[i]);
            }
            int leftChieldIndex = (i*2)+1;
            int rightChieldIndex = (i*2)+2;
            if (leftChieldIndex < arr.length && arr[leftChieldIndex] != null){
                treeList[leftChieldIndex] = new TreeNode(arr[leftChieldIndex]);
                treeList[i].left = treeList[leftChieldIndex];
            }
            else{
                treeList[i].left = null;                
            }
            if (rightChieldIndex < arr.length && arr[rightChieldIndex] != null){
                treeList[rightChieldIndex] = new TreeNode(arr[rightChieldIndex]);
                treeList[i].right = treeList[rightChieldIndex];
            }
            else{
                treeList[i].right = null;                
            }
        }
        return treeList[0];
    }


    public static void main(String[] args) {
        TreeTraversal o = new TreeTraversal();
        Integer[] nodes = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = o.makeTree(nodes);
        o.inOrderRec(root);
        System.out.println();
        o.inOrder(root);     
        System.out.println();
        o.preOrder(root);
        System.out.println();


    }
}