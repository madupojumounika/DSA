class Solution {
    public boolean isPerfectSquare(int num) {
        int s = 1;
        int e = num;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(mid == num/mid && num % mid == 0){
                return true;
            }else if(mid > num/mid){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return false;
    }
}