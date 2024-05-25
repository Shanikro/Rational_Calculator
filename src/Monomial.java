public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial (int exponent, Scalar coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m){
        if(this.exponent != m.exponent)
            return null;
        return (new Monomial(this.exponent,this.coefficient.add(m.coefficient)));
    }

    public Monomial mul(Monomial m){
        return new Monomial(this.exponent + m.exponent,this.coefficient.mul(m.coefficient));
    }

    public Scalar evaluate(Scalar s){
        return s.power(this.exponent).mul(this.coefficient);
    }

    public Monomial derivative(){
        return new Monomial(this.exponent - 1, this.coefficient.mul(new IntegerScalar(this.exponent)));
    }

    public int sign(){
        return this.coefficient.sign();
    }

    public boolean equals(Object o){
        if(! (o instanceof Monomial))
            return false;
        Monomial other = (Monomial) o;
        return (this.exponent == other.exponent && this.coefficient.equals(other.coefficient));
    }

    public String toString(){
        if (this.exponent == 0)
            return this.coefficient.toString();
        if (this.)
    }

}
