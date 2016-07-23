<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.member {
 font-size: 30px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: "맑은 고딕";
 font-style: italic;
}
body				{ font-family: Georgia, serif; background: gray; color: #3a3a3a;  }
.form {
 width: 498px;
 height: 200px;
 border-radius: 25px;
 border: 5px double #999;
 margin: 30px auto;
}
.clear				{ clear: both; }


legend				{ display: none; }

fieldset			{ border: 0; }

label				{ width: 115px; text-align: right; float: left; margin: 0 10px 0 0; padding: 9px 0 0 0; font-size: 16px; }

input				{ width: 220px; display: block; padding: 4px; margin: 0 0 10px 0; font-size: 18px;
					  color: #3a3a3a; font-family: Georgia, serif;}
input[type=checkbox]{ width: 20px; margin: 0; display: inline-block; }
					  
.button				{ background: black; border: 1px solid #999;
					  -moz-border-radius: 5px; padding: 5px; color: white; font-weight: bold;
					  -webkit-border-radius: 5px; font-size: 13px;  width: 70px; }
.button:hover		{ background: white; color: black; }
#wrap {
 width: 600px;
 height: 500px;
 margin: 0 auto;
}
 </style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
	<h1 class="member">Secretter 관리자 페이지 입니다.</h1>
	<br><br>
	<form id="login-form" action="userList.do" method="post">
		<input type="submit" style="font-size:30px; width:300px; height:100px; margin: +50px 0 0 150px;" class="button" name="commit" value="사용자 보기"/>
	</form>
	 <form id="login-form" action="letterList.do" method="post">
		<input type="submit" style="font-size:30px; width:300px; height:100px; margin: +50px 0 0 150px;" class="button" name="commit" value="편지함 보기"/>
	</form>
	<form id="login-form" action="accessList.do" method="post">
		<input type="submit" style="font-size:30px; width:300px; height:100px; margin: +50px 0 0 150px;" class="button" name="commit" value="접속자 리스트 보기"/>
	</form>
</div>
</body>
</html>