class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int s = 1;
        int e = position[position.length - 1] - position[0];

        int ans = 0;
        while(s <= e){

            int mid = s + (e - s) / 2;

            if(canPlace(position, m, mid)){
                ans = mid;
                s = mid + 1;     
            }else{
                e = mid - 1;    
            }
        }
        return ans;      
    }
    private boolean canPlace(int[] position, int m, int minDist){

        int balls = 1;
        int lastPosition = position[0];

        for(int i = 1; i < position.length; i++){

            if(position[i] - lastPosition >= minDist){
                balls++;
                lastPosition = position[i];
            }
            
            if(balls >= m){
                return true;
            }
        }
        return false;
    }
}