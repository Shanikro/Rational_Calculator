public class RationalScalar implements Scalar {
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator) {
        if (denominator == 0)
            throw new RuntimeException("Illegal Number");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Scalar add(Scalar s) {

        return s.addRational(this);
    }

    public Scalar addRational(RationalScalar s) {
        int newN = this.numerator * s.denominator + this.denominator * s.numerator;
        int newD = this.denominator * s.denominator;

        return new RationalScalar(newN, newD);
    }

    public Scalar addInteger(IntegerScalar s) {
        int newN = this.denominator * s.get() + this.numerator;
        return new RationalScalar(newN, this.denominator);
    }

    public Scalar mul(Scalar s) {

        return s.mulRational(this);
    }

    public Scalar mulRational(RationalScalar s) {
        return new RationalScalar(this.numerator * s.getNumerator(), this.denominator * s.getDenominator());
    }

    public Scalar mulInteger(IntegerScalar s) {

        return new RationalScalar(this.numerator * s.get(), this.denominator);
    }

    public Scalar neg() {
        return new RationalScalar(this.numerator * (-1), this.denominator);
    }

    public Scalar power(int exponent) {
        Scalar ans = new RationalScalar(this.numerator, this.denominator);
        while (exponent > 1) {
            ans = ans.mul(this);
            exponent = exponent - 1;
        }
        return ans;
    }

    public int sign() {
        Scalar newN = new IntegerScalar(this.numerator);
        Scalar newD = new IntegerScalar(this.denominator);

        if (newN.sign() == 0)
            return 0;
        int sum = newN.sign() + newD.sign();
        if (sum == 0)
            return -1;
        return 1;
    }

    public RationalScalar reduce() {

        int min = Math.min(Math.abs(this.numerator), Math.abs(this.denominator));
        while (min > 1) {
            if (this.denominator % min == 0 && this.numerator % min == 0)
                return new RationalScalar(this.numerator / min, this.denominator / min);
            min--;
        }
        return new RationalScalar(this.numerator, this.denominator);
    }


    public boolean equals(Object o) {
        if (!(o instanceof RationalScalar))
            return false;

        RationalScalar o1 = (RationalScalar) o;
        return (this.numerator * o1.denominator == this.denominator * o1.numerator);
    }

    public String toString() {
        RationalScalar newNum = this.reduce();
        if (this.sign() == -1)
            return ("-" + Math.abs(newNum.numerator) + "/" + Math.abs(newNum.denominator));
        return (Math.abs(newNum.numerator) + "/" + Math.abs(newNum.denominator));
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
//    public static void main(String[] args) {
//        RationalScalar rs1 = new RationalScalar(-18, 12);
//        RationalScalar rs2 = new RationalScalar(1, 2);
//        RationalScalar rs3 = new RationalScalar(3, -2);
//        System.out.println(rs1.mul(rs2));
//        System.out.println(rs1.add(rs2));
//        System.out.println(rs1.power(2));
//        System.out.println(rs1.neg());
//        System.out.println(rs1.sign());
//        System.out.println(rs1.equals(rs2));
//        System.out.println(rs1.equals(rs3));
//        System.out.println(rs1.reduce());
//
//    }

}

