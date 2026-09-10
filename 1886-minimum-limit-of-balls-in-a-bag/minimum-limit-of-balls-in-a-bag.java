class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int s = 1;
        int e = 0;

        for(int balls : nums){
            e = Math.max(e, balls);
        }

        while(s <= e){

            int mid = s + (e - s)/2;

            if(canMake(nums, maxOperations, mid)){
                e = mid - 1;       
            }else{
                s = mid + 1;    
            }
        }
        return s;
    }

    private boolean canMake(int[] nums, int maxOperations, int limit){

        int operations = 0;

        for(int balls : nums){

            operations += (balls - 1) / limit;
            if(operations > maxOperations){
                return false;
            }
        }
        return true;
    }
    
}