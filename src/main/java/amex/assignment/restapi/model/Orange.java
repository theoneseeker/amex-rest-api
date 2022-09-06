package amex.assignment.restapi.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Orange extends Item{

    private final float cost = 0.25f;

    public Orange(String name, int quantity) {
        super(name, quantity);
    }

    @Override
    public float calcCost() {
        if (this.getQuantity() <= 0) return 0f;
        BigDecimal bdCost = new BigDecimal(String.valueOf(cost));
        BigDecimal bdSum = new BigDecimal("0.00");
        float totalSum = 0;
        for (int i = 1; i < this.getQuantity() + 1; i++){
            if(i % 3 == 0);
            else bdSum = bdSum.add(bdCost);
        }
        return bdSum.setScale(2, RoundingMode.UNNECESSARY).floatValue();
    }
}
