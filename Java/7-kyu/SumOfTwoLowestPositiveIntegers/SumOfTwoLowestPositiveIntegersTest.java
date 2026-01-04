public class SumOfTwoLowestPositiveIntegersTest {
    public static void main(String[] args){
        int[] arr = {19,5,42,2,77};
        long r = SumOfTwoLowestPositiveIntegers.sumTwoSmallestNumbers(arr);
        if (r != 7L) throw new RuntimeException("SumOfTwoLowestPositiveIntegers test failed: got="+r);
        System.out.println("SumOfTwoLowestPositiveIntegers: OK");
    }
}
