public interface Scalar {

    Scalar add(Scalar s);
    Scalar addRational(RationalScalar s);
    Scalar addInteger(IntegerScalar s);
    Scalar mul(Scalar s);
    Scalar mulInteger(IntegerScalar s);
    Scalar mulRational(RationalScalar s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    boolean equals(Object o);
    String toString();

}
