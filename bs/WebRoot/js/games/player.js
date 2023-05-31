
function searchPlayer() {
	$('#dg').datagrid('load', {
		keyword : $('#s_keyword').val(),
		sex : $('#s_sex').val()
	});
}


$(function(){
	var sex =$("#hsex").val();
	var disease = $("#hdisease").val();
	$("#sex").val(sex);
	$("#disease").val(disease);
});

//保存
function reservePlayer() {
	$("#fm").form("submit",
			{
				url : "reservePlayer.htm",
				onSubmit : function() {
					return $(this).form("validate");
				},
				success : function(result) {
					console.log(result);
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						$.messager.alert('系统提示', "<font color=red>"+ result.errorMsg + "</font>");
						return;
					} else {
						$.messager.alert('系统提示', '保存成功');
					}
				}
	});
}

