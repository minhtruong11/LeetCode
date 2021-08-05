class Solution {
    public long minimumPerimeter(long neededApples) {
        long apples = 0;
        long l = 0;
        
        do {
            l+=2;
            apples = (l*(l+1)*(l+2))/2;
        } while(apples < neededApples);
        
        return 4*l;
    }
}