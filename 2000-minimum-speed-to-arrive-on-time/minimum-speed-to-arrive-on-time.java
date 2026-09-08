class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length - 1){
            return -1;
        }
        int s = 1;
        int e = 10_000_000;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(canArrive(dist, mid, hour)){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return s;  
    }

    private boolean canArrive(int[] dist, int speed, double hour){
        double time = 0;

        for(int i = 0; i < dist.length - 1; i++){
            time += Math.ceil((double) dist[i]/speed);
        }

        time += (double) dist[dist.length - 1] / speed;
        return time <= hour;
    }
}