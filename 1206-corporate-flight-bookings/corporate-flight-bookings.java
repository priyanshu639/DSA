class Solution {
    // OPTIMAL APPPROACH TC IS O(N+M)
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[]=new int[n];
        for(int i=0;i<bookings.length;i++){
            int first=bookings[i][0];
            int last=bookings[i][1];
            int seats=bookings[i][2];
            ans[first-1]+=seats;
            if(last<n)ans[last]-=seats;
           
        }

        for(int j=1;j<ans.length;j++){
            ans[j]+=ans[j-1];

        }
        return ans;
    }
}