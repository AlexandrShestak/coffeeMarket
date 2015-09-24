/**
 * Created by shestakam on 24.9.15.
 */
/**
 * Created by shestakam on 21.9.15.
 */
angular.module('coffeeShopApplication').controller('loginController', function($rootScope, $scope, $http, $location) {


    $scope.credentials = {};

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('user', {headers : headers}).success(function(data) {
            if (data.name) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback();
        }).error(function() {
            $rootScope.authenticated = false;
            callback && callback();
        });

    }

    $scope.login = function() {

        authenticate($scope.credentials, function() {
            if ($rootScope.authenticated) {
                $location.path("/brands");
                $scope.error = false;
            } else {
                $location.path("/login");
                $scope.error = true;
            }
        });
    }

});



