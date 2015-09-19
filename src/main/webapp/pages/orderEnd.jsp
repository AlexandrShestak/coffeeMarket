<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<div>
  <table class="table">
   <tr>
     <td>
       Заказ отправлен
     </td>
     <td>
       Цена заказа:
     </td>
    </tr>
  </table>

    {{brands[1].count}}

    <ul>
      <li ng-repeat="brand in brands | filter:searchText | orderBy:'name'">
        <input type="checkbox" class="checkCoffee">
        {{brand.name}}
        {{brand.count}}
        {{brand}}
      </li>
    </ul>



</div>
