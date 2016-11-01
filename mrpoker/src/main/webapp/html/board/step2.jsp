<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
	
<% 
int comNum00 = Integer.parseInt(request.getParameter("comNum00"));
int comNum01 = Integer.parseInt(request.getParameter("comNum01"));
int comNum02 = Integer.parseInt(request.getParameter("comNum02"));
int comNum03 = Integer.parseInt(request.getParameter("comNum03"));
int comNum04 = Integer.parseInt(request.getParameter("comNum04"));
int comNum05 = Integer.parseInt(request.getParameter("comNum05"));
int comNum06 = Integer.parseInt(request.getParameter("comNum06"));
int bshNum00 = Integer.parseInt(request.getParameter("bshNum00"));
int bshNum01 = Integer.parseInt(request.getParameter("bshNum01"));
int bshNum02 = Integer.parseInt(request.getParameter("bshNum02"));
int bshNum03 = Integer.parseInt(request.getParameter("bshNum03"));
int bshNum04 = Integer.parseInt(request.getParameter("bshNum04"));
int bshNum05 = Integer.parseInt(request.getParameter("bshNum05"));
int bshNum06 = Integer.parseInt(request.getParameter("bshNum06"));
String compResult = request.getParameter("compResult");
String userResult = request.getParameter("userResult");
//int selectCard = Integer.parseInt(request.getParameter("seleCard"));
//int selcard0 = 0;
//int selcard1 = 0;
//int selcard2 = 0;
//switch (selectCard) {
//case 1 :
//	selcard0 = bshNum00;
//	break;
//case 2 :
//	selcard1 = bshNum01;
//	break;
//case 3 :
//	selcard2 = bshNum02;
//	break;
//}
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Poker With Yong</title>
</head>
<body>
		<table>
			<tr>
				<td>
					<img alt="c_00" src="./image/<%= comNum00 %>.jpg" border="1px">
					<img alt="c_01" src="./image/<%= comNum01 %>.jpg" border="1px">
					<img alt="c_02" src="./image/<%= comNum02 %>.jpg" border="1px">
					<img alt="c_03" src="./image/<%= comNum03 %>.jpg" border="1px">
					<img alt="c_04" src="./image/<%= comNum04 %>.jpg" border="1px">
				</td>	
			</tr>
			<tr>
				<td>Computer</td>
			</tr>
			<tr>
				<td>
					<a href="http://localhost:8080/study_web/#">
						<img alt="c_07" src="./image/<%= bshNum00 %>.jpg" border="1px" >
						<img alt="c_08" src="./image/<%= bshNum01 %>.jpg" border="1px" >
						<img alt="c_09" src="./image/<%= bshNum02 %>.jpg" border="1px" >
						<img alt="c_10" src="./image/<%= bshNum03 %>.jpg" border="1px" >
						<img alt="c_11" src="./image/<%= bshNum04 %>.jpg" border="1px" >
					</a>
				</td>
			</tr>
			<tr>
				<td>User</td>
			</tr>
			<tr>
				<td>
					<form method="POST" action="step3.jsp">
						<input type="hidden" name="comNum00" value="<%= comNum00 %>">
						<input type="hidden" name="comNum01" value="<%= comNum01 %>">
						<input type="hidden" name="comNum02" value="<%= comNum02%>">
						<input type="hidden" name="comNum03" value="<%= comNum03 %>">
						<input type="hidden" name="comNum04" value="<%= comNum04 %>">
						<input type="hidden" name="comNum05" value="<%= comNum05 %>">
						<input type="hidden" name="comNum06" value="<%= comNum06 %>">
						<input type="hidden" name="bshNum00" value="<%= bshNum00 %>">
						<input type="hidden" name="bshNum01" value="<%= bshNum01 %>">
						<input type="hidden" name="bshNum02" value="<%= bshNum02 %>">
						<input type="hidden" name="bshNum03" value="<%= bshNum03 %>">
						<input type="hidden" name="bshNum04" value="<%= bshNum04 %>">
						<input type="hidden" name="bshNum05" value="<%= bshNum05 %>">
						<input type="hidden" name="bshNum06" value="<%= bshNum06 %>">
						<input type="hidden" name="compResult" value="<%= compResult %>">
						<input type="hidden" name="userResult" value="<%= userResult %>">
						<input type="submit" value="°è¼Ó" >					
					</form>
				</td>
			</tr>
		</table>
</body>
</html>