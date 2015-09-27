
angular.module('coffeeShopApplication').controller('registrationController', function($rootScope, $scope, $http, $location) {


    $scope.registration = function(){
        var dataObj = {};
        dataObj.username = $scope.user.login;
        dataObj.email = $scope.user.email;
        dataObj.password = $scope.user.password;
        $http.post('registration',dataObj).success(function() {
            $location.path("/login");
        }).error(function() {
            $scope.message = "Пользователь с таким именем уже зарегистрирован";
            $location.path("/registration");
        });
    }
});