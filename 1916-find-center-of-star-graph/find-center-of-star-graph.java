class Solution {
    public int findCenter(int[][] edges) {
        // TC AND SC =O(n);
        // Aprroach1=>using indegree 
        
        HashMap<Integer,Integer>map=new HashMap<>();
        // <node ,degree>
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);

        }
        int n=map.size();
        for(int ele:map.keySet()){
            if(map.get(ele)==n-1){
                return ele;
            }
        }
        return -1;
        
    }
}