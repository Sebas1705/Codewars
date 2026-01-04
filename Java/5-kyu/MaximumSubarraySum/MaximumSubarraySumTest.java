public class MaximumSubarraySumTest {
    public static void main(String[] args){
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int r = MaximumSubarraySum.maxSequence(array);
        if (r != 6) throw new RuntimeException("MaximumSubarraySum test failed: got="+r);
        System.out.println("MaximumSubarraySum: OK");
    }
}
