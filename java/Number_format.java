// NumberFormat is a abstract class where the object is already created by default
// so you directly use it instead of creating a new instance


import java.text.NumberFormat;

public class Number_format {
    public static void main(String[] args) {
        
        // NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        // String formated_number = currencyFormat.format(29478027437.8973);
        String formated_number = NumberFormat.getCurrencyInstance().format(84348239.5324);

        System.out.println(formated_number);

// ----------------------------------------------------------------------------------------------------------
        NumberFormat percentNumber = NumberFormat.getPercentInstance();
        String number = percentNumber.format(0.2);
        // String number = NumberFormat.getPercentInstance().format(0.69);

        System.out.println(number);
    }
}
