class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.bt(n, 0, 0, '', res)
        return res
    
    def bt(self, n, openB, closeB, expr, res):
        if len(expr) == 2*n:
            res.append(expr)

        if openB < n:
            expr += '('
            self.bt(n, openB+1, closeB, expr, res)
            expr = expr[0:-1]

        if closeB < openB:
            expr += ')'
            self.bt(n, openB, closeB+1, expr, res)
            expr = expr[0:-1]
		
    