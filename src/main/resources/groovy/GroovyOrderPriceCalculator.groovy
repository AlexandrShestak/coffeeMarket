package groovy

import com.shestakam.order.OrderPriceCalculator

class GroovyOrderPriceCalculator implements  OrderPriceCalculator{
    String message = "Alexandr1";

    int n = 5
    int m = 2
    int x = 10

    @Override
    int calculatePrice(List collection) {
        def price = 0
        collection.each {
            def free = Math.floor((it.count / n))
            price += (it.count - free) * it.price
        }

        if ( price < x && price != 0)
            price += m
        price
    }
}