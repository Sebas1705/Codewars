public class CountIPAddressesTest {
    public static void main(String[] args){
        long v = CountIPAddresses.ipsBetween("20.0.0.10","20.0.1.0");
        if (v != 246L) throw new RuntimeException("CountIPAddresses test failed: got="+v);
        System.out.println("CountIPAddresses: OK");
    }
}
