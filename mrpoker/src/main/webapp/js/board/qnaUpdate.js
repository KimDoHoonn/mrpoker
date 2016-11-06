$(document.body).ready(function() {
    $('.updateLimit').on('keyup', function() {
        if($(this).val().length > 200) {
        	 alert("글자수는 200자 이내로 제한됩니다.!");  
            $(this).val($(this).val().substring(0, 200));
        }
    });
});


$("#cancelBtn").click(function(event) {
	 var no = location.search.split("=")[1];	 
	 location.href= serverAddr + "/html/board/qnaForm.html?no=" + no
});

$("#updateBtn").click(function(event) {
  var qna = {
	    title: $("#title").val(),
	    contents: $("#contents").val(),	    
	    no: $("#no").val()
				  }
  if (confirm("정말 변경하시겠습니까?") == true) {
    ajaxUpdateQna(qna)
  } else {
	  return;
  }
});


function ajaxLoadQna(no) {
	$.getJSON(serverAddr + "/qna/detail1.json?no=" + no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("조회 실패입니다.")
			return
		}
		$("#no").val(result.data.no);
		$("#writer").val(result.data.writer);
		$("#title").val(result.data.title);
		$("#contents").text(result.data.contents);
		$("#createdDate").text(result.data.createdDate);
		$("#viewCount").text(result.data.viewCount);		
	})
}

function ajaxUpdateQna(qna) {
	$.post(serverAddr + "/qna/update1.json", qna, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("변경 실패입니다.")
			return
		}
		 var no = location.search.split("=")[1];
		 location.href = serverAddr + "/html/board/qnaForm.html?no=" + no
	}, "json")
}








