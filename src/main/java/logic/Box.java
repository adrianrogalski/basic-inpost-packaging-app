package logic;

import data.Item;
import data.MaxDimensions;
import exceptions.DimensionValueExceededError;
import exceptions.WeightExceededError;
import java.math.BigDecimal;
import java.util.*;


public abstract class Box {
    public static String putItem(Item item) {

        if (item.getWeight() > MaxDimensions.MAX_WEIGHT) {
            throw new WeightExceededError();
        }
        for (MaxDimensions maxDimension: MaxDimensions.values()) {
            boolean match = false;
            Double[] itemDimensions =  {item.getWidth(), item.getHeight(), item.getDeep()};
            Arrays.sort(itemDimensions);
            for (int i = 0; i < itemDimensions.length; i++) {
                if (itemDimensions[i] > maxDimension.getMAX_DIMENSIONS()[i]) {
                    match = false;
                    break;
                }
                match = true;
            }
            if (match) {
                BigDecimal price = maxDimension.getPrice().add(item.getPrice());
                return "Paczka typu: " + maxDimension.name() + ", " + "koszt: " + price.toString();
            }
        }
        throw new DimensionValueExceededError();
    }

}
