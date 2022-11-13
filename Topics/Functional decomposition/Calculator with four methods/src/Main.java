class SimpleCalculator {

    // Implement your methods here
    public static void subtractTwoNumbers(long num1, long num2){
        long result = 0;
        result = num1 - num2;
        System.out.println(result);
    }

    public static void sumTwoNumbers(long num1, long num2){
        long result = 0;
        result = num1 + num2;
        System.out.println(result);
    }

    public static void divideTwoNumbers(long num1, long num2){
        long result = 0;
        if(num1 != 0 && num2 !=0){
            result = num1 / num2;
            System.out.println(result);
        }else {
            System.out.println("Division by 0!");
        }
    }

    public static void multiplyTwoNumbers(long num1, long num2){
        long result = 0;
        result = num1 * num2;
        System.out.println(result);
    }

    // Implemented method
    public static void power(long n, long p) {
        long number = n;
        long power = p;
        long result = 1;
        while (power > 0) {
            if (power % 2 != 0) {
                result *= number;
            }
            power /= 2;
            number *= number;
        }
        System.out.println(result);
    }
}

public class Main {

    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();

        switch (operator) {
            case "^":
                SimpleCalculator.power(num1, num2);
                break;
            case "+":
                SimpleCalculator.sumTwoNumbers(num1, num2);
                break;
            case "-":
                SimpleCalculator.subtractTwoNumbers(num1, num2);
                break;
            case "/":
                SimpleCalculator.divideTwoNumbers(num1, num2);
                break;
            case "*":
                SimpleCalculator.multiplyTwoNumbers(num1, num2);
                break;
            default:
                break;
        }
    }
}