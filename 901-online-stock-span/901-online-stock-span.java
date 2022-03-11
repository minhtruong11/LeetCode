class StockSpanner {
    
    Deque<Integer> stack;
    List<Integer> prices;
    
    public StockSpanner() {
        stack = new ArrayDeque<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        if (prices.isEmpty()) {
            prices.add(price);
            return 1;
        } else {
            prices.add(price);
            return findSpan();
        }
    }
    
    private int findSpan() {
        int count = 1, currPrice = prices.get(prices.size()-1);
        int i = prices.size() - 2;
        
        while (i>= 0 && prices.get(i) <= currPrice) {
            count++;
            i--;
        }
        
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */