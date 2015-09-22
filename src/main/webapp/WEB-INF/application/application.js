var myApp = angular.module('coffeeShopApplication', ['shop']);

//service to pass data from brandController to contactInformationController
angular.module('coffeeShopApplication').service('orderItemService', function() {
    var orderItemList = [];

    var addOrderItem = function(newObj) {
        orderItemList.push(newObj);
        return 12;
    };

    var getOrderItems = function(){
        return orderItemList;
    };

    return {
        addOrderItem: addOrderItem,
        getOrderItems: getOrderItems
    };

});


myApp.filter('highlight', function($sce) {
    return function (text, phrase) {
        if (phrase) text = text.replace(new RegExp('(' + phrase + ')', 'gi'),
            '<span class="highlighted">$1</span>')
        return $sce.trustAsHtml(text)
    }
});
