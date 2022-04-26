class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // All courses are independent
        if (prerequisites.length == 0)
            return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        // Map to store the indegree of every node
        HashMap<Integer,Integer> indegree = new HashMap<>();
        
        for (int i=0; i<numCourses; i++)
        {
            graph.put(i,new ArrayList<>());
            indegree.put(i,0);
        }
        
        for (int i=0; i<prerequisites.length; i++)
        {
            List<Integer> prereqs = graph.get(prerequisites[i][1]);
            prereqs.add(prerequisites[i][0]);
            
            int count = indegree.get(prerequisites[i][0]);
            indegree.put(prerequisites[i][0], count+1);
        }
        
        // Queue to store nodes with 0 indegree
        Queue<Integer> q = new LinkedList<>();
        
        for(int key : indegree.keySet()) {
            if(indegree.get(key) == 0) {
                q.add(key);
            }
        }
        
        while(!q.isEmpty()) {
            int course = q.remove();
            numCourses--;
            
            List<Integer> prereqs = graph.get(course);
            
            for(int prereq : prereqs) {
                int count = indegree.get(prereq);
                if(count > 0) {
                    if(count == 1) {
                        q.add(prereq);
                    }
                    count--;
                }
                indegree.put(prereq, count);
            }
        }
        
        return !(numCourses > 0);
    }
}