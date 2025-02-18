package abc.demo.decorator.component;

public class Espresso implements Beverage{
    @Override
    public String getDesciprtion() {
        return "Expresso Coffee";
    }

    @Override
    public double cost() {
        return 100;
    }
}
