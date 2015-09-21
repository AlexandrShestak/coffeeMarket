/**
 * Created by shestakam on 21.9.15.
 */
angular.module('todoApp').controller('simpleBrandController', function($scope,$http,$location,brandFactory) {

    var brands = brandFactory.query(function() {
        console.log("brands");
    })
    $scope.brands = brands;
    $scope.totalPrice = function(){

        var total = 0;

        angular.forEach($scope.brands , function(brand){
            if (brand.check){
                total+= brand.count;
            }
        });

        return total;
    }
    $scope.postQuery = function(){
        /* var dataObj = [{"id":1,"name":"Arabica"},{"id":2,"name":"Robusta"},{"id":3,"name":"Folgers"},{"id":6,"name":"tratatta"}]
         */

        var dataObj = new Array();
        angular.forEach($scope.brands , function(brand){
            if (brand.check){
                delete brand.check
                brand = brand.replace("\"name\":", "\"brand\":");
                dataObj.push(brand)
            }
        });

        var res = $http.post('/groovy', dataObj);

        var total = 0;

        res.success(function(data, status, headers, config) {
            $scope.message = data;
        });
       /* $location.path('/order')*/
    }
});



