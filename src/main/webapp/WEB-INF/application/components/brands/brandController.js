/**
 * Created by shestakam on 21.9.15.
 */
angular.module('coffeeShopApplication').controller('simpleBrandController', function($scope,$http,$location,brandFactory,orderItemService) {

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
                dataObj.push(orderItem);
                orderItemService.addOrderItem(orderItem);
            }
        });
        var res = $http.post('/calculatePrice', dataObj);
        var total = 0;
        res.success(function(data, status, headers, config) {
            total = data;
            orderItemService.saveTotalPrice(total);
            if (total == 0){
                $scope.message = "Выберите что-нибудь";
                $location.path('/brands')
            }else {
                $location.path('/order')
            }
        });
    }
});



