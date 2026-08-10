class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];

            int temp = sum - k;

            if(map.containsKey(temp)){
                count += map.get(temp);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
        
    }
}