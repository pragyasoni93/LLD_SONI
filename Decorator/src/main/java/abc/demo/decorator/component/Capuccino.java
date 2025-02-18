package abc.demo.decorator.component;

public class Capuccino implements Beverage{
    @Override
    public String getDesciprtion() {
        return "Capuccino Coffee";
    }

    @Override
    public double cost() {
        return 150;
    }
}
