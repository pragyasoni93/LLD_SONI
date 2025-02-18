package abc.demo.decorator;

import abc.demo.decorator.component.Beverage;
import abc.demo.decorator.component.Espresso;
import abc.demo.decorator.decorator.MilkDecorator;
import abc.demo.decorator.decorator.SugarDecorator;

public class Client {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDesciprtion());

        beverage = new MilkDecorator(beverage);
        System.out.println(beverage.getDesciprtion());
        System.out.println(beverage.cost());

        beverage = new SugarDecorator(beverage);
        System.out.println(beverage.getDesciprtion());
        System.out.println(beverage.cost());
    }
}
