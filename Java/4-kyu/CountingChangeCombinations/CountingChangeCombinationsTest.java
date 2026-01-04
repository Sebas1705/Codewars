public class CountingChangeCombinationsTest {
    public static void main(String[] args){
        int[] coins = {5,2,3};
        int res = CountingChangeCombinations.countChange(10, coins.length, coins);
        if (res != 4) throw new RuntimeException("CountingChangeCombinations test failed: got="+res);
        System.out.println("CountingChangeCombinations: OK");
    }
}
