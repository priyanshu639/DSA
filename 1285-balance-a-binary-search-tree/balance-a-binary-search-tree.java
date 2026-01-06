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
    public void inorder(TreeNode root,List<Integer> ans){
        if(root==null) return ;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public TreeNode bst(int[]arr,int low,int high){
        if(low>high) return null;
        int mid = (high + low)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = bst(arr,low,mid-1);
        root.right = bst(arr,mid+1,high);
        return root;

    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        int arr[] = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            arr[i] = ans.get(i);
        }

      return  bst(arr,0,arr.length-1);
        
    }
}