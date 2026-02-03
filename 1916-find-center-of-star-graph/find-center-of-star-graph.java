class Solution {
    public int findCenter(int[][] edges) {
        // TC AND SC =O(n);
        // Aprroach1=>using indegree 
        
        HashMap<Integer,Integer>map=new HashMap<>();
        // <node ,degree>
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(map.containsKey(u)){
                map.put(u,map.get(u)+1);

            }
            else{
                map.put(u,1);
            }
            if(map.containsKey(v)){
                map.put(v,map.get(v)+1);

            }
            else{
                map.put(v,1);
            }
            

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