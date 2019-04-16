package ml.unsupervised.clustering;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PointsByClusters {
    private Map<Integer, List<double[]>> map = new LinkedHashMap<>();

    public Map<Integer, List<double[]>> getMap() {
        return map;
    }

    public void put(int clN, List<double[]> clusterPoints) {
        map.put(clN, clusterPoints);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("PointsByClusters:\n");
        for (Entry<Integer, List<double[]>> entry : map.entrySet()) {
            result.append("Cluster: ").append(entry.getKey()).append(", points: ");
            for (double[] point : entry.getValue()) {
                result.append("x=").append(point[0]).append(", y=").append(point[1]).append("; ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
