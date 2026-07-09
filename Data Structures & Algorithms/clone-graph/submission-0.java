/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public HashMap<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        Node newGraph = new Node();
        newGraph.val = node.val;

        visited.put(node,newGraph);
        for(Node nextNode: node.neighbors){
            if(visited.containsKey(nextNode)){
                newGraph.neighbors.add(visited.get(nextNode));
                continue;
            }
            Node newNextNode = cloneGraph(nextNode);
            newGraph.neighbors.add(newNextNode);
        }

        return newGraph;
    }
}