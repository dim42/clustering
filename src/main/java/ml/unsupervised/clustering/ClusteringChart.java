package ml.unsupervised.clustering;

import Jama.Matrix;

import static ml.unsupervised.clustering.KMeansClustering.CLUSTER_NUMBER;
import static ml.unsupervised.clustering.KMeansClustering.INPUT_FILE_NAME;

public class ClusteringChart extends CommonChart {

    public static void main(String[] args) {
        launch(args);
    }

    public ClusteringChart() {
        title = "k-means clustering";
    }

    String getInputFileName() {
        return INPUT_FILE_NAME;
    }

    KMeansResult getKMeans(KMeansClustering clustering, Matrix dataSet) {
        return clustering.kMeans(dataSet, CLUSTER_NUMBER);
    }
}
