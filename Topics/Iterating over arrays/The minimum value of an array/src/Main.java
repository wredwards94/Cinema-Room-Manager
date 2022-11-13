import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int [] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        int minValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(minValue > nums[i]){
                minValue = nums[i];
                //System.out.println(nums[i]);
            }
        }
        System.out.println(minValue);
    }
}