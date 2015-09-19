var myApp = angular.module('todoApp', [ 'ngRoute', 'ngResource' ]);

myApp.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

myApp.factory('brandFactory',function($resource){
    return $resource('/brands/:id');
});

myApp.controller('simpleBrandController', function($scope,$http,brandFactory) {



    var brands = brandFactory.query(function() {
        console.log("brands");
    })


    $scope.brands = brands;

    $scope.totalPrice = function(){

        var total = 0;

        angular.forEach()
        angular.forEach($scope.brands , function(brand){
            if (brand.check){
                total+= brand.count;
            }
        });

        return total;
    }

    var dataObj = {"id":1,"name":"Arabica"}

    $scope.postQuery = function(){
        var res = $http.post('/groovy', dataObj);

        res.success(function(data, status, headers, config) {
            $scope.message = data;
        });
    }


});

myApp.config(function($routeProvider){
    $routeProvider
        .when( '/brands', { controller: 'simpleBrandController', templateUrl: 'pages/brands.jsp' } )
        .when('/order', { controller: 'simpleBrandController', templateUrl: 'pages/order.jsp' })
        .when('/orderEnd', { controller: 'simpleBrandController', templateUrl: 'pages/orderEnd.jsp' })
        .otherwise( { redirectTo: '/brands' } );
});

myApp.filter('highlight', function($sce) {
    return function (text, phrase) {
        if (phrase) text = text.replace(new RegExp('(' + phrase + ')', 'gi'),
            '<span class="highlighted">$1</span>')
        return $sce.trustAsHtml(text)
    }
});




