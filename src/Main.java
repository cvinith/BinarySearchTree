import com.binarysearchtree.BinarySearchTree;

public class Main {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.iterativeInsert(10);
    bst.iterativeInsert(5);
    bst.iterativeInsert(7);
    bst.iterativeInsert(12);
    bst.iterativeInsert(8);
    System.out.println(bst.size());
  }
}