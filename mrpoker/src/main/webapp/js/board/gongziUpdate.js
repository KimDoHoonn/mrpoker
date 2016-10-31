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
	 location.href= serverAddr + "/html/board/gongziForm.html?no=" + no
});

$("#updateBtn").click(function(event) {
  var gongzi = {
	    title: $("#title").val(),
	    contents: $("#contents").val(),
	    email: $("email").val(),
	    no: $("#no").val()
				  }
  if (confirm("정말 변경하시겠습니까?") == true) {
    ajaxUpdateGongzi(gongzi)
  } else {
	  return;
  }
});


function ajaxLoadGongzi(no) {
	$.getJSON(serverAddr + "/gongzi/detail.json?no=" + no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("조회 실패입니다.")
			return
		}
		$("#no").val(result.data.no);
		$("#email").val(result.data.email);
		$("#writer").val(result.data.writer);
		$("#title").val(result.data.title);
		$("#contents").text(result.data.contents);
		$("#createdDate").text(result.data.createdDate);
		$("#viewCount").text(result.data.viewCount);		
	})
}

function ajaxUpdateGongzi(gongzi) {
	$.post(serverAddr + "/gongzi/update.json", gongzi, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("변경 실패입니다.")
			return
		}
		 var no = location.search.split("=")[1];
		 location.href = serverAddr + "/html/board/gongziForm.html?no=" + no
	}, "json")
}








