package data;

import exceptions.ArgumentsNumberError;
import exceptions.NegativeNumbersError;

import java.math.BigDecimal;

public class Item {

    private double width;
    private double height;
    private double deep;
    private int weight;
    private BigDecimal price;

    private Item(double width, double height, double deep, int weight, BigDecimal price) {
        this.width = width;
        this.height = height;
        this.deep = deep;
        this.weight = weight;
        this.price = price;
    }

    public static Item of(String userInput) {
        String[] userInputArray = userInput.split(" ");
        if (userInputArray.length != 5) {
            throw new ArgumentsNumberError();
        }
        if (userInput.contains("-")) {
            throw new NegativeNumbersError();
        }
        double sizeA = Double.valueOf(userInputArray[0]);
        double sizeB = Double.valueOf(userInputArray[1]);
        double sizeC = Double.valueOf(userInputArray[2]);
        int weight = Integer.valueOf(userInputArray[3]);
        BigDecimal price = new BigDecimal(userInputArray[4]);
        return new Item(sizeA, sizeB, sizeC, weight, price);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDeep() {
        return deep;
    }

    public int getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
