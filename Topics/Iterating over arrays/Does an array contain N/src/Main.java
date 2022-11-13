import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int read = 0;
        boolean res = false;
        read = scanner.nextInt();
        //scanner.nextLine();
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] == read){
                res = true;
                break;
            }else {
                res = false;
            }
        }
        System.out.println(res);
    }
}