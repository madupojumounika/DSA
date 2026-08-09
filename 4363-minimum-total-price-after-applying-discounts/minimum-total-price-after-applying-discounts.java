class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = prices.length - 1;
        int j = discounts.length - 1;
        double totalPrice = 0;

        while(i >= 0 && j >= 0){
            double finalPrice = (prices[i] * (100.0 - discounts[j])) / 100.0;
            totalPrice += finalPrice;
            i--;
            j--;
        }

        while(i >= 0) {
            totalPrice += prices[i];
            i--;
        }
        return totalPrice;
        
    }
}