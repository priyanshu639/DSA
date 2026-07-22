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
    private static  int level (TreeNode root){
        if(root==null) return 0;
          return 1 + Math.max(level(root.left),level(root.right));
     }



    private static void preorder(TreeNode root,int level,List<Integer> ans){
        if(root==null) return ;
        ans.set(level,root.val);
        preorder(root.left,level+1,ans);
        preorder(root.right,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans =new ArrayList<>();
        int n=level(root);
        for(int i=0;i<n;i++){
            ans.add(0);
        }
        preorder(root,0,ans);
        return ans;

        
    }
}