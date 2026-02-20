class Solution {
    // using kruskal algo(usind DSU)
    // tc edges ke liye hi n2 lag ja raha h and pq.add karne ke liye log n lag ja rhe hai
    // (n2logn) tc for this 
    // if you are using arraylist inplace of priorityqueue then TC =O(n2);
    static int parent[];
    static int size[];
    class Triplet implements Comparable<Triplet>{
        int u;
        int v;
        int dis;
        Triplet(int u,int v,int dis){
            this.u=u;
            this.v=v;
            this.dis=dis;
        }
        public int compareTo(Triplet other){
            return this.dis-other.dis;
        }

    }
    public int leader(int x){
        if(parent[x]==x) return x;
        return parent[x]=leader(parent[x]);
    }
    public void union(int u,int v){
        int uA=leader(u);
        int uB=leader(v);
        if(uA!=uB){
            if(size[uA]>size[uB]){
                parent[uB]=uA;
            }
            else{
                parent[uA]=uB;

            }

        }


    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        PriorityQueue<Triplet>pq=new PriorityQueue<>();
        for(int u=0;u<n;u++){
            for(int v=u+1;v<n;v++){
                int x1=points[u][0];
                int y1=points[u][1];
                int x2=points[v][0];
                int y2=points[v][1];
                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);
                pq.add(new Triplet(u,v,dist));
            }
        }
        int cost=0;
        while(pq.size()>0){
            Triplet top=pq.remove();
            int u=top.u;
            int v=top.v;
            int dist=top.dis;
            
            if(leader(u)!=leader(v)){
                cost+=dist;
                union(u,v);
            }

        }
        return cost;
        
    }
}