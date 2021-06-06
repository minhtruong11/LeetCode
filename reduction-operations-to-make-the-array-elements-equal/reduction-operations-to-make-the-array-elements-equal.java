import java.util.*;

class Solution {
    
    public static class Node {
        int val;
        int firstIdx;
        int lastIdx;
        int count;
        
        public Node(int val, int firstIdx, int secondIdx, int count) {
            this.val = val;
            this.firstIdx = firstIdx;
            this.lastIdx = lastIdx;
            this.count = count;
        }
    }
    
    
    public int reductionOperations(int[] arr1) {
        
        int n=arr1.length;
        Integer[] nums = new Integer[n];
        for(int i=0; i<n; i++) {
            nums[i] = arr1[i];
        }
        Arrays.sort(nums, Collections.reverseOrder());
        
        
        Map<Integer, Node> mp = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            if(!mp.containsKey(nums[i])) {
                list.add(nums[i]);
                mp.put(nums[i], new Node(nums[i], i, i, 1) );
            } else {
                mp.get(nums[i]).count++;
                mp.get(nums[i]).lastIdx = i;
            }
        }
        
        if(mp.size() == 1)  return 0;
        
        Arrays.sort(nums, Collections.reverseOrder());
        // Arrays.stream(nums).forEach(ele -> {System.out.printf("%d ", ele);});
        // System.out.println();
        
        int i=0;
        int steps=0;
        
        while(mp.size() != 1 && i<n-1) {
            steps += mp.get(list.get(i)).count;
            mp.get(list.get(i+1)).count += mp.get(list.get(i)).count;
            mp.get(list.get(i+1)).firstIdx = mp.get(list.get(i)).firstIdx;
            mp.remove(list.get(i));
            i++;
        }
        
        return steps;
        
    }
}