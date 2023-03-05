package fr.epita.assistants.classics;

import java.util.Locale;

public class Classics {
    /**
     * Computes the factorial of n.
     *
     * @param n the nth value to compute, negative values should return -1
     * @return the long value of n!
     */
    public static long factorial(int n) {
        /* FIXME */
        if (n < 0)
            return -1;
        long res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        long T0 = 0;
        long T1 = 1;
        long T2 = 1;
        if (n == 0)
            return T0;
        if (n < 3)
            return T1;

        long tmp;
        while (n >= 3) {
            tmp = T0 + T1 + T2;
            T0 = T1;
            T1 = T2;
            T2 = tmp;
            n--;
        }
        return T2;
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        if (word == null || word.isEmpty())
            return true;
        String space_r = word.strip();
        String new_word = space_r.toLowerCase();
        int i = 0;
        int j = new_word.length() - 1;

        while (i < j) {
            while (i < j && new_word.charAt(i) == ' ')
                i++;
            while (i < j && new_word.charAt(j) == ' ')
                j--;
            if (new_word.charAt(i) != new_word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        int len = array.length;
        int current_ind;
        int tmp;
        for (int i = 1; i < len; ++i) {
            current_ind = i;
            while (current_ind > 0 && array[current_ind - 1] > array[current_ind]) {
                tmp = array[current_ind];
                array[current_ind] = array[current_ind - 1];
                array[current_ind - 1] = tmp;
                current_ind--;
            }
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        int a_len = a.length();
        int b_len = b.length();
        int i = 0;
        int j = 0;
        String res = new String("");
        while (i != a_len || j != b_len) {
            if (i != a_len) {
                res += a.charAt(i);
                i++;
            }
            if (j != b_len) {
                res += b.charAt(j);
                j++;
            }
        }
        return res;
    }
}
