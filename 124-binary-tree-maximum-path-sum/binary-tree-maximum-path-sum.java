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
class Solution {
    static int maxsum;
    public int linesum(TreeNode root){
        if(root==null) return 0;
        int left=linesum(root.left);
        int right=linesum(root.right);
        int sum=root.val;
        if(left>0)sum+=left;
        if(right>0)sum+=right;
        maxsum=Math.max(maxsum,sum);
        return root.val+Math.max(0,Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        maxsum=Integer.MIN_VALUE;
        linesum(root);
        return maxsum;
        
    }
}