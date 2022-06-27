    
package assignment2_csd;


public class Node {
    Song info;
    Node left, right;

    public Node() {
    }

    public Node(String id, String name, double rating) {
        this.info = new Song(id, name, rating);
        this.left = null;
        this.right = null;
    }
}
