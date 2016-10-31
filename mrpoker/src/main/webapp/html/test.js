$("#comtaddBtn").click(function(event){
	
	var comment = { 
			//reviewboardNo :$("#crbno").val(),
			reviewboardNo : no,
			/*memberNo :$("#cmno").val(),*/
			content : $("#cmcontent").val()
//			cc.val(result.data.name)
			
	}

	console.log(comment)
	ajaxAddBoard2(comment);	
});


function ajaxAddBoard2(comment){
	console.log(comment)
	console.log(no);
	
	$.post(serverAddr+"/travel/cmadd.json?no="+no,comment,function(obj){
		var result = obj.jsonResult
		console.log(comment)
		if(result.state !="success"){
			alert("로그인하고 댓글써.")
			return;
		}
		location.reload();
		console.log(comment)
		//window.location.href="reviewApp.html"
	},"json")
	
	
}


function ajaxCommentList(no) {
	/*console.log(no)
	console.log(parseInt(no))*/
	$.getJSON(serverAddr+"/travel/cmlist.json?no="+no,parseInt(no), function(obj) {
		var result=obj.jsonResult;
		if(result.state!="success"){
			
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}
		
		var contents="";
		var arr = result.data
		for ( var i in arr) {

			contents += "<tr>"+
				"<td id='firstcolum'>"+arr[i].reviewcommentNo+"<input id='aaa'  ></input></td>"+
				"<td>"+arr[i].memberName+"</td>"+
				"<td>"+arr[i].content+"</td>"+
				"<td>"+arr[i].createdDate2+"</td>"+
				"<td><a class='updateLink' href='#'  data-no3='"+arr[i].content+"' data-no2='"+i+"' data-no='"+arr[i].reviewcommentNo+"'>수정</a></td>"+
				"<td><a class='deleteLink' href='#'  data-no3='"+arr[i].content+"' data-no2='"+i+"' data-no='"+arr[i].reviewcommentNo+"'>삭제</a></td>"+
			"</tr>";

		}
		console.log(contents)
		
		$("#commentTable tbody").html(contents);
		
		//console.log(contents)
		
		// tr 태그를 추가한 후에   제목에 대해 click 리스너를 추가한다.
		$(document).on("click",".updateLink",function(event) {
			
			console.log($(this).attr("data-no"))
			var a=$(this).attr("data-no2")
			console.log(a)
			/*comment = {
				reviewcommentNo : console.log($(this).attr("data-no")),
				content : $('#commentTable tbody tr td:eq(1)').val()
			}*/
			
			
			
			//console.log(arr.content)
			/*$("#commentTable tbody tr:eq("+$(this).attr("data-no2")+") td:eq(1)").html("<input value="+$(this).attr("data-no3")+"></input>");*/
			
			$("#commentTable tbody tr:eq("+a+")").after("<td></td><td><input class='updateContentInput' value="+$(this).attr("data-no3")+"></input></td>" +
					"<td><button type='button' id='commentUpdateBtn'>변경 </button></td>");
			
				//window.location.href = "reviewForm.html?no="+$(this).attr("data-no");//this는 a태그이다  this자리에 selector 말고도 태그를 넣을수 있다.
			console.log($(this).attr("data-no"))
			$("#aaa").val($(this).attr("data-no"))
			});
		
		
		
			
		
			$(document).on("click",".deleteLink",function(event) {
			
			console.log($(this).attr("data-no"))
/*			var a=$(this).attr +("data-no2")
			console.log(a)*/
			
		/*	$("#commentTable tbody tr:eq("+a+")").after("<td></td><td><input class='updateContentInput' value="+$(this).attr("data-no3")+"></input></td>" +
					"<td><button type='button' id='commentUpdateBtn'>변경 </button></td>");*/
			
			console.log($(this).attr("data-no"))
			$("#aaa").val($(this).attr("data-no"))
			
			ajaxCommentDelete($(this).attr("data-no"))
			
			
			});
		/*$(".zz").click(function(event) {
			alert('aaaa');
			
		});*/
		
		
		});
	
		
	
}

function ajaxCommentDelete(no){
	$.getJSON("cmdelete.json?=no"+no,{no:no},function(obj){
		var result = obj.jsonResult
		console.log(no)
		if(result.state !="success"){
			console.log(result.data)
			alert("삭제실패입니다.")
			return;
		}
		location.reload();
		
	})
		
}



$(document).on("click","#commentUpdateBtn",function(event){
	console.log($(this).attr("data-no"));
	
	comment={
			reviewcommentNo : $("#aaa").val(),
			content: $(".updateContentInput").val()
	}
	console.log(comment)
	ajaxCommentUpdate(comment)
});


function ajaxCommentUpdate(comment){
	console.log(comment)
	console.log($(this).attr("data-no"));
	
	$.post(serverAddr+"/travel/cmupdate.json",comment,function(obj){
		var result = obj.jsonResult
		console.log(comment)
		if(result.state !="success"){
			alert("로그인하고 댓글써.")
			return;
		}
		location.reload();
		console.log(comment)
		//window.location.href="reviewApp.html"
	},"json")
	
	
}