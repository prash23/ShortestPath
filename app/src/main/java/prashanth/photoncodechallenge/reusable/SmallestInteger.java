package prashanth.photoncodechallenge.reusable;

/**
 * Created by Prashanth on 3/19/2017.
 */

public class SmallestInteger {
    private final MatrixTuple mTuples;
    private final Integer mInteger;

    public MatrixTuple getMTuples() {
        return mTuples;
    }

    public Integer getMInteger() {
        return mInteger;
    }

    public SmallestInteger(MatrixTuple mTuples, Integer mInteger) {
        this.mTuples = mTuples;
        this.mInteger = mInteger;
    }

    @Override
    public boolean equals(Object o) {
        SmallestInteger o1 = (SmallestInteger) o;
        return o1.getMTuples().equals(this.getMTuples()) && o1.getMInteger().equals(this.getMInteger());
    }

    @Override
    public String toString() {
        return String.format("%s: %s", mTuples, mInteger);
    }
}
