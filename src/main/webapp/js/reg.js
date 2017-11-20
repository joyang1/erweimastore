//判断用户名是否是由字母和数字组成
$(document).ready(function() {
	$("#username").focusout(function(){
		$('#tishi1').empty();
		var patt = new RegExp(/^[a-z0-9_-]{6,10}$/);
		if (patt.test($('#username').val())) {
			$('#username').before("<p id=\"tishi1\" style=\"color:red\">right</p>");
		} else {
			$('#username').before("<p id=\"tishi1\" style=\"color:red\">输入格式 不对，用户名必须为6到10位的字符串和数字</p>");
		}
	});
});
