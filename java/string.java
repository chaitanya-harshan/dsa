package java;
public class string {
    public static void main(String[] args) {
        String message = "  Hello Guys!!";
        System.out.println(message);

        System.out.println( message.startsWith("Hl") );
        // .endsWith
        // .toLowerCase()
        // .trim()
        // .indexOf()
        // .replace( , )
        System.out.println("Replace:- \n"+message.replace("!!", "**"));
        System.out.println("Trim:- \n"+message.trim());
    }
}

