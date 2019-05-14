package library.configuration;

import library.domain.entity.Item;
import library.tool.TaxCalculator;

public class ToolConfig {
    private TaxCalculator bookTaxCalculator = new TaxCalculator() {
        @Override
        public double computeCost(Item item) {
            return 5;
        }
    };

    private TaxCalculator otherItems = new TaxCalculator() {
        @Override
        public double computeCost(Item item) {
            return 20;
        }
    };

    public TaxCalculator getBookTaxCalculator() {
        return bookTaxCalculator;
    }

    public TaxCalculator getOtherItems() {
        return otherItems;
    }

    private static ToolConfig ourInstance = new ToolConfig();

    public static ToolConfig getInstance() {
        return ourInstance;
    }

    private ToolConfig() {
    }
}
