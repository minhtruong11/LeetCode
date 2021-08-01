class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = Arrays.stream(milestones).mapToLong(i -> i).sum();
        Long max = Arrays.stream(milestones).mapToLong(i -> i).max().orElse(0L);
        
        return (sum-max >= max) ? sum : 2L * (sum-max) + 1L;
    }
}

// class Solution {
//     public long numberOfWeeks(int[] weeks) {
//         long max = 0, sum = 0;
//         for (int week: weeks) {
//             max = Math.max(week, max);
//             sum += week;
//         }
		
//         return sum - max >= max ? sum : 2 * (sum - max) + 1;
//     }
// }