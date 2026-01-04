public class CountDivisorsNumber {
    public static int divisors(long n){
        int count = 0;
        long limit = (long)Math.sqrt(n);
        for (long i=1;i<=limit;i++){
            if (n % i == 0){ count++; if (i != n/i) count++; }
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println("Number of divisors of 36 is " + divisors(36));
    }
}
