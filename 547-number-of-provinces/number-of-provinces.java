class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean visited[]=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(i,visited,isConnected);
                count++;
            }

        }
        return count;
    }
         void bfs(int i,boolean visited[],int isConnected[][]){
            visited[i]=true;
            Queue<Integer>q=new LinkedList<>();
            q.add(i);
            while(q.size()>0){
                int front= q.remove();
                // colum me traverse kr ke dekho ki koi 1 h 
                 for(int j=0;j<isConnected.length;j++){
                    if(isConnected[front][j]==1 &&!visited[j]){
                        q.add(j);
                        visited[j]=true;
                    }
                    
                }


            }
        //    time complexity for bfs(adjacency matrix) is worst case o(n^2);
        // general time complexity would be in adjacency list o(V+2E); 
            

         
        
    }
}