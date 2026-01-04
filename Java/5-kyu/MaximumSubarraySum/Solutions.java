public class Solutions {
    public static int maxSequence(int[] array){
        int maxSoFar=0, maxEndingHere=0;
        for (int v: array){
            maxEndingHere += v;
            if (maxEndingHere < 0) maxEndingHere = 0;
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }
    public static void main(String[] args){
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum subarray sum: " + maxSequence(array));
    }
}
