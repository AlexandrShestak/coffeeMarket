<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>


<div ng-controller="simpleBrandController">
  <h1>Контактная информация</h1>
  <table class="table">
    <tr>
      <td>
        Введите имя , на которое производится заказ:
      </td>
      <td>
        <input type="text" name="username">
      </td>
    </tr>
    <tr>
      <td>
        Введите адрес для доставки:
      </td>
      <td>
        <input type="text" name="address">
      </td>
    </tr>
    <tr >
      <td colspan="2" align="center">
        <a href="#orderEnd">
          <button class="btn-info">Оформить заказ</button>
        </a>
      </td>
    </tr>
  </table>

  {{totalPrice()}}

  <%--<ul>
    <li ng-repeat="brand in brands | filter:searchText | orderBy:'name'">
      <input type="checkbox" class="checkCoffee">
      {{brand.name}}
      <input  type="text" hidden="hidden" ng-model="brand.count" ng-init="brand.count = 0" class="countCoffee">
      {{brand}}
    </li>
  </ul>--%>


</div>
