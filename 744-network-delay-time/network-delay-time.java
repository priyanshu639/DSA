class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int wt;
        
        Pair(int node,int wt){
            this.node=node;
            this.wt=wt;
            
        }
        public int compareTo(Pair other){
            return this.wt-other.wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // create adj list
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new Pair(v,w));
            
        }
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(k,0));
        

        
        while(pq.size()>0){
            Pair top=pq.remove();
            int node=top.node;
            int wt=top.wt;
            
            for(Pair ele:adj.get(node)){
                int totalwt=wt+ele.wt;
                if(wt > dist[node]) continue;

                if(totalwt<dist[ele.node]){
                    dist[ele.node]=totalwt;
                    pq.add(new Pair(ele.node,totalwt));
                }
            }

        }
        int max=0;
        for(int i=1;i<dist.length;i++){
            max=Math.max(dist[i],max);

        }
        if(max==Integer.MAX_VALUE) return -1;
        return max;


        
    }
}