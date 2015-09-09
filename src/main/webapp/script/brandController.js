angular.module('todoApp', [])
    .controller('SimpleBrandController', function() {
        var brandList = this;
        brandList.brands = [
            {name:'Arabica'},
            {name:'Robusta'},
            {name:'Folgers'},
            {name:'Nescafe'},
            {name:'Gevalia'}
        ];
    });


