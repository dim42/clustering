package ml.unsupervised.clustering;

import Jama.Matrix;

public class BiClusteringChart extends CommonChart {

    private static final String INPUT_FILE_NAME = "clusteringTestSet-bisect.txt";
    private static final int CLUSTER_NUMBER = 3;

    public static void main(String[] args) {
        launch(args);
    }

    public BiClusteringChart() {
        title = "Bisecting k-means clustering";
    }

    String getInputFileName() {
        return INPUT_FILE_NAME;
    }

    KMeansResult getKMeans(KMeansClustering clustering, Matrix dataSet) {
        return clustering.biKmeans(dataSet, CLUSTER_NUMBER);
    }
}
