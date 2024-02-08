package cleanCoding.src.exercises;

public class Main {

    boolean canBuyBeer(int age, int money) {
        if (age >= 21 && money >= 20) {
            return true;
        }
        return false;
    }
}
