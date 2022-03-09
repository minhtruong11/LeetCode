class BrowserHistory {
    
    LinkedList<String> history;
    String homepage;
    
    public BrowserHistory(String homepage) {
        history = new LinkedList<>();
        history.addFirst(homepage);
        this.homepage = homepage;
    }
    
    public void visit(String url) {
        while (history.size() > 0 && history.getFirst() != homepage) {
            history.removeFirst();
        }
        history.addFirst(url);
        this.homepage = url;
    }
    
    public String back(int steps) {
        // System.out.println(history);
        // System.out.println(steps);
        // System.out.println(homepage);
        int idx = -1;
    
        for (String str : history) {
            idx++;
            if (str.equals(homepage)) {
                break;
            }
        }
        if (idx+steps < history.size()) {
            this.homepage = history.get(idx+steps);
        } else {
            this.homepage = history.getLast();
        }
        return this.homepage;
    }
    
    public String forward(int steps) {
        int idx = -1;
    
        for (String str : history) {
            idx++;
            if (str.equals(homepage)) {
                break;
            }
        }
        
        if (steps > idx) {
            this.homepage = history.getFirst();
        } else {
            this.homepage = history.get(idx-steps);
        }
        
        return this.homepage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */