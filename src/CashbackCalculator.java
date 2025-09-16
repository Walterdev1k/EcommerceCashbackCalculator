import java.util.Locale;
import java.util.Scanner;

public class CashbackCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);

        double productsValue = scan.nextDouble();
        scan.nextLine(); // consome o \n pendente
        String couponCode = scan.hasNextLine() ? scan.nextLine().trim() : "";

        double discount = 0.0;
        double cashback = 0.0;

        // Aplica desconto de 10% se o cupom for DESC10
        if ("DESC10".equalsIgnoreCase(couponCode)) {
            discount = productsValue * 0.10;
        }

        double discountedValue = productsValue - discount;

        // Aplica cashback de R$ 15 se valor com desconto for >= R$ 150
        if (discountedValue >= 150.00) {
            cashback = 15.0;
        }

        double finalValue = discountedValue - cashback;

        System.out.printf("Valor final: R$ %.2f | Cashback: R$ %.2f%n", finalValue, cashback);

        scan.close();
    }
}