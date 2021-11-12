class Solution:
    
    def __init__(self):
        self.memo = {}
    
    def tribonacci(self, n: int) -> int:
        if n in self.memo:
            return self.memo[n]
        if n == 0 or n == 1:
            return n
        elif n == 2:
            return 1
        else:
            self.memo[n] = self.tribonacci(n-1) + self.tribonacci(n-2) + self.tribonacci(n-3) 
            return self.memo[n]