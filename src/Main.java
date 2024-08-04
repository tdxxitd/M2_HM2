import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount user1 = new BankAccount();
        user1.deposit(15000);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Сколько вы хотите снять?");
            int a = scanner.nextInt();
            try {
                user1.withDraw(a);
                System.out.println("Деньги успешно сняты. Оставшаяся сумма: " + user1.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("Оставшаяся сумма: " + e.getRemainingAmount());
                try {
                    user1.withDraw(e.getRemainingAmount());
                    System.out.println("Оставшаяся сумма снята. Ваш счет: " + user1.getAmount());
                } catch (LimitException ex) {
                    System.out.println("Ошибка. : " + ex.getMessage());
                }
                break;
            }
        }
    }
}