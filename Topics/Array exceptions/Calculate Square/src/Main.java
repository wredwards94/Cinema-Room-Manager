class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
       if (array == null || index > array.length - 1 || index < 0) {
           System.out.println("Exception!");
       } else {
           System.out.println(array[index] * array[index]);
       }
    }
}