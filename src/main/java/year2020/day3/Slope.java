package year2020.day3;

import java.util.Arrays;
import java.util.List;

public class Slope {

    private final String rawTreeMap;

    public Slope(String rawTreeMap) {
        this.rawTreeMap = rawTreeMap;
    }

    public long calculateTrees(int rightMoves, int downMoves){
        List<String> treeMap = Arrays.asList(rawTreeMap.split("\n"));
        int xIndex = rightMoves;
        int yIndex = downMoves;
        long numberOfTrees = 0;

        while(yIndex < treeMap.size()) {
            if(treeMap.get(yIndex).charAt(xIndex) == '#') {
                numberOfTrees++;
            }

            xIndex = (xIndex + rightMoves) % treeMap.get(0).length();
            yIndex = yIndex + downMoves;
        }

        return numberOfTrees;
    }

    public long calculateRiskFactor(List<List<Integer>> movements) {
        return  movements.stream()
            .map(movement -> calculateTrees(movement.get(0), movement.get(1)))
            .reduce(1L, (a, b) -> a * b);
    }
}
