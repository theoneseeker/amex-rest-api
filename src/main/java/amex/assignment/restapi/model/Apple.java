package amex.assignment.restapi.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Apple extends Item {

    private final float cost = 0.60f;

    public Apple(String name, int quantity) {
        super(name, quantity);
    }

    @Override
    public float calcCost() { // too large payload requests can be thrown to API or handled in API.
        if (this.getQuantity() <= 0) return 0f;
        BigDecimal bdCost = new BigDecimal(String.valueOf(cost));
        BigDecimal bdSum = new BigDecimal("0.00");
        for(int i = 1; i < this.getQuantity() + 1; i++){
            if(i % 2 == 0);
            else bdSum = bdSum.add(bdCost);
        }
        return bdSum.setScale(2, RoundingMode.UP).floatValue();
    }
}
