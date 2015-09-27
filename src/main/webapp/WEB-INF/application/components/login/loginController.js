angular.module('coffeeShopApplication').controller('loginController', function($rootScope, $scope, $http, $location) {


    $scope.credentials = {};

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
        } : {};
       /* var headers = credentials ? {authorization : "Basic "
        + btoa("user:pafss")
        } : {};*/
        $http.get('user', {headers : headers}).success(function(data) {
            $rootScope.authenticated = true;
           /* if (data.name) {
                $rootScope.authenticated = true;
            } else {
                $rootScope.authenticated = false;
            }*/
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
                $scope.message = "Неправильное имя пользователя или пароль"
            }
        });
    }

    $scope.registration = function(){
        $location.path("/registration");
    }
});



