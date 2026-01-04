public class Int32ToIPv4 {
    public static String uint32ToIp(long number){
        long b1 = (number >> 24) & 0xFF;
        long b2 = (number >> 16) & 0xFF;
        long b3 = (number >> 8) & 0xFF;
        long b4 = number & 0xFF;
        return b1+"."+b2+"."+b3+"."+b4;
    }
    public static void main(String[] args){
        System.out.println(uint32ToIp(2149583361L));
    }
}
