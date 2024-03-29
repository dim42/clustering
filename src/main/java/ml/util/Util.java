package ml.util;

import Jama.Matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Util {

    public static Matrix arrayToMatrix(double[] input, int rowDimension) {
        double[][] result = new double[rowDimension][input.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = input;
        }
        return new Matrix(result);
    }

    public static double[] toOneDimArray(List<Double> yVals) {
        double[] array = new double[yVals.size()];
        for (int j = 0; j < yVals.size(); j++) {
            array[j] = yVals.get(j);
        }
        return array;
    }

    public static double[][] toTwoDimArray(List<double[]> list) {
        double[][] array = new double[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static Matrix getColumn(Matrix matrix, int c) {
        return matrix.getMatrix(0, matrix.getRowDimension() - 1, c, c);
    }

    public static Matrix getRow(Matrix matrix, int r) {
        return matrix.getMatrix(r, r, 0, matrix.getColumnDimension() - 1);
    }

    public static double mean(double[] list) {
        double sum = 0;
        for (double val : list) {
            sum += val;
        }
        return sum / list.length;
    }

    public static double mean(List<Double> list) {
        double sum = 0;
        for (Double val : list) {
            sum += val;
        }
        return sum / list.size();
    }

    public static BufferedReader getReader(String fileName) {
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(Util.class.getClassLoader().getResourceAsStream(fileName))));
    }

    public static Integer[] argsort(final List<Double> a) {
        Integer[] indexes = new Integer[a.size()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingDouble(a::get));
        return indexes;
    }

    public static String matrixToString(Matrix matrix) {
        return Arrays.deepToString(matrix.getArray());
    }
}
