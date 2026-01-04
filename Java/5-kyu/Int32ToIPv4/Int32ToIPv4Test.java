public class Int32ToIPv4Test {
    public static void main(String[] args){
        String ip = Int32ToIPv4.uint32ToIp(2149583361L);
        if (!"128.32.10.1".equals(ip)) throw new RuntimeException("Int32ToIPv4 test failed: got="+ip);
        System.out.println("Int32ToIPv4: OK");
    }
}
