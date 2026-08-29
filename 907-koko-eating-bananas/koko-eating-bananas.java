class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s = 1;
        int e = 0;

        for(int pile : piles){
            e = Math.max(e, pile);
        }

        while(s < e){
            int mid = s + (e - s)/2;
            long hours = 0;

            for(int pile : piles){
                hours += (pile + mid - 1)/mid;
            }

            if(hours <= h){
                e = mid;
            }else{
                s = mid + 1;
            }
        }
        return s;
    }
}