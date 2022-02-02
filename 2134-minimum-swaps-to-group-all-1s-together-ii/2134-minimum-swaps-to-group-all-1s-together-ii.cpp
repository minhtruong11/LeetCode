class Solution {
public:
    int minSwaps(vector<int>& nums) {
          int n=nums.size();
          int count1=0;
          for(int i=0;i<n;i++)
            if(nums[i]==1)
              count1++;
          int sum=0;
          for(int i=0;i<count1;i++)
            sum+=nums[i];
          int ans=count1-sum;
          for(int i=count1;i<n;i++)
          {
            sum+=nums[i]-nums[i-count1];
            ans=min(ans,count1-sum);
          }
          for(int i=0;i<count1-1;i++){
            sum+=nums[i]-nums[n-count1+i];
            ans=min(ans,count1-sum);
          }
          return ans;
    }
};