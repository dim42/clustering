package ml.unsupervised.clustering;

import Jama.Matrix;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

import static ml.unsupervised.clustering.KMeansClustering.INPUT_FILE_NAME;

public class DataSetChart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Data set for clustering chart");
        final NumberAxis xAxis = new NumberAxis(-7, 7, 1);
        final NumberAxis yAxis = new NumberAxis(-7, 7, 1);
        final ScatterChart<Number, Number> sc = new ScatterChart<>(xAxis, yAxis);
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        sc.setTitle("Data set for clustering");

        KMeansClustering clustering = new KMeansClustering();
        Matrix dataSet = clustering.loadDataSet(INPUT_FILE_NAME);

        XYChart.Series<Number, Number> dataSetPoints = new XYChart.Series<>();
        dataSetPoints.setName("Data set points");
        for (int r = 0; r < dataSet.getRowDimension(); r++) {
            dataSetPoints.getData().add(new XYChart.Data<>(dataSet.get(r, 0), dataSet.get(r, 1)));
        }
        sc.getData().add(dataSetPoints);

        Scene scene = new Scene(sc, 900, 800);
        stage.setScene(scene);
        stage.show();
    }
}
