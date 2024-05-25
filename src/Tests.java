public class Tests {
    public static void main(String[] args) {
        RationalScalar rs1 = new RationalScalar(1, 2);
        RationalScalar rs2 = new RationalScalar(1, 3);
        System.out.println((RationalScalar) rs1.addRational(rs2));
    }
}
