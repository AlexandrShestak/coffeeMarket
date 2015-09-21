var myApp = angular.module('todoApp', ['shop']);

/*
myApp.config(['$resourceProvider', function($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

myApp.config(function($routeProvider){
    $routeProvider
        .when( '/brands', { controller: 'simpleBrandController', templateUrl: 'application/components/brands/brands.html' } )
        .when('/order', { controller: 'simpleBrandController', templateUrl: 'application/components/contactInformation/order.html' })
        .when('/orderEnd', { controller: 'simpleBrandController', templateUrl: 'application/components/orderEnd/orderEnd.html' })
        .otherwise( { redirectTo: '/brands' } );
});
*/

myApp.filter('highlight', function($sce) {
    return function (text, phrase) {
        if (phrase) text = text.replace(new RegExp('(' + phrase + ')', 'gi'),
            '<span class="highlighted">$1</span>')
        return $sce.trustAsHtml(text)
    }
});
