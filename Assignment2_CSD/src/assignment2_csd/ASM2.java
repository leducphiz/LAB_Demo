package assignment2_csd;

public class ASM2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyTree BST = new MyTree();
        BST.insert("A6", "Mama mia", 4.0);
        BST.insert("A2", "Panama", 3.4);
        BST.insert("A1", "Paradise", 4.5);
        BST.insert("A5", "Tomorrow we fight", 4.5);
        BST.insert("A4", "Hello", 3.9);
        BST.insert("A3", "Colors of the wind", 4.0);
        BST.insert("B8", "Summer in Paris", 5.0);
        BST.insert("A7", "In a Persian Market", 4.5);
        BST.insert("A9", "Love in Paris", 3.8);
        BST.insert("A9", "Sang pour sang", 4.8);

        BST.traverse();
        System.out.println("-----------");
        //BST.delete();
        System.out.println("-----------");
        BST.rotateLeft();

    }

}
