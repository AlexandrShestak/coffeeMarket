/**
 * Created by shestakam on 21.9.15.
 */
angular.module('coffeeShopApplication').controller('simpleBrandController', function($scope,$http,$location,brandFactory,orderItemService) {
    /*var brands = brandFactory.query(function() {
        console.log("get brands(ajax)");
    })*/
    $scope.brands = brandFactory.query(function() {
        console.log("get brands(ajax)");
    })

    $scope.postQuery = function(){

        orderItemService.deleteOrderItems();
        var dataObj = new Array();
        angular.forEach($scope.brands , function(brand){
            if (brand.check){
                var orderItem = {};
                orderItem.amount = brand.count;
                orderItem.brandId = brand.id;
              /*  delete brand.check
                var brandItemJson = JSON.stringify(brand)
                brandItemJson = brandItemJson.replace("\"name\":", "\"brand\":");
                brand = JSON.parse(brandItemJson);*/
                dataObj.push(orderItem);
                orderItemService.addOrderItem(orderItem);
            }
        });
        var res = $http.post('/calculatePrice', dataObj);
        var total = 0;
        res.success(function(data, status, headers, config) {
            total = data;
            orderItemService.saveTotalPrice(total);
            $location.path('/order')
        });
    }
});



