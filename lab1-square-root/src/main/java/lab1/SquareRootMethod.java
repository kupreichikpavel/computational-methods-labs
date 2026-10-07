package lab1;

public final class SquareRootMethod {

  private SquareRootMethod() {
  }

  public static double[][] decompose(double[][] a) {
    int n = a.length;
    double[][] s = new double[n][n];

    for (int i = 0; i < n; i++) {
      double sumDiag = 0.0;
      for (int k = 0; k < i; k++) {
        sumDiag += s[k][i] * s[k][i];
      }
      double diag = a[i][i] - sumDiag;
      if (diag <= 0) {
        throw new ArithmeticException(
            "Матрица не положительно определена: s[" + (i + 1) + "][" + (i + 1) + "]^2 = " + diag);
      }
      s[i][i] = Math.sqrt(diag);

      for (int j = i + 1; j < n; j++) {
        double sumOff = 0.0;
        for (int k = 0; k < i; k++) {
          sumOff += s[k][i] * s[k][j];
        }
        s[i][j] = (a[i][j] - sumOff) / s[i][i];
      }
    }
    return s;
  }

  public static double[] forward(double[][] s, double[] b) {
    int n = b.length;
    double[] y = new double[n];
    for (int i = 0; i < n; i++) {
      double sum = 0.0;
      for (int k = 0; k < i; k++) {
        sum += s[k][i] * y[k];
      }
      y[i] = (b[i] - sum) / s[i][i];
    }
    return y;
  }

  public static double[] backward(double[][] s, double[] y) {
    int n = y.length;
    double[] x = new double[n];
    for (int i = n - 1; i >= 0; i--) {
      double sum = 0.0;
      for (int k = i + 1; k < n; k++) {
        sum += s[i][k] * x[k];
      }
      x[i] = (y[i] - sum) / s[i][i];
    }
    return x;
  }

  public static double[] residual(double[][] a, double[] x, double[] b) {
    int n = b.length;
    double[] r = new double[n];
    for (int i = 0; i < n; i++) {
      double sum = 0.0;
      for (int j = 0; j < n; j++) {
        sum += a[i][j] * x[j];
      }
      r[i] = sum - b[i];
    }
    return r;
  }

  public static boolean isSymmetric(double[][] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      if (a[i].length != n) {
        return false;
      }
      for (int j = i + 1; j < n; j++) {
        if (a[i][j] != a[j][i]) {
          return false;
        }
      }
    }
    return true;
  }
}