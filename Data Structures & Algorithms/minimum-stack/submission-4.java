class MinStack {
    public class Node{
        int val;
        int min;
        Node next;
        Node prev;
        public Node(int v, Node n, Node p){
            val = v;
            min = val;
            next = n;
            prev = p;
        }
    }
    private Node end;
    public MinStack() {
        end = null;
    }
    
    public void push(int val) {
        if(end == null){
            end = new Node(val,null,null);
        }
        else{
            end.next = new Node(val, null, null);
            end.next.prev = end;
            end = end.next;
            end.min = Math.min(end.prev.min, val);
        }
    }
    
    public void pop() {
        int val = end.val;
        end = end.prev;
        if(end!=null)
            end.next = null;
    }
    
    public int top() {
        return end.val;
    }
    
    public int getMin() {
        return end.min;
    }
}
