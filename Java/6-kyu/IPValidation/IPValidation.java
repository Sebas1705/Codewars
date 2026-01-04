public class IPValidation {
    public static boolean isValidIp(String addr){
        if (addr==null) return false;
        if (addr.chars().anyMatch(Character::isWhitespace)) return false;
        String[] parts = addr.split("\\.");
        if (parts.length!=4) return false;
        for (String p: parts){
            if (p.isEmpty()) return false;
            if (p.length()>1 && p.startsWith("0")) return false;
            if (!p.matches("\\d+")) return false;
            int v;
            try { v = Integer.parseInt(p); } catch (NumberFormatException e) { return false; }
            if (v < 0 || v > 255) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String testIp = "192.0168.1.1";
        System.out.println(isValidIp(testIp)? testIp + " is a valid IP address." : testIp + " is not a valid IP address.");
    }
}
