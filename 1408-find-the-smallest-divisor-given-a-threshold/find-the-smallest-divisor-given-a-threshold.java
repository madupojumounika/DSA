class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
       int s = 1;
       int e = 0;

       for(int num : nums){
        e = Math.max(num, e);
       }

       while(s < e){
        int mid = s + (e - s)/2;

        if(isPossible(nums, mid, threshold)){
            e = mid;
        }else{
            s = mid + 1;
        }

       }
       return s;
    }

    private boolean isPossible(int[] nums, int divisor, int threshold){
        int sum = 0;

        for(int num : nums){
            sum += (num + divisor - 1)/divisor;
        }
        return sum <= threshold;
    }
}