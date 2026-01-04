public class CountDivisorsNumberTest {
    public static void main(String[] args){
        int d = CountDivisorsNumber.divisors(36);
        if (d != 9) throw new RuntimeException("CountDivisorsNumber test failed: got="+d);
        if (CountDivisorsNumber.divisors(5) != 2) throw new RuntimeException("CountDivisorsNumber test failed for 5");
        System.out.println("CountDivisorsNumber: OK");
    }
}
