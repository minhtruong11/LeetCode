class Solution {
    public List<List<Integer>> getAncestors(int vertices, int[][] edges) {
        
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Set<Integer>> ancestors = new HashMap<>();

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < vertices; i++) {
          inDegree.put(i, 0);
          graph.put(i, new ArrayList<Integer>());
          ancestors.put(i, new TreeSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
          int parent = edges[i][0], child = edges[i][1];
          graph.get(parent).add(child); 
          inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
          if (entry.getValue() == 0) {
            sources.add(entry.getKey());
          }
        }

        while (!sources.isEmpty()) {
          int vertex = sources.poll();
          List<Integer> children = graph.get(vertex);
          for (int child : children) {
            inDegree.put(child, inDegree.get(child) - 1);
            ancestors.get(child).add(vertex);
            ancestors.get(child).addAll(ancestors.get(vertex));
            if (inDegree.get(child) == 0)
              sources.add(child);
          }
        }
        
        for (int i=0; i<vertices; i++) {
            res.add(new ArrayList<>(ancestors.get(i)));
        }

        return res;
    }
}