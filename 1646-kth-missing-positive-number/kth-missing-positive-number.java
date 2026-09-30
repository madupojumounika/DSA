class Solution {
    public int findKthPositive(int[] arr, int k) {
        int s = 0;
        int e = arr.length;

        while(s < e){
            int mid = s + (e - s)/2;

            int missing = arr[mid] - (mid + 1);

            if(missing >= k){
                e = mid;
            }else{
                s = mid + 1;
            }
        }
        return s + k;
    }
}