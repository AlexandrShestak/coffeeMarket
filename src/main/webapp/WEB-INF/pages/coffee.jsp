<%--
  Created by IntelliJ IDEA.
  User: shestakam
  Date: 1.9.15
  Time: 9.32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en" ng-app="todoApp">
<head>
  <meta charset="UTF-8">
  <title></title>
  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/script/angular.min.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/script/brandController.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/script/angular-resource.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/script/angular-route.js"></script>
  <link href="${pageContext.servletContext.contextPath}/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
  <!--  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>-->
</head>
<body>
<h1>hello</h1>
<input type="text" data-ng-model="name">{{name}}
<input type="text" ng-model="yourName" placeholder="Enter a name here">
<hr>
<h1>Hello {{yourName}}!</h1>
<button class="btn-warning">FFFFFFFFFFFFFFFFF</button>
<div class="container" ng-controller="SimpleBrandController">

  <ul>
    <li ng-repeat="brand in brands">
      {{brand.name}}
    </li>
  </ul>
</div>

</body>
</html>


