package groovy

import com.shestakam.order.entity.OrderPriceCalcilator;

class GroovyOrderPriceCalculator implements  OrderPriceCalcilator{
    String message = "Alexandr1";

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }
}