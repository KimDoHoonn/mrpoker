<%@page import="getcard.CheckResult"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="java.util.*" %>
<%@ page import="getcard.GetCard"%>
<%
	int[] cardNum  = new int[14];
	int[] compCard = new int[7];
	int[] userCard = new int[7];
	
	GetCard gc = new GetCard();
	cardNum = gc.mixCard();
	
	for(int i=0;i<7;i++) {
		compCard[i] = cardNum[i];
	}
	for(int j=7;j<14;j++) {
		userCard[j-7] = cardNum[j];
	}
	
	CheckResult cr = new CheckResult();
	String compResult = cr.getResult(compCard);
	String userResult = cr.getResult(userCard);
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Poker With Yong</title>
	</head>
	<script type="text/javascript">
		state = 0;
		function changeImage1() {
			if(state==0) {
				state = 1;
				document.getElementById('image_2').src = './image/0.jpg';
				document.getElementById('image_3').src = './image/0.jpg';
			} 
		}
		function changeImage2() {
			if(state==0) {
				state = 1;
				document.getElementById('image_1').src = './image/0.jpg'; 
				document.getElementById('image_3').src = './image/0.jpg';
			} 
		}
		function changeImage3() {
			if(state==0) {
				state = 1;
				document.getElementById('image_1').src = './image/0.jpg';
				document.getElementById('image_2').src = './image/0.jpg';
			} 
		} 
	</script>
	<body>
		<table>
			<tr>
				<td>
					<img alt="c_00" src="./image/<%= cardNum[0] %>.jpg" border="1px">
					<img alt="c_01" src="./image/<%= cardNum[1] %>.jpg" border="1px">
					<img alt="c_02" src="./image/<%= cardNum[2] %>.jpg" border="1px">
				</td>	
			</tr>
			<tr>
				<td>Computer</td>
			</tr>
			<tr>
				<td>
					<a href="http://localhost:8080/study_web/#">
						<img id = "image_1" onclick="changeImage1()" alt="c_7" src="./image/<%= cardNum[7] %>.jpg" border="1px" >
						<img id = "image_2" onclick="changeImage2()" alt="c_8" src="./image/<%= cardNum[8] %>.jpg" border="1px" >
						<img id = "image_3" onclick="changeImage3()" alt="c_9" src="./image/<%= cardNum[9] %>.jpg" border="1px" >
					</a>
				</td>
			</tr>
			<tr>
				<td>User</td>
			</tr>
			<tr>
				<td>
					<form method="POST" action="step1.jsp">
						<input type="hidden" name="comNum00" value="<%= cardNum[0] %>">
						<input type="hidden" name="comNum01" value="<%= cardNum[1] %>">
						<input type="hidden" name="comNum02" value="<%= cardNum[2] %>">
						<input type="hidden" name="comNum03" value="<%= cardNum[3] %>">
						<input type="hidden" name="comNum04" value="<%= cardNum[4] %>">
						<input type="hidden" name="comNum05" value="<%= cardNum[5] %>">
						<input type="hidden" name="comNum06" value="<%= cardNum[6] %>">
						<input type="hidden" name="bshNum00" value="<%= cardNum[7] %>">
						<input type="hidden" name="bshNum01" value="<%= cardNum[8] %>">
						<input type="hidden" name="bshNum02" value="<%= cardNum[9] %>">
						<input type="hidden" name="bshNum03" value="<%= cardNum[10]%>">
						<input type="hidden" name="bshNum04" value="<%= cardNum[11]%>">
						<input type="hidden" name="bshNum05" value="<%= cardNum[12]%>">
						<input type="hidden" name="bshNum06" value="<%= cardNum[13]%>">
						<input type="hidden" name="compResult" value="<%= compResult %>">
						<input type="hidden" name="userResult" value="<%= userResult %>">
						<input type="submit" value="계속" >
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>