class Solution {
    public boolean bfsBartite(int start,int visited[],int[][] graph){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        while(q.size()>0){
            int front=q.remove();
            
            for(int ele:graph[front]){
                if(visited[ele]==visited[front]){
                    return false;
                }
                if(visited[ele]==0){
                    visited[ele] = -visited[front];
                    
                    q.add(ele);
                }
            }
        }
        return true;


    }
    public boolean isBipartite(int[][] graph) {
        
        // the given graph is  already in adjacecny list  

        int n=graph.length;
        int m=graph[0].length;
        int visited[]=new int[n];

   
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(!bfsBartite(i,visited,graph)){
                    return false;

                }

            }
        }
        
        return true;
    }
    
}