import java.math.BigDecimal;
import java.math.RoundingMode;
class Solution {
    private static double roundDouble(double d, int places) {
 
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
    
    public static int dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] d = new int[6];
        d[0] = dist(p1, p2);
        d[1] = dist(p1, p3);
        d[2] = dist(p1, p4);
        d[3] = dist(p2, p3);
        d[4] = dist(p2, p4);
        d[5] = dist(p3, p4);
        
        Set<Integer> side = new HashSet<>();
        
        for(int i=0; i<6; i++) {
            if(d[i] == 0)   return false;
            side.add(d[i]);
        }
        
        return side.size() == 2;
    }
}