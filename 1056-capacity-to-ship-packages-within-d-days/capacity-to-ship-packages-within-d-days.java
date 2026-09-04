class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = 0;
        int e = 0;

        for(int weight : weights){
            s = Math.max(weight, s);
            e += weight;
        }

        while(s < e){
            int mid = s + (e - s)/2;

            if(canShip(weights, mid, days)){
                e = mid;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }

    private boolean canShip(int[] weights, int capacity, int days){
        int totalDays = 1;
        int currentWeight = 0;

        for(int weight : weights){
            if(currentWeight + weight > capacity){
                totalDays++;
                currentWeight = weight;
            }else{
                currentWeight += weight;
            }
        }
        return totalDays <= days;
    }
}