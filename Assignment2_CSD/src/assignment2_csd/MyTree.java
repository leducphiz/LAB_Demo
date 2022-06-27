package assignment2_csd;

public class MyTree {

    Node root;

    public MyTree() {
    }

    public MyTree(Node root) {
        this.root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(String id, String xName, double xRating) {
        if (isEmpty()) {
            root = new Node(id, xName, xRating);
            return;
        }

        if (xName.endsWith("er") || xRating == 1) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (id.compareToIgnoreCase(root.info.id) > 0) {
                root.right = new Node(id, xName, xRating);
            } else {
                root.left = new Node(id, xName, xRating);
            }
            return;
        }

        Node trace = root;
        Node par = null;

        while (trace != null) {
            if (id.compareToIgnoreCase(trace.info.id) == 0) {
                return;
            }
            par = trace;
            if (id.compareToIgnoreCase(trace.info.id) > 0) {
                trace = trace.right;
            } else {
                trace = trace.left;
            }
        }

        if (id.compareToIgnoreCase(par.info.id) > 0) {
            par.right = new Node(id, xName, xRating);
        } else {
            par.left = new Node(id, xName, xRating);
        }
    }

    int level(Node p) {
        Node trace = root;
        int lev = 1;
        while (trace != p) {
            lev++;
            if (p.info.id.compareToIgnoreCase(trace.info.id) > 0) {
                trace = trace.right;
            } else {
                trace = trace.left;
            }
        }
        return lev;
    }

    void traverse() {
        MyQueue q = new MyQueue();
        q.enqueue(root);
        printPostorder(root);
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        if (node.info.rating >= avg()) {
            System.out.println(node.info.toString() + " | " + level(node));
        }
    }

    private double sumRating(Node p) {
        if (p == null) {
            return 0;
        }
        return sumRating(p.left) + sumRating(p.right) + p.info.rating;
    }

    private int countNode(Node p) {
        if (p == null) {
            return 0;
        }
        return countNode(p.left) + countNode(p.right) + 1;
    }

    private double avg() {
        return sumRating(root) / countNode(root);
    }

    void delete() {
        inOrderdelete(root);
    }
    int count = 0;

    private void inOrderdelete(Node p) {
        if (p == null) {
            return;
        }

        inOrderdelete(p.left);
        if (p.info.rating >= 3) {
            count++;
            if (count == 2) {
                System.out.println(p.info.toString());
                if (parent(p) != null) {
                    dele(parent(p));
                }
                return;
            }
        }
        inOrderdelete(p.right);
    }

    Node parent(Node ch) {
        if (ch == root || ch == null) {
            return null;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.id.equals(ch.info.id)) {
                break;
            }
            parent = p;
            if (p.info.id.compareTo(ch.info.id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return parent;
    }

    void dele(Node x) {
        // tim node chua x, phan loai truong hop node chua x
        if (isEmpty()) {
            return;
        }
        Node p = root;
        Node parent = null;
        while (p != null) {
            if (p.info.id.equals(x.info.id)) {
                break;
            }
            parent = p;
            if (p.info.id.compareTo(x.info.id) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            if (parent == null) {
                root = null;
                return;
            }
            if (parent.left == p) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        if ((p.left != null && p.right == null) || (p.left == null && p.right != null)) {
            if (p == root) {
                if (p.left != null) {
                    root = p.left;
                } else {
                    root = p.right;
                }
                return;
            }
            if (parent.left == p) {
                if (p.left != null) {
                    parent.left = p.left;
                } else {
                    parent.left = p.right;
                }
            } else {
                if (p.left != null) {
                    parent.right = p.left;
                } else {
                    parent.right = p.right;
                }
            }
        }
        if (p.left != null && p.right != null) {
            Node rm = p.left;
            Node parentRM = null;
            while (rm.right != null) {
                parentRM = rm;
                rm = rm.right;
            }
            p.info = rm.info;
            if (parentRM == null) {
                p.left = rm.left;
            } else {
                parentRM.right = rm.left;
            }
        }
    }

    Node lastRight;

    void nodeLastHaveRight(Node p) {
        if (p == null) {
            return;
        }
        if (p.right != null) {
            lastRight = p;
        }
        nodeLastHaveRight(p.left);
        nodeLastHaveRight(p.right);
    }

    public void preOrderRotate(Node p) {
        if (p == null) {
            return;
        }
        if (p != root) {
            nodeLastHaveRight(root);
            if (p.info.id.equalsIgnoreCase(lastRight.info.id)) {
                rotateLeft(p);
            }
        }
        System.out.println(p.info.toString());
        preOrderRotate(p.left);
        preOrderRotate(p.right);
    }

    void rotateLeft() {
        preOrderRotate(root);
    }

    void rotateLeft(Node par) {
        if (par == null || par.right == null) {
            return;
        }
        Node ch = par.right;
        par.right = ch.left;
        ch.left = par;
        if (parent(par) == null) {
            root = ch;
            return;
        }
        if (parent(par).left == par) {
            parent(par).left = ch;
        } else {
            parent(par).right = ch;
        }
    }

}
