package library.tool;

import library.domain.entity.Item;

public interface TaxCalculator {

    public double computeCost(Item item);
}
