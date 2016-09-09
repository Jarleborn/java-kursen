package asign1;

/**
 * Created by hampus on 2016-09-09.
 */
public class Fraction {

    private int _num;
    private int _den;

    public Fraction(int num, int den){
        _num = num;

       if(den != 0){
           _den = den;
       }else{
           throw new IllegalArgumentException("Denominator is zero");
       }

    }

    public boolean isNegative(){
        if (this.getNum() / this.getDen() < 0){
            return true;
        }
        return false;
    }

    public int getNum() {
        return _num;
    }

    public int getDen() {
        return _den;
    }

    public Fraction add(Fraction frac){
        if(frac.getDen() != this.getDen()){

            int newDen = frac.getDen() * this.getDen();
            int newNum = frac.getNum() * this.getNum() + this.getNum() * frac.getNum();
            return new Fraction(newNum, newDen);
        }

        return new Fraction(frac.getNum() + this.getNum(), this.getDen());
    }

    public Fraction subtract(Fraction frac){
        if(frac.getDen() != this.getDen()){

            int newDen = frac.getDen() * this.getDen();
            int newNum = frac.getNum() * this.getNum() - this.getNum() * frac.getNum();
            return new Fraction(newNum, newDen);
        }

        return new Fraction(frac.getNum() - this.getNum(), this.getDen());
    }

    public Fraction multiply(Fraction frac){
        return new Fraction(frac.getNum() * this.getNum(), frac.getDen() * this.getDen());
    }

    public Fraction divide(Fraction frac){
        return new Fraction(this.getDen() * frac.getNum() , this.getNum() * frac.getDen());
    }

    public boolean isEqualTo(Fraction frac){
        return this.getNum() * frac.getDen() == this.getNum() * frac.getNum();
    }

    public String toString(){
        return this.getNum() + "/" + this.getDen();
    }

}
