package prashanth.photoncodechallenge.reusable;

import android.util.Log;

import java.util.List;

/**
 * Created by Prashanth on 3/19/2017.
 */

public class LeastMatrix {
    private final List<List<Integer>> leastValueMatrix;

    public LeastMatrix(List<List<Integer>> leastValueMatrix) {
        this.leastValueMatrix = leastValueMatrix;
    }

    /**
     * Get successive cell
     * @param matrixTuple of Matrix Tuple
     * @return MatrixTuple
     */
    public MatrixTuple getNextSuccessive(MatrixTuple matrixTuple) {
        if (matrixTuple.getPosX() + 1 > leastValueMatrix.get(matrixTuple.getPosY() - 1).size())
            return null;
        return new MatrixTuple(matrixTuple.getPosX() + 1, matrixTuple.getPosY());
    }

    /**
     * Get Crosswise top cell
     * @param matrixTuple of Matrix Tuple
     * @return if right cell null return null otherwise diagonal cell
     */
    public MatrixTuple getAslantTop(MatrixTuple matrixTuple) {
        MatrixTuple right = getNextSuccessive(matrixTuple);
        if (right == null)
            return null;
        int y = matrixTuple.getPosY() - 1;
        return new MatrixTuple(right.getPosX(), y == 0 ? leastValueMatrix.size() : y);
    }


    /**
     * Get Crosswise down cell
     * @param matrixTuple of Matrix Tuple
     * @return if right cell null return null otherwise diagonal cell
     */
    public MatrixTuple getAslantBottom(MatrixTuple matrixTuple) {
        MatrixTuple right = getNextSuccessive(matrixTuple);
        if (right == null)
            return null;
        int y = matrixTuple.getPosY() + 1;
        return new MatrixTuple(right.getPosX(), y > leastValueMatrix.size() ? 1 : y);
    }


    public int getValue(MatrixTuple matrixTuple) {
        return leastValueMatrix.get(matrixTuple.getPosY() - 1).get(matrixTuple.getPosX() - 1);
    }

    public int getWidth() {
        return leastValueMatrix.get(0).size();
    }

    public int getHeight() {
        return leastValueMatrix.size();
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().isAssignableFrom(this.getClass())) {
            return false;
        }
        LeastMatrix o1 = (LeastMatrix) o;

        int i = 0;
        while (i < o1.leastValueMatrix.size()) {
            List<Integer> thisRow = this.leastValueMatrix.get(i);
            List<Integer> compareRow = o1.leastValueMatrix.get(i);

            for (int x = 0; x < compareRow.size(); x++) {
                if (thisRow.get(x) != compareRow.get(x)) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    /**
     * Created by Prashanth on 3/19/2017.
     */

    public static class Output {
        private final boolean finished;
        private final int costOfPath;
        private final List<Integer> integerList;

        public
        Output(boolean finished, int finalCost, List<Integer> finalPath) {
            this.finished = finished;
            this.costOfPath = finalCost;
            this.integerList = finalPath;
        }

        public boolean isFinished() {
            return finished;
        }

        public int getCostOfPath() {
            return costOfPath;
        }

        public List<Integer> getPathList() {
            return integerList;
        }
    }
}
