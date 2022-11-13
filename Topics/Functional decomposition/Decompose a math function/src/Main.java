import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        //call your implemented methods here.
        double result = 0;
        if (x <= 0) {
            result = f1(x);
        } else if (0 < x && x < 1) {
           result = f2(x);
        } else if (x >= 1) {
            result = f3(x);
        }
        return result;
    }

    //implement your methods here
    public static double f1(double x) {
        double result = 0;
        result = (x * x) + 1;
        return result;
    }

    public static double f2(double x) {
        double result = 0;
        result = 1 / (x * x);
        return result;
    }

    public static double f3(double x) {
        double result = 0;
        result = (x * x) - 1;
        return result;
    }
}