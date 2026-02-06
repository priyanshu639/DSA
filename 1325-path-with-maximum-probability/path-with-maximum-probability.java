class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        double prob;
        Pair(int node,double prob){
            this.node=node;
            this.prob=prob;
        }
        public int compareTo(Pair other){
            return Double.compare(this.prob, other.prob);

        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // convert into adjacency list
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<succProb.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double prob=succProb[i];
            adj.get(u).add(new Pair(v,prob));
            adj.get(v).add(new Pair(u,prob));
        }
        
        // now apply dijisktra algo
        PriorityQueue<Pair>pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start_node,1));
        double cost[]=new double[n];
        Arrays.fill(cost,Integer.MIN_VALUE);
        // 1 because going from start node to start node have the probabilty of one
        cost[start_node]=1.0;

        while(pq.size()>0){
            Pair top=pq.remove();
            for(Pair ele:adj.get(top.node)){
                double totalprob=top.prob*ele.prob;
                if(totalprob>cost[ele.node]){
                    cost[ele.node]=totalprob;
                    pq.add(new Pair(ele.node,totalprob));
                }
            }
        }
        if(cost[end_node]==Integer.MIN_VALUE) return 0;
        else return cost[end_node];
        

    }
}   