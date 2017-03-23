package prashanth.photoncodechallenge;

import java.util.ArrayList;
import java.util.List;

import prashanth.photoncodechallenge.reusable.LeastMatrix;
import prashanth.photoncodechallenge.reusable.MatrixTuple;
import prashanth.photoncodechallenge.reusable.SmallestInteger;

/**
 * Created by Prashanth on 3/19/2017.
 */

public class ShortestPath {
    private final int maxValue;

    public ShortestPath() {
        this(Integer.MAX_VALUE);
    }

    public ShortestPath(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Find the best available path
     * @param leastMatrix input matrix
     * @return best path entry
     */
    public List<SmallestInteger> findPath(LeastMatrix leastMatrix) {
        List<SmallestInteger> bestPath = null;

        MatrixTuple matrixTuple;
        for (int i = 0; i < leastMatrix.getHeight(); i++) {
            matrixTuple=new MatrixTuple(1, i + 1);
            if(leastMatrix.getValue(matrixTuple)> maxValue) {
                continue;
            }
            List<SmallestInteger> currentPath = findPath(leastMatrix, matrixTuple, new ArrayList<SmallestInteger>());
            if (bestPath == null || sumPath(currentPath) < sumPath(bestPath)) {
                bestPath = currentPath;
            }
        }

        return bestPath;
    }

    // find the best path entry from UP/DOWN or RIGHT
    private List<SmallestInteger> findBestPath(List<SmallestInteger> up, List<SmallestInteger> right, List<SmallestInteger> down) {
        List<SmallestInteger> bestOfUpAndRight = bestOfTwo(up, right);
        return bestOfTwo(bestOfUpAndRight, down);
    }
    /**
     * Find the shortest path
     * @param leastMatrix input matrix
     * @param matrixTuple current cell
     * @param path list of paths
     * @return smallestInteger
     */
    private List<SmallestInteger> findPath(LeastMatrix leastMatrix, MatrixTuple matrixTuple, List<SmallestInteger> path) {
        if (matrixTuple == null) {
            return path;
        }

        List<SmallestInteger> currentPath = new ArrayList<>(path);
        int nextCost = leastMatrix.getValue(matrixTuple);

        if (sumPath(currentPath) + nextCost > maxValue || matrixTuple.getPosX() > leastMatrix.getWidth()) {
            return currentPath;
        }
        currentPath.add(new SmallestInteger(matrixTuple, nextCost));

        List<SmallestInteger> upRight = findPath(leastMatrix, leastMatrix.getAslantTop(matrixTuple), currentPath);
        List<SmallestInteger> straightRight = findPath(leastMatrix, leastMatrix.getNextSuccessive(matrixTuple), currentPath);
        List<SmallestInteger> downRight = findPath(leastMatrix, leastMatrix.getAslantBottom(matrixTuple), currentPath);

        return findBestPath(upRight, straightRight, downRight);
    }
    private List<SmallestInteger> bestOfTwo(List<SmallestInteger> p1, List<SmallestInteger> p2) {
        if (p1.size() == p2.size()) {
            if (sumPath(p1) < sumPath(p2)) {
                return p1;
            }
            return p2;
        }

        if (p1.size() > p2.size()) {
            return p1;
        }
        return p2;
    }

    private int sumPath(List<SmallestInteger> path) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i).getMInteger();
        }
        return sum;
    }

    public int getMaxCost() {
        return maxValue;
    }
}
