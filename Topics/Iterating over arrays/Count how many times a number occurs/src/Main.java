import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        //int size = scanner.nextInt();
        int[] nums = new int[scanner.nextInt()];

        for (int i = 0; i < nums.length ; i++) {
            nums[i] = scanner.nextInt();
        }

        int repeat = scanner.nextInt();
        int count = 0;
        for (int n: nums) {
            if (n == repeat){
                count++;
            }
        }

        System.out.println(count);
    }
}