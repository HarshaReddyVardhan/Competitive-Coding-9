// TC : O(N) -- Total number of days
// SC : O(N) -- Total number of days

class Solution {
    int []memo;
    int n;
    public int mincostTickets(int[] days, int[] costs) {
        this.n = days.length;
        this.memo = new int[n];
        return helper(days, costs, 0);
    }

    private int helper(int[] days, int[] costs, int ind) {
        // base
        if(ind >= n) return 0;
        if(memo[ind] != 0) return memo[ind];
        // logic
        // for 1 day pass
        int choose1 = costs[0] + helper(days,costs,ind+1);
        // for 7 day pass
        int k = ind;
        while(k < n && days[k] < days[ind]+7){
            k++;
        }
        int choose2 = costs[1] + helper(days,costs,k);
        // for 30 day pass
        k = ind;
        while(k < n && days[k] < days[ind]+30){
            k++;
        }
        int choose3 = costs[2] + helper(days,costs,k);

        memo[ind] = Math.min(choose1, choose2>choose3 ? choose3 : choose2);
        return memo[ind];
        
    }
}
