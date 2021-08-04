package data;

import java.math.BigDecimal;
import java.util.*;

public enum MaxDimensions {
    A(new Double[]{80d, 380d, 640d}, new BigDecimal("12.99")),
    B(new Double[]{190d, 380d, 640d}, new BigDecimal("13.99")),
    C(new Double[]{410d, 380d, 640d}, new BigDecimal("15.49"));

    private Double[] MAX_DIMENSIONS;
    public final static int MAX_WEIGHT = 25;
    private BigDecimal price;

    MaxDimensions(Double[] MAX_DIMENSIONS, BigDecimal price) {
        Arrays.sort(MAX_DIMENSIONS);
        this.MAX_DIMENSIONS = MAX_DIMENSIONS;
        this.price = price;
    }

    public Double[] getMAX_DIMENSIONS() {
        return MAX_DIMENSIONS;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
