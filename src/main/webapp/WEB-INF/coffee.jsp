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

  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/asserts/script/angular.min.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/asserts/script/angular-resource.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/asserts/script/angular-route.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/application/app.routes.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/application/application.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/application/components/brands/brandService.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/application/components/brands/brandController.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/asserts/script/jquery-2.1.4.js"></script>
  <script type="text/javascript"  src="${pageContext.servletContext.contextPath}/asserts/script/myJquery.js"></script>


  <style>
    .highlighted { background: yellow }

    ul.hr {
      margin: 0; /* Обнуляем значение отступов */
      padding: 4px; /* Значение полей */
    }
    ul.hr li {
      display: inline; /* Отображать как строчный элемент */
      margin-right: 5px; /* Отступ слева */
      border: 1px solid #000; /* Рамка вокруг текста */
      padding: 3px; /* Поля вокруг текста */
    }

  </style>

  <link href="${pageContext.servletContext.contextPath}/asserts/bootstrap-3.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
  <!--  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>-->
</head>
<body>
<div style="padding:40px 0px 40px 0px">
  <!--  Placeholder for the views  -->
  <div class="container">
    <div class="col-md-6 col-md-offset-3">
      <div ng-view></div>
    </div>
  </div>
  <input type="text" ng-model="hello"/>
  {{hello}}
</div>


</body>
</html>


