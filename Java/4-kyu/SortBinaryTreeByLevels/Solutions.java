import java.util.*;

class Tree { int value; Tree left, right; Tree(int v){value=v;} }

public class Solutions {
    public static int[] treeByLevels(Tree tree){
        if (tree==null) return new int[0];
        Deque<Tree> q = new ArrayDeque<>();
        q.add(tree);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            Tree n = q.removeFirst();
            res.add(n.value);
            if (n.left!=null) q.addLast(n.left);
            if (n.right!=null) q.addLast(n.right);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void printTree(Tree t){ if (t==null) return; System.out.print(t.value+" "); printTree(t.left); printTree(t.right); }

    public static void main(String[] args){
        Tree tree = new Tree(1);
        tree.left = new Tree(2); tree.left.left = new Tree(4); tree.left.right = new Tree(5);
        tree.right = new Tree(3); tree.right.left = new Tree(6); tree.right.right = new Tree(7); tree.right.right.left = new Tree(8);
        printTree(tree); System.out.println();
        int[] r = treeByLevels(tree);
        System.out.println(Arrays.toString(r));
    }
}
