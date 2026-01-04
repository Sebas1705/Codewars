public class FindTheUniqueNumberTest {
    public static void main(String[] args){
        float[] arr = {1f,1f,1f,2f,1f};
        float v = FindTheUniqueNumber.findUniq(arr);
        if (v != 2.0f) throw new RuntimeException("FindTheUniqueNumber test failed: got="+v);
        System.out.println("FindTheUniqueNumber: OK");
    }
}
