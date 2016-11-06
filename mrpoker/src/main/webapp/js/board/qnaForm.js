$("#deleteBtn").click(function(event) {
	if (confirm("정말 삭제하시겠습니까?") == true) {
		ajaxDeleteQna($("#no").text())
	} else {
		return;
	}  
});

function ajaxLoadQna(no) {
	$.getJSON(serverAddr + "/mrpoker/detail1.json?no=" + no, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("조회 실패입니다.")
			return
		}

		$("#no").text(result.data.no);
		$("#writer").text(result.data.writer);
		$("#title").val(result.data.title);
		$("#contents").text(result.data.contents);
		$("#createdDate").text(result.data.createdDate);
		$("#viewCount").text(result.data.viewCount);

		$("#updateBtn").click(function(event) {
			window.location.href = serverAddr + "/html/board/qnaUpdate.html?no=" + no
		})
	})
}

function ajaxDeleteQna(no) {
	$.getJSON(serverAddr + "/qna/delete.json", {
		no: no,
	}, function(obj) {
		var result = obj.jsonResult
		if (result.state != "success") {
			alert("삭제 실패입니다.")
			return
		}
		location.href = serverAddr + "/html/board/qna.html"
	})
}




