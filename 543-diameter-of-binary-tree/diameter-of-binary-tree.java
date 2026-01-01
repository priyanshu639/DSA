/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//  USING DP WE SOLVE THIS 
// TO USE DP IN THE DIAMETER OF TREE WE WILL USE THE HASHMAP
class Solution {
    static HashMap<TreeNode,Integer>dp;
    public int  levels(TreeNode root){
        if(root==null) return 0;
        if(dp.containsKey(root))return dp.get(root);
        dp.put(root,1 + Math.max(levels(root.left),levels(root.right)));
        return dp.get(root);
        
    }
    public int diameter(TreeNode root) {
        if(root==null) return 0;
        int myDia=levels(root.left)+levels(root.right);
        int leftDia=diameter(root.left);

        int rightDia=diameter(root.right);
        return Math.max(myDia,Math.max(leftDia,rightDia));
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dp=new HashMap<>();
        return diameter(root);
        
    }
}