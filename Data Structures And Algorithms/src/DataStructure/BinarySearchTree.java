package DataStructure;

public class BinarySearchTree { //time complexity is O(h) where h is height of BST
    class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
        }
    }

    private Node root;
    private int count = 0;

    BinarySearchTree(){
        root = null;
    }



    public void insert(int value) {
        root = insertValue(root, value);
        count++;
    }




    private Node insertValue(Node root, int value) {

        if(root == null) {
            root = new Node(value);
            return root;
        }

        if(root.data > value) {
            root.left = insertValue(root.left, value);
        } else if(root.data < value) {
            root.right = insertValue(root.right, value);
        }
        return root;
    }


    public int size() {
        return count;
    }


    public void printInOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }




    public void printPreOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if(root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }




    public void printPostOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }


    public void remove(int value) {
        root = removeValue(root, value);
        count--;
    }

    private Node removeValue(Node root, int value) {
        if(root == null) {
            throw new IllegalStateException();
        }

        if(root.data > value) {
            root.left = removeValue(root.left, value);
        } else if(root.data < value) {
            root.right = removeValue(root.right, value);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = removeValue(root.right, root.data);
        }
        return root;
    }



    private int minValue(Node root) {
        int min = root.data;
        if(root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }






    public int sum() {
        Node sum = new Node(0);
        sum.data = sumOfAllNodes(root);
        return sum.data;
    }

    private static int sumOfAllNodes(Node root) {
        if(root == null) {
            return 0;
        }
        return (root.data + sumOfAllNodes(root.left) + sumOfAllNodes(root.right));
    }






    public int largestElement() {
        Node max = new Node(Integer.MIN_VALUE);
        largestElementInTheTree(root, max);
        return max.data;
    }


    private Node largestElementInTheTree(Node root, Node max) {
        if(root != null) {
            if (root.data > max.data) {
                max.data = root.data;
            }
            largestElementInTheTree(root.left, max);
            largestElementInTheTree(root.right, max);
        }
        return max;
    }






    public int smallestElement() {
        Node min = new Node(Integer.MAX_VALUE);
        min.data = root.data;
        smallestElementInTheTree(root, min);
        return min.data;
    }


    private Node smallestElementInTheTree(Node root, Node min) {
        if(root != null) {
            if (root.data <= min.data) {
                min.data = root.data;
            }
            smallestElementInTheTree(root.left, min);
            smallestElementInTheTree(root.right, min);
        }
        return min;
    }






    public boolean contains(int data) {
        Node con = containsValue(root, data);
        if(con == null){
            return false;
        }
        return con.data == data;
    }


    private Node containsValue(Node root, int data) {
        if(root == null) {
            return null;
        }

        if(root.data == data) {
            return root;
        } else if(root.data > data) {
            root = containsValue(root.left,data);
        } else {
            root = containsValue(root.right, data);
        }
        return root;
    }


    public void printTwoChildren() {
        Node node = root;
        printTwoChildren(root);
    }

    private void printTwoChildren(Node node)
    {
        if(node == null) {
            return;
        }

        printTwoChildren(node.left);

        if(node.data % 3 == 0) {
            System.out.print(node.data + " ");
        }
        printTwoChildren(node.right);
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int z, x = 5, y = -10, a =4 ,b = 2;
        z= x++ - --y*b/a;
        System.out.println(z);
        tree.insert(10);
        tree.insert(11);
        tree.insert(20);
        tree.insert(14);
        tree.insert(7);
        tree.insert(8);
        tree.insert(6);
        tree.insert(1);
        tree.insert(22);
        tree.insert(9);

        System.out.println("---------------------");
        System.out.println(tree.size());
        System.out.println("---------------------");
        tree.printInOrder();
        System.out.println("---------------------");
        tree.printPreOrder();
        System.out.println("---------------------");
        tree.printPostOrder();
        System.out.println("---------------------");

        System.out.println(tree.sum());
        System.out.println("-----------------------");
        System.out.println(tree.largestElement());

        System.out.println("-----------------------");
        System.out.println(tree.smallestElement());
        System.out.println("-----------------------");
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(200));
        System.out.println(tree.contains(0));

    }
}