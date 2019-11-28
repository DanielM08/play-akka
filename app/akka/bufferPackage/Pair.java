package akka.bufferPackage;

import java.util.Objects;

public final class Pair<A, B> {
    private final A a;
    private final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Returns a pair whose elements are the first and second
     * arguments, respectively.
     * @return a pair constructed from the arguments
     */
    public static <C, D> Pair<C, D> valueOf(C c, D d) {
        // Don't mandate new values.
        return new Pair<C, D>(c, d);
    }

    /**
     * Returns the value of the first element of the pair.
     * @return the value of the first element of the pair
     */
    public A getFirst() {
        return a;
    }

    /**
     * Returns the value of the second element of the pair.
     * @return the value of the second element of the pair
     */
    public B getSecond() {
        return b;
    }

    /**
     * TBD
     */
    @Override
    public String toString() {
        return "[" + Objects.toString(a) + ", " + Objects.toString(b) + "]";
    }

    /**
     * TBD
     */
    @Override
    public boolean equals(Object x) {
        if (!(x instanceof Pair))
            return false;
        else {
            Pair<?,?> that = (Pair<?,?>) x;
            return
                    Objects.equals(this.a, that.a) &&
                            Objects.equals(this.b, that.b);
        }
    }

    /**
     * TBD
     */
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
