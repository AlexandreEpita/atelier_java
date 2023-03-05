package fr.epita.assistants.forkjoin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(1)
public class RecursiveTaskTest {
    @Test
    void exampleTest() {
        // Create a Matrix
        double[][] matrix = new double[][]{
                new double[]{10, 52, 100, 50, 74},
        };
        double expected = 51.83;

        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);

        // Fork and join task
        mrt.fork();
        double got = mrt.join();

        // Need delta because of 'double' type
        assertEquals(expected, got, 0.01);
    }


    @Test
    void exampleTest2() {
        // Create a Matrix
        double[][] matrix = new double[10000][10000];
        for (int i = 0; i < 10000; i++)
        {
            for(int j = 0; j < 10000; j++)
                matrix[i][j] = 2;
;        }
        double expected = 2;

        MyRecursiveTask mrt = new MyRecursiveTask(matrix, 0, matrix[0].length, 0, matrix.length);

        // Fork and join task
        mrt.fork();
        double got = mrt.join();

        // Need delta because of 'double' type
        assertEquals(expected, got, 0.01);
    }
    // Write your tests here ...
}
