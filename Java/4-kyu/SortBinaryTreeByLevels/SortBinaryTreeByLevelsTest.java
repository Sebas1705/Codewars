import java.util.Arrays;

public class SortBinaryTreeByLevelsTest {
    public static void main(String[] args){
        Tree tree = new Tree(1);
        tree.left = new Tree(2); tree.left.left = new Tree(4); tree.left.right = new Tree(5);
        tree.right = new Tree(3); tree.right.left = new Tree(6); tree.right.right = new Tree(7); tree.right.right.left = new Tree(8);
        int[] r = SortBinaryTreeByLevels.treeByLevels(tree);
        int[] exp = {1,2,3,4,5,6,7,8};
        if (!Arrays.equals(r, exp)) throw new RuntimeException("SortBinaryTreeByLevels test failed");
        System.out.println("SortBinaryTreeByLevels: OK");
    }
}
