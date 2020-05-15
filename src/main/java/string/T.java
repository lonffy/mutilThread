package string;

public class T {
    public static void main(String[] args) {
       /* String a = "1";
        String b = "2";
        String c = a+b;
        System.out.println(c);*/

       StringBuilder sb = new StringBuilder();
       sb.append("1").append("2");
       String c = sb.toString();
        System.out.println(c);

    }
}
