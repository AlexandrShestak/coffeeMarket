package groovy

import com.shestakam.order.entity.OrderPriceCalculator;

class GroovyOrderPriceCalculator implements  OrderPriceCalculator{
    String message = "Alexandr1";

    int n = 5;
    int m = 2;
    int x = 10;


    @Override
    int calculatePrice(Collection collection) {
        var price = 0;
        collection.each {
            println("value ${it}")
        }
    }
}