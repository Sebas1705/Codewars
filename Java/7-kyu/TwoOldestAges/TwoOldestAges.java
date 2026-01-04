public class TwoOldestAges {
    public static int[] twoOldestAges(int[] ages){
        if (ages.length < 2) return new int[0];
        int oldest = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int v: ages){
            if (v > oldest){ second = oldest; oldest = v; }
            else if (v > second) second = v;
        }
        return new int[]{second, oldest};
    }
    public static void main(String[] args){
        int[] ages = {22,42,18,42,7};
        int[] r = twoOldestAges(ages);
        System.out.println("Two oldest ages: " + r[0] + ", " + r[1]);
    }
}
