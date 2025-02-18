package abc.demo.decorator.decorator;

import abc.demo.decorator.component.Beverage;

public class MilkDecorator implements Beverage {
    protected Beverage beverage;

    public MilkDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDesciprtion() {
        return beverage.getDesciprtion() + " and Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 40;
    }
}
