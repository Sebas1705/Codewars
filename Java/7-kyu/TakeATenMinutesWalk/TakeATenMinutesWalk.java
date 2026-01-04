public class TakeATenMinutesWalk {
    public static boolean isValidWalk(String walk){
        if (walk.length() != 10) return false;
        int x=0,y=0;
        for (char c: walk.toCharArray()){
            switch(c){
                case 'n': y++; break;
                case 's': y--; break;
                case 'e': x++; break;
                case 'w': x--; break;
                default: return false;
            }
        }
        return x==0 && y==0;
    }
    public static void main(String[] args){
        System.out.println(isValidWalk("nsnsnsnsns")?"Valid walk":"Invalid walk");
    }
}
