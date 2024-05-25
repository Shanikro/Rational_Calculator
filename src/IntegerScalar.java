public class IntegerScalar implements Scalar {

    private int number;

    public IntegerScalar(int num) {
        this.number = num;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    public Scalar addInteger(IntegerScalar s) {
        return new IntegerScalar(this.number + s.number);
    }

    public Scalar addRational(RationalScalar s) {
        int newN = this.number * s.getDenominator() + s.getNumerator();
        return new RationalScalar(newN, s.getDenominator());
    }

    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    public Scalar mulRational(RationalScalar s) {
        return new RationalScalar(this.number * s.getNumerator(), s.getDenominator());
    }

    public Scalar mulInteger(IntegerScalar s) {
        return new IntegerScalar(this.number * s.number);
    }

    public Scalar neg() {
        return new IntegerScalar(this.number * (-1));

    }

    public Scalar power(int exponent) {
        Scalar ans = new IntegerScalar(this.number);
        while (exponent > 1) {
            ans = ans.mul(this);
            exponent = exponent - 1;
        }
        return ans;
    }

    public int sign() {
        if (number == 0)
            return 0;
        else if (number > 0)
            return 1;
        return -1;
    }

    public boolean equals(Object o) {
        if (!(o instanceof IntegerScalar))
            return false;
        else {
            IntegerScalar o1 = (IntegerScalar) o;
            return (this.number == o1.number);
        }
    }

    public String toString() {
        return "" + number;

    }

    public int get() {
        return this.number;
    }


//   public static void main(String[] args) {
//        IntegerScalar rs1 = new IntegerScalar(2);
//        RationalScalar rs2 = new RationalScalar(-5,10);
////        IntegerScalar rs3 = new IntegerScalar(2);
//       System.out.println(rs1.mul(rs2));
//        System.out.println(rs1.add(rs2));
////        System.out.println(rs1.power(2));
////        System.out.println(rs1.neg());
////        System.out.println(rs1.sign());
////        System.out.println(rs1.equals(rs2));
////        System.out.println(rs1.equals(rs3));
//    }
}
