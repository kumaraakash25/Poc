public class FibonaciRecursion {

    public static void main(String[] args) {
        int result = recursion(10);
        System.out.println(result);
    }

    private static int recursion(int number) {
        if (number == 0 || number == 1) {
            return number;
        }
        return recursion(number - 1) + recursion(number - 2);
    }


}
