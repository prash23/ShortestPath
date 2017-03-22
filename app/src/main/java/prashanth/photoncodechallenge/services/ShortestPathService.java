package prashanth.photoncodechallenge.services;

import java.util.ArrayList;
import java.util.List;

import prashanth.photoncodechallenge.ShortestPath;
import prashanth.photoncodechallenge.reusable.LeastMatrix;
import prashanth.photoncodechallenge.reusable.SmallestInteger;

/**
 * Created by Prashanth on 3/19/2017.
 */

public class ShortestPathService {

    private final ShortestPath shortPath;

    public ShortestPathService(ShortestPath shortPath) {
        this.shortPath = shortPath;
    }

    /**
     * Calculate cost of path
     * @param leastMatrix input matrix
     * @return output Output
     */
    public LeastMatrix.Output compute(LeastMatrix leastMatrix) {
        List<SmallestInteger> integers = shortPath.findPath(leastMatrix);

        return new LeastMatrix.Output(integers.size() == leastMatrix.getWidth(), pathValue(integers), appendToRow(integers));
    }

    /**
     * Append the integer values in a row
     * @param smallestIntegers Smallest Integer
     * @return list of integer
     */
    private List<Integer> appendToRow(List<SmallestInteger> smallestIntegers) {
        List<Integer> valuesInARow = new ArrayList<>();
        for (int i = 0; i < smallestIntegers.size(); i++) {
            valuesInARow.add(smallestIntegers.get(i).getMTuples().getPosY());
        }
        return valuesInARow;
    }

    /**
     * Summation of the path
     * @param mInteger Smallest Integer
     * @return total path cost
     */
    private int pathValue(List<SmallestInteger> mInteger) {
        int value = 0;
        for (int i = 0; i < mInteger.size(); i++) {
            value += mInteger.get(i).getMInteger();
        }
        return value;
    }
}
