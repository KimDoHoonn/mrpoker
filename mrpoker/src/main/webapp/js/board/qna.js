function ajaxQnaList() {
	$.getJSON(serverAddr + "/mrpoker/list1.json", function(obj) {
		var result = obj.jsonResult
		console.log(result)
		if (result.state != "success") {
			alert("서버에서 데이터를 가져오는데 실패했습니다.")
			return
		}

		var template = Handlebars.compile($('#trTemplateText').html())	    
		$("#gongziTable").html(template(result.data))

		$(document.body).on('click', '.card1', function(event) {
			window.location.href = serverAddr + "/html/board/qnaForm.html?no=" + $(this).attr("data-no")
		})
	})
}







