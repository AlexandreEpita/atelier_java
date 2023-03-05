package fr.epita.assistants.maths;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTests {
    @Test
    void nullMatrix()
    {
        Matrix m = new Matrix(null);
        assertTrue(m.getMatrix() == null);
    }
    @Test
    void normalMat()
    {
        int [][]tab = {{1},{2}};
        Matrix m = new Matrix(tab);
        assertTrue(m.getMatrix() == tab);
    }

    @Test
    void normal2Mat()
    {
        int [][]tab = {{1,2}};
        Matrix m = new Matrix(tab);
        assertTrue(m.getMatrix() == tab);
    }

    @Test
    void normal3Mat()
    {
        int [][]tab = {{1,2}, {1}};
        Matrix m = new Matrix(tab);
        assertNull(m.getMatrix());
    }
    @Test
    void notSameMat()
    {
        int [][]tab1 = {{1},{2}};
        int [][]tab2 = {{2}, {3}};
        Matrix m = new Matrix(tab1);
        assertTrue(m.getMatrix() != tab2);
    }

    @Test
    void notSameMat2()
    {
        int [][]tab1 = {{1, 2, 3},{4, 5, 6}, {7,8,9}};
        int [][]tab2 = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        Matrix m = new Matrix(tab1);
        Matrix m1 = new Matrix(tab2);
        assertTrue(m.equals(m1));
    }

    @Test
    void empty_tab()
    {
        int [][]tab1 = {};
        Matrix m = new Matrix((tab1));
        assertTrue(m.getMatrix() == tab1);
    }

    @Test
    void lenMat()
    {
        int [][]tab1 = {{1},{2}};
        int [][]tab2 = {{2}, {3}};
        Matrix m = new Matrix(tab1);
        assertTrue(m.getMatrix().length >= 0);
    }
    @Test
    void not_null()
    {
        int [][]tab1 = {{1, 2, 3}};
        Matrix m1 = new Matrix(tab1);
        assertTrue(m1 != null);
    }

    @Test
    void almost_same()
    {
        int [][]tab1 = {{1, 2, 3}};
        Matrix m1 = new Matrix(tab1);
        Matrix m2 = new Matrix(tab1);
        assertTrue(m1 == m2);
    }

    @Test
    void almost_same2()
    {
        int [][]tab1 = {{1, 2, 3}};
        Matrix m1 = new Matrix(tab1);
        Matrix m2 = new Matrix(tab1);
        assertTrue(m1.equals(m2));
    }

    @Test
    void Mat_elt_null()
    {
        int [][]tab1 = {null,null};
        Matrix m = new Matrix(tab1);
        tab1 = new int[][]{{1}, new int[]{0}};
        assertTrue(m.getMatrix() != tab1);
    }

    @Test
    void objMat1()
    {
        Matrix m = new Matrix(null);
        Object obj = new Matrix(null);
        assertTrue(m.equals(obj));
    }

    @Test
    void objMat2()
    {
        int [][]tab = {{1,2}};
        Matrix m = new Matrix(tab);
        Object obj = new Matrix(tab);
        assertTrue(m.equals(obj));
    }

    @Test
    void objMat3()
    {
        int [][]tab = {{1,2}, {2,3}};
        Matrix m = new Matrix(tab);
        Object obj = new Matrix(tab);
        assertTrue(m.equals(obj));
    }

    @Test
    void objMat_empty()
    {
        int [][]tab = {};
        Matrix m = new Matrix(tab);
        Matrix obj = new Matrix(tab);
        assertNotNull(m.equals(obj));
    }

    @Test
    void objMat_6()
    {
        int [][]tab = {{1}};
        Matrix m = new Matrix(tab);
        Matrix obj = new Matrix(tab);
        assertTrue(m.equals(obj));
    }
    @Test
    void objMat_7()
    {
        int [][]tab = {{1}};
        Matrix m = new Matrix(tab);;
        assertTrue(m.equals(m));
    }

    @Test
    void void_obj()
    {
        int [][]tab1 = {{1, 2, 3}};
        Matrix m = new Matrix(tab1);
        assertFalse(m.equals(null));
    }

    @Test
    void void_obj2()
    {
        int [][]tab1 = {{1, 2, 3}};
        int [][] tab2 = {};
        Matrix m = new Matrix(tab1);
        Matrix m2 = new Matrix(tab2);
        assertFalse(m.equals(m2));
    }
    @Test
    void objMat_8()
    {
        int [][]tab = {{1}};
        int [][]not_same = {{2}};
        Matrix m = new Matrix(tab);;
        Matrix obj = new Matrix((not_same));
        assertFalse(m.equals(obj));
    }

    @Test
    void type_test()
    {
        int [][]tab = {};
        Matrix m = new Matrix(tab);
        Object obj = new Matrix(null);
        assertFalse(m.equals(obj));
    }

    @Test
    void diff_ptr()
    {
        int [][]tab1 = {};
        int [][]tab2 = {};
        Matrix m = new Matrix(tab1);
        Object obj = new Matrix(tab2);
        assertTrue(m.equals(obj));
    }

    @Test
    void well()
    {
        int [][]tab = {{1,0}, {0,1}};
        Matrix m = new Matrix(tab);
        Matrix res = m.multiply(m);

        assertTrue(m.equals(res));
    }
    @Test
    void m1_test()
    {
        int [][]tab = {{1,0}, {0,1}};
        Matrix m = new Matrix(tab);
        Matrix res = m.multiply(m);
        assertTrue(res.getMatrix() == tab);
    }

    @Test
    void m2_test()
    {
        int [][]tab = {{1,1}, {1,1}};
        int [][] res = {{2,2},{2,2}};
        Matrix m = new Matrix(tab);
        Matrix m2 = m.multiply(m);
        assertTrue(res == m2.getMatrix());
    }
    @Test
    void dim_test()
    {
        int [][]tab1 = {{1,1}};
        int [][]tab2 = {{1},{1}};

        Matrix m1 = new Matrix(tab1);
        Matrix m2 = new Matrix(tab2);
        Matrix res = m1.multiply(m2);
        assertTrue(res.getMatrix().length == 1);
    }

    @Test
    void dim_test2()
    {
        int [][]tab1 = {{1,1,1}, {1,2,3}};
        int [][]tab2 = {{1},{1},{1}};

        Matrix m1 = new Matrix(tab1);
        Matrix m2 = new Matrix(tab2);
        Matrix res = m1.multiply(m2);
        assertTrue(res.getMatrix().length != 1);
    }

    @Test
    void dim_test3()
    {
        int [][]tab1 = {{1}};
        Matrix m1 = new Matrix(tab1);
        assertTrue(m1.getMatrix() == tab1);
    }

    @Test
    void multiply()
    {
        int [][]tab1 = {{1, 2, 3}, {4, 5, 6}};
        int [][] tab2 = {{7, 8}, {9, 10}, {11, 12}};
        Matrix m1 = new Matrix(tab1);
        Matrix m2 = new Matrix(tab2);
        Matrix res = m1.multiply(m2);
        int [][] res_m = {{58, 34}, {139,94}};
        assertTrue(res.getMatrix() == res_m);
    }
    @Test
    void multiply2()
    {
        int [][]tab1 = {{0, 0}, {0, 0}};
        int [][] tab2 = {{7, 8}, {9, 10}, {11, 12}};
        Matrix m1 = new Matrix(tab1);
        Matrix m2 = new Matrix(tab2);
        Matrix res = m1.multiply(m2);
        assertTrue(res.getMatrix() == tab1);
    }
}
