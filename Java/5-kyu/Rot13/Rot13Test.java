public class Rot13Test {
    public static void main(String[] args){
        String s = "Test";
        String r = Rot13.rot13(s);
        if (!"Grfg".equals(r)) throw new RuntimeException("Rot13 test failed: got="+r);
        System.out.println("Rot13: OK");
    }
}
