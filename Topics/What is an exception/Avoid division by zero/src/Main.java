import java.util.Scanner;

class FixingArithmeticException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        String someString = null;
        int size = someString != null ? someString.length() : 0;

        try {
            int result = a / ((b + c) / d);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Division by zero!");
        }
    }
}