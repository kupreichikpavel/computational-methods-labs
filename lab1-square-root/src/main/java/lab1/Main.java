package lab1;

import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    double[][] a = {
        {8, 0, -4, 0, -2},
        {0, 7, 0, -4, 0},
        {-4, 0, 6, 0, -1},
        {0, -4, 0, 5, 0},
        {-2, 0, -1, 0, 4}
    };
    double[] b = {-14, -2, 9, 12, 15};

    if (!SquareRootMethod.isSymmetric(a)) {
      throw new IllegalArgumentException("Матрица A должна быть квадратной и симметричной");
    }

    printMatrix(a, "Matrix A");
    printVector(b, "Vector b");

    double[][] s = SquareRootMethod.decompose(a);
    printMatrix(s, "Matrix S");

    double[] y = SquareRootMethod.forward(s, b);
    printVector(y, "Vector y");

    double[] x = SquareRootMethod.backward(s, y);
    printVector(x, "Vector x");

    double[] r = SquareRootMethod.residual(a, x, b);
    printVectorSci(r, "Residual r = Ax - b");
  }

  private static void printMatrix(double[][] m, String name) {
    System.out.println(name + ":");
    for (double[] row : m) {
      StringBuilder line = new StringBuilder();
      for (double v : row) {
        line.append(String.format(Locale.US, "%12.6f", v));
      }
      System.out.println(line);
    }
    System.out.println();
  }

  private static void printVector(double[] v, String name) {
    System.out.println(name + ":");
    for (int i = 0; i < v.length; i++) {
      System.out.println(String.format(Locale.US, "  %s[%d] = %14.6f", name, i + 1, v[i]));
    }
    System.out.println();
  }

  private static void printVectorSci(double[] v, String name) {
    System.out.println(name + ":");
    for (int i = 0; i < v.length; i++) {
      System.out.println(String.format(Locale.US, "  r[%d] = %14.6e", i + 1, v[i]));
    }
    System.out.println();
  }
}