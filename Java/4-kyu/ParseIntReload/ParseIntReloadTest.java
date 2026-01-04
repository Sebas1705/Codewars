public class ParseIntReloadTest {
    public static void main(String[] args){
        long v = ParseIntReload.parseInt("seven hundred eighty-three thousand nine hundred and nineteen");
        if (v != 783919L) throw new RuntimeException("ParseIntReload test failed: got="+v);
        System.out.println("ParseIntReload: OK");
    }
}
