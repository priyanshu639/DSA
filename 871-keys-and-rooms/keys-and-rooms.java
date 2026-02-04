class Solution {
    // A.S O(n)
    // tc = O(v+e)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n=rooms.size();
        boolean vis[]=new boolean[n];
        vis[0]=true;
        // bfs(0,vis,rooms);
        dfs(0,vis,rooms);
        for(int i=0;i<n;i++){
            if(vis[i]==false) {
               return false ;
              
            }
        }
        return true;
        
    }
    void dfs(int start,boolean vis[],List<List<Integer>> rooms){
        vis[start]=true;
        for(int ele:rooms.get(start)){
            if(!vis[ele]) dfs(ele,vis,rooms);
        }
        
        
    }
    void bfs(int start,boolean vis[],List<List<Integer>> rooms){
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front=q.remove();
            for(int ele:rooms.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }

        }
        
    }
}