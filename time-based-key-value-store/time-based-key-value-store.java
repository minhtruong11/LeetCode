class TimeMap {

    class Node {
        int timestamp;
        String value;
        
        public Node(int t, String v) {
            timestamp = t;
            value = v;
        }
    }
    
    Map<String, List<Node>> mp;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)) {
            mp.put(key, new ArrayList<Node>());
        }
        
        mp.get(key).add(new Node(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key) || mp.get(key).size() == 0) {
            return "";
        }
        
        List<Node> list = mp.get(key);
        
        int idx = bSearch(list, timestamp);
        
        if(idx == -1) {
            return "";
        } else {
            return list.get(idx).value;
        }
    }
    
    private int bSearch(List<Node> list, int val) {
        int n = list.size();
        int left = 0;
        int right = n-1;
        int ans=-1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid).timestamp <= val) {
                ans = mid;
                left = mid+1;
            } else {
                right = mid-1; 
            }
        }
        
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */