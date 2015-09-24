var shop = angular.module('shop', [ 'ngRoute','ngResource']);
shop.config(function($routeProvider){
    $routeProvider
        .when( '/brands', { controller: 'simpleBrandController', templateUrl: 'application/components/brands/brands.html' } )
        .when('/order', { controller: 'contactInformationController', templateUrl: 'application/components/contactInformation/contactInformation.html' })
        .when('/orderEnd', { controller: '', templateUrl: 'application/components/orderEnd/orderEnd.html' })
        .when('/login', { controller: 'loginController', templateUrl: 'application/components/login/login.html' })

        .otherwise( { redirectTo: '/login' } );
});
shop.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);


