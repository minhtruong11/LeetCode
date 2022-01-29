class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        int count = 0, minCost = 0;
        Arrays.sort(cost);
        while(count < n) {
          count++;
          if(count%3 == 0) {
            continue;
          }
          minCost += cost[n-count];
        }
        return minCost;
    }
}