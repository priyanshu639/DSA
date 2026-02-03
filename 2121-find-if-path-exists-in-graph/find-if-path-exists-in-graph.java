class Solution {
    // tc and space complexity for this is O(V+2E)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        boolean vis[]=new boolean[n];
        // convert edges[][] ko convert it to adjacency list fir usko bfs ke liye call karo
        List<List<Integer>>ll=new ArrayList<>();
        for(int i=0;i<n;i++){
            ll.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            ll.get(a).add(b);
            ll.get(b).add(a);
        }
        bfs(source,n,ll,vis);
        if(vis[destination]==true) return true;
        else return false;

        
    }
    void bfs(int start,int n,List<List<Integer>>ll,boolean vis[]){
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        vis[start]=true;
        while(q.size()>0){
            int front=q.remove();
            for(int ele:ll.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }

    }
}