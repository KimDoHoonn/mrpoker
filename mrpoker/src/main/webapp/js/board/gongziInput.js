$(document.body).ready(function() {
    $('.limitation').on('keyup', function() {
        if($(this).val().length > 200) {
        	 alert("글자수는 200자 이내로 제한됩니다.!");  
            $(this).val($(this).val().substring(0, 200));
        }
    });
});

$("#addBtn").click(function(event) {
	var gongzi = {
	  title: $("#title").val(),
	  contents: $("#contents").val(),
	  writer: $("#writer").val(),
	}
	ajaxAddGongzi(gongzi)
});

function ajaxAddGongzi(gongzi) {
	$.post(serverAddr + "/mrpoker/add.json", gongzi, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
	    	 alert("등록 실패입니다.")
	    	 return
	    } 
		window.location.href = serverAddr + "/html/board/gongzi.html"
	    
	}, "json")
}













