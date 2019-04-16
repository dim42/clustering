package ml.unsupervised.clustering;

import Jama.Matrix;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import static ml.unsupervised.clustering.KMeansClustering.INPUT_FILE_NAME;

public abstract class CommonChart extends Application {

    String title;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle(title);
        final NumberAxis xAxis = new NumberAxis(-7, 7, 1);
        final NumberAxis yAxis = new NumberAxis(-7, 7, 1);
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        final ScatterChart<Number, Number> sc = new ScatterChart<>(xAxis, yAxis);
        sc.setTitle("Clustering");

        KMeansClustering clustering = new KMeansClustering();
        Matrix dataSet = getDataSet(clustering);

        KMeansResult kMeans = getKMeans(clustering, dataSet);

        Matrix centroids = kMeans.getCentroids();
        XYChart.Series<Number, Number> centroidsPoints = new XYChart.Series<>();
        centroidsPoints.setName("Centroids");
        for (int r = 0; r < centroids.getRowDimension(); r++) {
            centroidsPoints.getData().add(new XYChart.Data<>(centroids.get(r, 0), centroids.get(r, 1)));
        }
        sc.getData().add(centroidsPoints);

        PointsByClusters pointsByClusters = clustering.pointsByClusters(dataSet, kMeans.getClusterAssment());
        for (Entry<Integer, List<double[]>> entry : pointsByClusters.getMap().entrySet()) {
            XYChart.Series<Number, Number> dataSetPoints = new XYChart.Series<>();
            dataSetPoints.setName("Cluster" + entry.getKey());
            if (entry.getValue().size() > 0) {
                for (double[] point : entry.getValue()) {
                    dataSetPoints.getData().add(new XYChart.Data<>(point[0], point[1]));
                }
                sc.getData().add(dataSetPoints);
            }
        }

        Scene scene = new Scene(sc, 900, 800);
        stage.setScene(scene);
        stage.show();
    }

    Matrix getDataSet(KMeansClustering clustering) throws IOException {
        return clustering.loadDataSet(getInputFileName());
    }

    String getInputFileName() {
        return INPUT_FILE_NAME;
    }

    abstract KMeansResult getKMeans(KMeansClustering clustering, Matrix dataSet);
}
