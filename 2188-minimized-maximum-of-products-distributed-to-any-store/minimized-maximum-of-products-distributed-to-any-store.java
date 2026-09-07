class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int s = 1;
        int e = 0;

        for (int quantity : quantities){
            e = Math.max(e, quantity);
        }

        while (s <= e) {
            int mid = s + (e - s)/2;

            if (isPossible(quantities, n, mid)){
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    private boolean isPossible(int[] quantities, int n, int maxProducts){

        int stores = 0;

        for (int quantity : quantities){
            stores += (quantity + maxProducts - 1) / maxProducts;

            if (stores > n){
                return false;
            }
        }
        return true;  
    }
}