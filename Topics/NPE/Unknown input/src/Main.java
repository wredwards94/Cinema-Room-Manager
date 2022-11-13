class Util {
    // correct this method to avoid NPE
    public static void printLength(String name) {
        int size = 0;
        System.out.println(size = name != null ? name.length() : 0);
    }
}