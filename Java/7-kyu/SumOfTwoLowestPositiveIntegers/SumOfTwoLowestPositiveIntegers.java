public class SumOfTwoLowestPositiveIntegers {
    public static long sumTwoSmallestNumbers(int[] numbers){
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int v: numbers){
            if (v < min1){ min2 = min1; min1 = v; }
            else if (v < min2) min2 = v;
        }
        return (long)min1 + (long)min2;
    }
    public static void main(String[] args){
        int[] arr = {2000000000,2000000000,2000000000,2000000000,2000000000};
        System.out.println(sumTwoSmallestNumbers(arr));
    }
}
