class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while (i < firstList.length && j < secondList.length) {
            if ((firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) ||
                (secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])) {
                int start = Math.max(firstList[i][0], secondList[j][0]);
                int end = Math.min(firstList[i][1], secondList[j][1]);
                res.add(new int[] { start, end });
            }
            
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else j++;
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}