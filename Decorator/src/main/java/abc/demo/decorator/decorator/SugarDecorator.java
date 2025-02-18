package abc.demo.decorator.decorator;

import abc.demo.decorator.component.Beverage;

public class SugarDecorator implements Beverage {
    protected Beverage beverage;

    public SugarDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDesciprtion() {
        return beverage.getDesciprtion() + " and Sugar";
    }

    @Override
    public double cost() {
        return beverage.cost() + 50;
    }
}
