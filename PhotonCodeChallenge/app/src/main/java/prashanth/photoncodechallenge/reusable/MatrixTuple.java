package prashanth.photoncodechallenge.reusable;

/**
 * Created by Prashanth on 3/19/2017.
 */

public class MatrixTuple {
    private final int posX;
    private final int posY;

    public MatrixTuple(int x, int y) {
        this.posX = x;
        this.posY = y;
    }


    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object obj) {
        MatrixTuple obj1 = (MatrixTuple) obj;
        return this.posX == obj1.getPosX() && this.posY == obj1.getPosY();
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", posX, posY);
    }
}
