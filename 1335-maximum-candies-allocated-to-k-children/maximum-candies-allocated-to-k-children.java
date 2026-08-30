class Solution {
    public int maximumCandies(int[] candies, long k) {
        int s = 1;
        int e = 0;

        for(int candy : candies){
            e = Math.max(e, candy);
        }

        int ans = 0;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(canDistribute(candies, k, mid)){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }

    private boolean canDistribute(int[] candies, long k, int amount) {

        long children = 0;

        for(int candy : candies){
            children += candy/amount;

            if(children >= k){
                return true;
            }
        }
        return false;
    }
}