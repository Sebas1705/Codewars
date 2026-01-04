public class Rot13 {
    public static String rot13(String src){
        StringBuilder sb = new StringBuilder();
        for (char c: src.toCharArray()){
            if (c>='a' && c<='z') sb.append((char)('a' + (c-'a'+13)%26));
            else if (c>='A' && c<='Z') sb.append((char)('A' + (c-'A'+13)%26));
            else sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String text = "Hello, World!";
        System.out.println("Original: " + text);
        System.out.println("Encoded: " + rot13(text));
    }
}
