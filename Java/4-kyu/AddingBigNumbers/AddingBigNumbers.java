public class AddingBigNumbers {
    public static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int da = i >= 0 ? a.charAt(i--) - '0' : 0;
            int db = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = da + db + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(add("1","2"));
    }
}
