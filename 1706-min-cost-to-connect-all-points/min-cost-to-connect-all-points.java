class Solution {
    class Triplet implements Comparable<Triplet>{
         // node yaha pe index h
        int node ;
        int parent;
        int dist;
        Triplet(int node,int parent,int dist){
            this.node=node;
            this.parent=parent;
            this.dist=dist;

        }
        public int compareTo(Triplet other){
            return this.dist-other.dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Triplet>pq=new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        boolean vis[]=new boolean[n];
        int sum=0;
        while(pq.size()>0){
            Triplet top=pq.remove();
            // node yaha pe index h
            int node=top.node;
            int parent=top.parent;
            int dist=top.dist;
            if(vis[node]==true)continue;
            sum+=dist;
            vis[node]=true;
            for(int i=0;i<n;i++){
                if(i==node || i==parent)continue;
                if(vis[i]==true)continue;
                int x1=points[node][0];
                int y1=points[node][1];
                int x2=points[i][0];
                int y2=points[i][1];
                int md=Math.abs(x2-x1)+Math.abs(y2-y1);
                pq.add(new Triplet(i,node,md));

            }
        }
        return sum;
    }
}