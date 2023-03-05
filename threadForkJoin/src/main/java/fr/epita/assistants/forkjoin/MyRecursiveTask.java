package fr.epita.assistants.forkjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Double> {

    final private double[][] matrix;
    final private int xLowerBound;
    final private int xUpperBound;
    final private int yLowerBound;
    final private int yUpperBound;

    public MyRecursiveTask(double[][] matrix, int xLowerBound, int xUpperBound, int yLowerBound, int yUpperBound) {
        this.matrix = matrix;
        this.xLowerBound = xLowerBound;
        this.xUpperBound = xUpperBound;
        this.yLowerBound = yLowerBound;
        this.yUpperBound = yUpperBound;
    }

    @Override
    protected Double compute() {

        int longueur = xUpperBound - xLowerBound;
        int largeur = yUpperBound - yLowerBound;

        if (largeur == 0 || longueur == 0)
            return 0.0;

        if (longueur <= 5 && largeur <= 5)
        {
            double res = 0;
            for (int i = yLowerBound; i < yUpperBound; ++i)
            {
                for (int j = xLowerBound; j <xUpperBound ; ++j)
                {
                    res += this.matrix[i][j];
                }
            }
            return res / (largeur * longueur);
        }

        int inc_long = longueur / 2;
        int inc_larg = largeur / 2;

        int reste_long = longueur % 2;
        int reste_larg = largeur % 2;

        MyRecursiveTask [] mrt = new MyRecursiveTask[4];
        int xlow = xLowerBound;
        int y_low = yLowerBound;


        mrt[0] = new MyRecursiveTask(matrix, xlow, xlow + inc_long, y_low, y_low + inc_larg);
        mrt[0].fork();

        mrt[1] = new MyRecursiveTask(matrix, xlow + inc_long, xlow + (inc_long * 2) + reste_long, y_low, y_low + inc_larg);
        mrt[1].fork();

        mrt[2] = new MyRecursiveTask(matrix, xlow, xlow + inc_long, y_low + inc_larg, y_low + (inc_larg * 2) + reste_larg);
        mrt[2].fork();

        mrt[3] = new MyRecursiveTask(matrix, xlow + inc_long, xlow + (inc_long * 2) + reste_long, y_low + inc_larg, y_low + (inc_larg * 2) + reste_larg);
        mrt[3].fork();

        double sum = 0;
        for (int j = 0; j < 4; j++)
        {
            sum += mrt[j].join();
        }
        return sum / (double)4;
    }
}
