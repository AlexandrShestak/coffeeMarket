/**
 * Created by shestakam on 21.9.15.
 */
angular.module('coffeeShopApplication').factory('brandFactory',function($resource){
    return $resource('/brands/:id');
});