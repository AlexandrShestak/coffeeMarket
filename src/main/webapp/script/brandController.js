var myApp = angular.module('todoApp', [ 'ngRoute', 'ngResource' ]);

myApp.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

myApp.factory('brandFactory',function($resource){
    return $resource('/brands/:id');
   /* return {
        async: function () {
            return $http.get('brands.json');  //1. this returns promise
        }
    }
   /!* var factory={};
    var brandList;
     $http.get('/brands').success(function(response){
     brandList = response;
     })*!/
     var brandList = [
     {name:'Arabica'},
     {name:'Robusta'},
     {name:'Folgers'},
     {name:'Nescafe'},
     {name:'Gevalia'},
     {name:'Gevalia1111'}
     ];

    factory.getBrands = function(){
        $http.get('/brands').then(function(response){
            var  brandList = response.data;
            alert('2')
            alert(brandList[1].name);
        })
        $scope.brands = brandList
        return brandList;
    };
    return factory;*/
});

myApp.controller('SimpleBrandController', function($scope,brandFactory) {
    $scope.brands = brandFactory.query(function() {
        console.log("tratata");
    });
   /* alert('1')
    brandFactory.async().then(function(d) { //2. so you can use .then()
        $scope.brands = d;
    });
    $scope.brands = brandFactory.getBrands();*/
});



/*myApp.factory('Phone', ['$resource',
    function($resource){
        return $resource('phones/.json', {}, {
            query: {method:'GET', params:{}, isArray:true}
        });
    }]);*/
