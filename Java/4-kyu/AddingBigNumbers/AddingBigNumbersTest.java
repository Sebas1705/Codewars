public class AddingBigNumbersTest {
    public static void main(String[] args){
        if (!AddingBigNumbers.add("123","456").equals("579")) throw new RuntimeException("AddingBigNumbers test failed");
        if (!AddingBigNumbers.add("999","1").equals("1000")) throw new RuntimeException("AddingBigNumbers test failed");
        System.out.println("AddingBigNumbers: OK");
    }
}
