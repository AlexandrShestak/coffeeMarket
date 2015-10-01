angular.module('coffeeShopApplication').controller('loginController', function($rootScope, $scope, $http, $location) {


    $scope.credentials = {};

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
        } : {};
       /* var headers = credentials ? {authorization : "Basic "
        + btoa("user:pafss")
        } : {};*/
        $http.get('login', {headers : headers}).success(function(data) {
            $rootScope.authenticated = true;
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
            } else {
                $location.path("/login");
                $scope.message = "Неправильное имя пользователя или пароль"
            }
        });
    }

    $scope.registration = function(){
        $location.path("/registration");
    }
});



