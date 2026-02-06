class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
        public int compareTo(Pair other){
            return this.distance-other.distance;
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        //convert it to adjacency list
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adj.get(u).add(new Pair(v,w));


        }
        int cost[]=new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[k]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while(pq.size()>0){
            Pair top=pq.remove();
            for(Pair ele:adj.get(top.node)){
                int totaldis=top.distance+ele.distance;
                if(totaldis<cost[ele.node]){
                    cost[ele.node]=totaldis;
                    pq.add(new Pair(ele.node,totaldis));
                    
                }

            }
            

        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(cost[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,cost[i]);

        }
        return ans;


        
    }
}