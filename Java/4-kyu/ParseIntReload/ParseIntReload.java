import java.util.*;

public class Solutions {
    public static long parseInt(String number){
        Map<String, Long> units = Map.of(
            "zero",0L,"one",1L,"two",2L,"three",3L,"four",4L,
            "five",5L,"six",6L,"seven",7L,"eight",8L,"nine",9L
        );
        Map<String, Long> teens = Map.of(
            "ten",10L,"eleven",11L,"twelve",12L,"thirteen",13L,"fourteen",14L,
            "fifteen",15L,"sixteen",16L,"seventeen",17L,"eighteen",18L,"nineteen",19L
        );
        Map<String, Long> tens = Map.of(
            "twenty",20L,"thirty",30L,"forty",40L,"fifty",50L,"sixty",60L,
            "seventy",70L,"eighty",80L,"ninety",90L
        );

        long result=0, current=0;
        String[] tokens = number.split("[ -]");
        for (String t: tokens){
            if (t.isBlank() || t.equals("and")) continue;
            if (units.containsKey(t)) current += units.get(t);
            else if (teens.containsKey(t)) current += teens.get(t);
            else if (tens.containsKey(t)) current += tens.get(t);
            else if (t.equals("hundred")){
                if (current==0) current=1;
                current *= 100;
            } else if (t.equals("thousand")){
                if (current==0) current=1;
                current *= 1000; result += current; current=0;
            } else if (t.equals("million")){
                if (current==0) current=1;
                current *= 1000000; result += current; current=0;
            }
        }
        result += current;
        return result;
    }

    public static void main(String[] args){
        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
    }
}
