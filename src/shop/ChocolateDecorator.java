package shop;

public class ChocolateDecorator extends CoffeeDecorator {
    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chocolate Syrup";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75;
    }
}
