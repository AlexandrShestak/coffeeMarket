/**
 * Created by shestakam on 22.9.15.
 */
angular.module('coffeeShopApplication').controller('contactInformationController', function($scope,$http,$location,orderItemService) {

    $scope.orderItems = orderItemService.getOrderItems()

    $scope.makeOrder= function(){
        /* var dataObj = [{"id":1,"name":"Arabica"},{"id":2,"name":"Robusta"},{"id":3,"name":"Folgers"},{"id":6,"name":"tratatta"}]
         */

        var dataObj = new Array();
        angular.forEach($scope.orderItems , function(orderItem){

            dataObj.push(orderItem);
        });

        var res = $http.post('/groovy', dataObj);

        var total = 0;

        res.success(function(data, status, headers, config) {
            $scope.message = data;
        });
        /* $location.path('/order')*/
    }

});



