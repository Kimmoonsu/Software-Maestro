<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <style>
.member {
 font-size: 50px;
 text-shadow: 0 0 10px #666;
 color: #fff;
 margin: 0 auto;
 text-align: center;
 text-transform: capitalize;
 font-family: "¸¼Àº °íµñ";
 font-style: italic;
}
body				{ font-family: Georgia, serif; background: url(/WEB-INF/view/login-page-bg.jpg) top center no-repeat #c4c4c4; color: #3a3a3a;  }
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
					  
.button				{ background: url(/WEB-INF/view/button-bg.png) repeat-x top center; border: 1px solid #999;
					  -moz-border-radius: 5px; padding: 5px; color: black; font-weight: bold;
					  -webkit-border-radius: 5px; font-size: 13px;  width: 70px; }
.button:hover		{ background: white; color: black; }
#wrap {
 width: 600px;
 height: 500px;
 margin: 0 auto;
}
 </style>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
  <div id="wrap">
   <h1 class="member">Secretter °ü¸®ÀÚ ·Î±×ÀÎ</h1>
   <div class="form">
    <form id="login-form" action="check.do" method="post">
		<fieldset>
			<legend>Log in</legend>
			<br><br>
			<label for="login">ID</label>
			<input type="text" id="id" name="id"/>
			<div class="clear"></div>
			
			<label for="password">Password</label>
			<input type="password" id="passwd" name="passwd"/>
			<div class="clear"></div>
			<div class="clear"></div>
			<br />
			<input type="submit" style="margin: -20px 0 0 287px;" class="button" name="commit" value="Log in"/>	
		</fieldset>
	</form>
   </div>
  </div>
</body>
</html>