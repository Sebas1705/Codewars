public class TwoOldestAgesTest {
    public static void main(String[] args){
        int[] ages = {1,5,87,45,8,8};
        int[] r = TwoOldestAges.twoOldestAges(ages);
        if (r.length != 2 || r[0] != 45 || r[1] != 87) throw new RuntimeException("TwoOldestAges test failed");
        System.out.println("TwoOldestAges: OK");
    }
}
