/**
 * Created by shestakam on 22.9.15.
 */
angular.module('coffeeShopApplication').controller('contactInformationController', function($scope,$http,$location,orderItemService) {

    $scope.orderItems = orderItemService.getOrderItems();
    $scope.totalPrice = orderItemService.getTotalPrice();

    $scope.makeOrder= function(){
        var dataObj = {};
        dataObj.orderItemSet = $scope.orderItems;
        dataObj.username = $scope.user.username;
        dataObj.address = $scope.user.address;
        dataObj.totalPrice =  $scope.totalPrice;
        var res = $http.post('/makeOrder', dataObj);
        res.success(function(data, status, headers, config) {
            $location.path('/orderEnd');
        });
    }

});



