package co.edu.unaula.syanr4.recursion;

public class Recursion {

    double numberOne = 1.00;

    public double calculateFactorial(double number){

        if (number == numberOne){
            return number;
        }else{
            return number * calculateFactorial(number-1);
        }
    }

    public double calculatePotency(double number, int potency){
        if (potency == numberOne){
            return number;
        }else {
            return number * calculatePotency(number, potency-1 );
        }
    }
}
