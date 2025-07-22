// TC : O(N) -- Total number of days
// SC : O(N) -- Total number of days

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& cost) {
        int n = days.size();
        vector<int> dp(n, 0);
        for (int i = 0; i < n; ++i) {
            //    one day
            int option1 = cost[0] + (i > 0 ? dp[i - 1] : 0);
            //  7 days
            int j = i;
            while (j > -1 && days[i] - days[j] < 7)
                j--;
            int option2 = cost[1] + (j >= 0 ? dp[j] : 0);
            //  30 days
            j = i;
            while (j > -1 && days[i] - days[j] < 30)
                j--;
            int option3 = cost[2] + (j >= 0 ? dp[j] : 0);
            dp[i] = min({option1, option2, option3});
        }
        return dp[n - 1];
    }
};
