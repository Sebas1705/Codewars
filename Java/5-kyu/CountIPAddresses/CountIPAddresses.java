public class CountIPAddresses {
    private static long parseIp(String ip){
        String[] p = ip.split("\\.");
        return (Long.parseLong(p[0]) << 24) + (Long.parseLong(p[1]) << 16) + (Long.parseLong(p[2]) << 8) + Long.parseLong(p[3]);
    }
    public static long ipsBetween(String start, String end){
        return parseIp(end) - parseIp(start);
    }
    public static void main(String[] args){
        System.out.println(ipsBetween("20.0.0.10","20.0.1.0"));
    }
}
