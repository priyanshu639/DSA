class Solution {
    class Pair{
        int node;
        int cost;
       Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
         
        }

    }
    class Triplet implements Comparable<Triplet>{
        int node;
        int cost;
        int stop;
        Triplet(int node,int cost,int stop){
            this.node=node;
            this.cost=cost;
            this.stop=stop;
        }
        public int compareTo(Triplet other){
            return this.stop-other.stop;
        }

    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // apply kro dijistkta algorithm but stops ke uppar sorting lagao
        //  STEP -1 change it to adj list
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());

        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adj.get(u).add(new Pair(v,w));
        }



        // Step 2 apply dijiskra

        PriorityQueue<Triplet>pq=new PriorityQueue<>();
        pq.add(new Triplet(src,0,0));
        int cost[]=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        while(pq.size()>0){
            Triplet top=pq.remove();
            int node=top.node;
            int costcurr=top.cost;
            int stop=top.stop;
            // if(node==dst) return cost[node];
            if(stop==k+1) continue;

            for(Pair ele:adj.get(node)){
                int totalcost=costcurr+ele.cost;
               if(totalcost < cost[ele.node] && stop <= k){
                    cost[ele.node]=totalcost;
                    pq.add(new Triplet(ele.node,totalcost,stop+1));
                }
            }
        }

    if(cost[dst]==Integer.MAX_VALUE) return -1;
    return cost[dst];
        
    }
}