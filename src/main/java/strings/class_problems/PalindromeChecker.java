package strings.class_problems;
import java.util.*;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int i = 0;
        int j = text.length() - 1;

        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return recursiveCheck(text, 0, text.length() - 1);
    }

    static boolean recursiveCheck(String text, int start, int end) {
        if (start >= end)
            return true;

        if (text.charAt(start) != text.charAt(end))
            return false;

        return recursiveCheck(text, start + 1, end - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        String reversed = new String(arr);

        return text.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean a = isPalindromeIterative(text);
        boolean b = isPalindromeRecursive(text);
        boolean c = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " + (a ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (b ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (c ? "Palindrome" : "Not Palindrome"));
    }
}