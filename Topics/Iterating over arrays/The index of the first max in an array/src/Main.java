import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] nums = new int[size];


        for (int i =0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        int max = nums[0];
        int index = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > max) {
                max = nums[j];
                index = j;
                break;
            }
        }
        System.out.println(index);
    }
}