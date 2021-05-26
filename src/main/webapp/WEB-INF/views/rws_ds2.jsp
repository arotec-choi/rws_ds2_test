<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
	.myButton {
	box-shadow:inset 0px 39px 0px -24px #e67a73;
	background-color:#e4685d;
	border-radius:4px;
	border:1px solid #ffffff;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	padding:6px 15px;
	text-decoration:none;
	text-shadow:0px 1px 0px #b23e35;
}
.myButton:hover {
	background-color:#eb675e;
}
.myButton:active {
	position:relative;
	top:1px;
}

.myButton1 {
	box-shadow:inset 0px 39px 0px -24px #9fb4f2;
	background-color:#9fb4f2;
	border-radius:4px;
	border:1px solid #ffffff;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	padding:6px 15px;
	text-decoration:none;
	text-shadow:0px 1px 0px #b23e35;
}
.myButton1:hover {
	background-color:#9fb4f2;
}
.myButton1:active {
	position:relative;
	top:1px;
}
	
	</style>
	
</head>
<body>
<a href="wuiView" class="myButton" >버튼1</a>

<a href="wuiEdit" class="myButton1">버튼2</a>
</body>

</html>
