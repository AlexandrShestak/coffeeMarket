<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<div  ng-controller="simpleBrandController" ng-cloak>

    <h1>Search:</h1>
    <input type="text" data-ng-model="searchText"/>
    <table class="table">
        <tr ng-repeat="brand in brands | orderBy:'name'">
            <td>
              <input type="checkbox" class="checkCoffee" ng-model="brand.check" ng-init="brand.check = false">
            </td>
            <td>
                <p ng-bind-html="brand.name  | highlight:searchText"></p>
            </td>
            <td>
            <input  type="number" ng-show="brand.check" ng-model="brand.count" ng-init="brand.count = 0" class="countCoffee">
            </td>
            <td>
                {{brand}}
            </td>



             <%-- <input type="checkbox" class="checkCoffee"><h1 ng-bind-html="brand.name  | highlight:searchText"></h1>
            <input  type="text" hidden="hidden" ng-model="brand.count" ng-init="brand.count = 0" class="countCoffee">
            {{brand}}--%>
        </tr>
    </table>

    {{totalPrice()}}


    <button class="btn-warning" ng-click="postQuery()">Post query</button>
    <a href="#order">
        <button class="alert-link" >Сделать заказ</button>
    </a>

    {{message}}

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