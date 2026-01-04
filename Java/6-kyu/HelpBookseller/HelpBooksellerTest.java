public class HelpBooksellerTest {
    public static void main(String[] args){
        String[] books = {"ABART 20","CDXEF 50","BKWRK 25","BTSQZ 89","DRTYM 60"};
        String[] cats = {"A","B","C","D"};
        String res = HelpBookseller.stockSummary(books,cats);
        if (res == null || res.isEmpty()) throw new RuntimeException("HelpBookseller test failed: got empty");
        System.out.println("HelpBookseller: OK");
    }
}
