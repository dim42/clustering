package ml.unsupervised.clustering;

import Jama.Matrix;

public class BiClusteringChartForRandomPoints extends CommonChart {

    private static final int CLUSTER_NUMBER = 5;
    private static final int POINTS_NUMBER = 80;
    private static final int RANGE_FROM_ZERO = 6;

    public static void main(String[] args) {
        launch(args);
    }

    public BiClusteringChartForRandomPoints() {
        title = "Bisecting k-means clustering for random points";
    }

    Matrix getDataSet(KMeansClustering clustering) {
        return generateRandomPoints();
    }

    private Matrix generateRandomPoints() {
        Matrix dataSet = new Matrix(POINTS_NUMBER, 2);
        for (int r = 0; r < dataSet.getRowDimension(); r++) {
            for (int c = 0; c < dataSet.getColumnDimension(); c++) {
                dataSet.set(r, c, (Math.random() * 2 - 1) * RANGE_FROM_ZERO);
            }
        }
        return dataSet;
    }

    KMeansResult getKMeans(KMeansClustering clustering, Matrix dataSet) {
        return clustering.biKmeans(dataSet, CLUSTER_NUMBER);
    }
}
