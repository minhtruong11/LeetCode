class Solution {
    
    public int transform(int[] mapping, int n) {
        if (n==0) {
            return mapping[0];
        }
        
        List<Integer> digits = new ArrayList<>();
        
        while (n != 0) {
            int digit = n%10;
            digits.add(mapping[digit]);
            n /= 10;
        }
        
        int temp = 0;
        int power = digits.size()-1;
        
        for (int i=digits.size()-1; i>=0; i--) {
            temp += digits.get(i) * Math.pow(10, power--);
        }
        
        return temp;
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        Map<Integer, Integer> mp = new HashMap<>();
        Map<Integer, Integer> idxMap = new HashMap<>();
        Integer[] myArr = new Integer[nums.length];
        int i=0;
        
        for (int num : nums) {
            mp.put(num, transform(mapping, num));
            myArr[i++] = num;
            idxMap.put(num, i);
        }
        
        Arrays.sort(myArr, (a, b) -> {
            int tA = mp.get(a);
            int tB = mp.get(b);
            
            if (tA < tB)   return -1;
            if (tA == tB) {
                if (idxMap.get(a) < idxMap.get(b)) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 1;
        });
        
        for (i=0; i<nums.length; i++) {
            nums[i] = myArr[i];
        }
        
        // for (int key : mp.keySet()) {
        //     System.out.printf("%d %d\n", key, mp.get(key));
        // }
        
        return nums;
    }
}