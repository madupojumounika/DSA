class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        long req = (long) m * k;

        if(req > bloomDay.length){
            return -1;
        }

        int s = 1;
        int e = 0;

        for(int bloom : bloomDay){
            e = Math.max(e, bloom);
        }

        while(s <= e){
            int mid = s + (e - s)/2;

            if(canMake(bloomDay, mid, m, k)){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return s;   
    }

    private boolean canMake(int[] bloomDay, int day, int m, int k){
        int bouquets = 0;
        int flowers = 0;

        for(int bloom : bloomDay){
            if(bloom <= day){
                flowers++;

                if(flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            }else{
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}