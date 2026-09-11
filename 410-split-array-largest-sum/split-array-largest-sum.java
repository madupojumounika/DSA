class Solution {
    public int splitArray(int[] nums, int k) {
        int s = 0;
        int e = 0;

        for(int num : nums){
            s = Math.max(s, num);   
            e += num;                
        }

        while(s <= e){
            int mid = s + (e - s)/2;

            if(canSplit(nums, k, mid)){
                e = mid - 1;   
            }else{
                s = mid + 1;  
            }
        }
        return s;
    }

    private boolean canSplit(int[] nums, int k, int maxSum){
        int count = 1;  
        int sum = 0;
        for(int num : nums){
            sum += num;

            if(sum > maxSum){
                count++;       
                sum = num;    
            }

            if(count > k){
                return false;
            }
        }
        return true;    
    }
}