var myApp = angular.module('coffeeShopApplication', ['shop']);

//service to pass data from brandController to contactInformationController
angular.module('coffeeShopApplication').service('orderItemService', function() {
    var orderItemList = [];
    var totalPrice = 0;

    var saveTotalPrice = function(newObj){
        totalPrice = newObj
    };

    var getTotalPrice = function(){
        return totalPrice;
    }
    var deleteOrderItems = function(){
        orderItemList.removeAll()
    }

    var addOrderItem = function(newObj) {
        orderItemList.push(newObj);
    };

    var getOrderItems = function(){
        return orderItemList;
    };

    return {
        addOrderItem: addOrderItem,
        getOrderItems: getOrderItems,
        deleteOrderItems: deleteOrderItems,
        saveTotalPrice: saveTotalPrice,
        getTotalPrice: getTotalPrice

    };

});


myApp.filter('highlight', function($sce) {
    return function (text, phrase) {
        if (phrase) text = text.replace(new RegExp('(' + phrase + ')', 'gi'),
            '<span class="highlighted">$1</span>')
        return $sce.trustAsHtml(text)
    }
});
