public class HelpBookseller {
    public static String stockSummary(String[] books, String[] categories){
        if (books.length==0 || categories.length==0) return "";
        long[] counts = new long[categories.length];
        for (String b: books){
            if (b==null || b.isBlank()) continue;
            char cat = b.charAt(0);
            String[] parts = b.split(" ");
            long qty = 0;
            try{ qty = Long.parseLong(parts[parts.length-1]); } catch(Exception e){ continue; }
            for (int j=0;j<categories.length;j++) if (!categories[j].isEmpty() && categories[j].charAt(0)==cat) counts[j]+=qty;
        }
        StringBuilder sb = new StringBuilder();
        for (int j=0;j<categories.length;j++){
            if (j>0) sb.append(" - ");
            sb.append("(").append(categories[j].charAt(0)).append(" : ").append(counts[j]).append(")");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String[] books = {"ABART 20","CDXEF 50","BKWRK 25","BTSQZ 89","DRTYM 60"};
        String[] cats = {"A","B","C","D"};
        System.out.println(stockSummary(books,cats));
    }
}
