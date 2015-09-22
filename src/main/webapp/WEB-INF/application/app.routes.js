var shop = angular.module('shop', [ 'ngRoute','ngResource']);
shop.config(function($routeProvider){
    $routeProvider
        .when( '/brands', { controller: 'simpleBrandController', templateUrl: 'application/components/brands/brands.html' } )
        .when('/order', { controller: 'simpleBrandController', templateUrl: 'application/components/contactInformation/contactInformation.html' })
        .when('/orderEnd', { controller: 'simpleBrandController', templateUrl: 'application/components/orderEnd/orderEnd.html' })
        .otherwise( { redirectTo: '/brands' } );
});
shop.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);


