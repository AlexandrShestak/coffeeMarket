<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<div  ng-controller="simpleBrandController">

    <h1>Search:</h1>
    <input type="text" data-ng-model="searchText"/>
    <ul>
        <li ng-repeat="brand in brands | filter:searchText | orderBy:'name'">
            <input type="checkbox" class="checkCoffee">
            {{brand.name}}
            <input  type="text" hidden="hidden" ng-model="brand.count" ng-init="brand.count = 0" class="countCoffee">
            {{brand}}
        </li>
    </ul>

    <a href="#order">
        <button class="alert-link" >Сделать заказ</button>
    </a>

    <%-- <ul>
       <li>
         <input class="checkCoffee" type="checkbox">
         <input class="countCoffee" hidden="hidden" type="text">
         Arabica
       </li>
     <li>
       <input class="checkCoffee" type="checkbox">
       <input class="countCoffee" hidden="hidden" type="text">
       Folgers
     </li>
       <li>
       <input class="checkCoffee" type="checkbox">
       <input class="countCoffee" hidden="hidden" type="text">
       Robusta
     </li>
       <li>
       <input class="checkCoffee" type="checkbox">
       <input class="countCoffee" hidden="hidden" type="text">
       tratatta
     </li><!-- end ngRepeat: brand in brands | filter:searchText | orderBy:'name' -->
     </ul>--%>

</div>