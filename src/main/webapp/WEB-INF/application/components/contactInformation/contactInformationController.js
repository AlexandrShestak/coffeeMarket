/**
 * Created by shestakam on 22.9.15.
 */
angular.module('coffeeShopApplication').controller('contactInformationController', function($scope,$http,$location,orderItemService) {

    $scope.orderItems = orderItemService.getOrderItems()

    $scope.makeOrder= function(){
        /* var dataObj = [{"id":1,"name":"Arabica"},{"id":2,"name":"Robusta"},{"id":3,"name":"Folgers"},{"id":6,"name":"tratatta"}]
         */

        var dataObj = {};
        dataObj.orderItemSet = $scope.orderItems;
        dataObj.username = $scope.user.username;
        dataObj.address = $scope.user.address;
        dataObj.totalPrice = orderItemServicer.getTotalPrice();

        var res = $http.post('/makeOrder', dataObj);

        var total = 0;

        res.success(function(data, status, headers, config) {
            $scope.message = data;
        });
        /* $location.path('/order')*/
    }

});



