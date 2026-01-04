public class IPValidationTest {
    public static void main(String[] args){
        if (!IPValidation.isValidIp("127.0.0.1")) throw new RuntimeException("IPValidation test failed: 127.0.0.1 should be valid");
        if (IPValidation.isValidIp("abc")) throw new RuntimeException("IPValidation test failed: abc should be invalid");
        System.out.println("IPValidation: OK");
    }
}
