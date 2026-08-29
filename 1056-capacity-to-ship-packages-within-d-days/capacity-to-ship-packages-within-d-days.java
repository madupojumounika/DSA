class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = 0;

        for(int weight : weights){
            s = Math.max(s, weight);
            e += weight;
        }

        while(s <= e){
            int mid = s + (e - s)/2;

            int requiredDays = 1;
            int currentWeight = 0;

            for(int weight : weights){

                if(currentWeight + weight > mid){
                    requiredDays++;
                    currentWeight = 0;
                }
                currentWeight += weight;
            }

            if(requiredDays <= days){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }
}