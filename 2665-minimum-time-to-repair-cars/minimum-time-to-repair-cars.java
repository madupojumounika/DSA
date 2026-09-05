class Solution {
    public long repairCars(int[] ranks, int cars) {
        long s = 1;
        long e = (long) ranks[0] * cars * cars;

        int minRank = ranks[0];
        for(int rank : ranks){
            minRank = Math.min(minRank, rank);
        }

        e = (long) minRank * cars * cars;

        while(s < e){
            long mid = s + (e - s)/2;

            if(canRepair(ranks, mid, cars)){
                e = mid;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }

    private boolean canRepair(int[] ranks, long time, int cars){
        long sum = 0;

        for(int rank : ranks){
            long n = (long) Math.sqrt(time/rank);
            sum += n;
        }
        return sum >= cars;
    }
}