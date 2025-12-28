class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int prefix[]=new int[n+1];
        for(int i=1;i<=n;i++){
            
            prefix[i]=prefix[i-1];
            if(customers.charAt(i-1)=='N') prefix[i]+=1;
        }
        int suffix[]=new int[n+1];
        for(int i=n-1;i>=0;i--){
            
            suffix[i]=suffix[i+1];
            if(customers.charAt(i)=='Y') suffix[i]+=1;
        }
        int penalty[]=new int[n+1];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            penalty[i]=suffix[i]+prefix[i];
            min=Math.min(min,penalty[i]);
        }
        
        for(int i=0;i<=n;i++){
            if(penalty[i]==min) return i;
            
            
        }
        return 9584903;
    }
}