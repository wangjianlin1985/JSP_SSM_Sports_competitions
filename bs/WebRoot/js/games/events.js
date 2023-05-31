var url;
// 条件搜索用户信息
function searchEvents() {
	$('#dg').datagrid('load', {
		name : $('#s_name').val(),
		sex : $('#s_sex').val(),
		type : $('#s_type').val()
	});
}

function openEventsAddDialog() {
	$("#dlg").dialog("open").dialog("setTitle", "添加比赛项目信息");
	url = 'reserveEvents.htm';
}

function openEventsUpdateDialog() {
	var selectedRows = $("#dg").datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条要编辑的数据！');
		return;
	}
	var row = selectedRows[0];
	$("#dlg").dialog("open").dialog("setTitle", "修改比赛项目信息信息");
	$("#fm").form("load", row);
	url = "reserveEvents.htm?id=" + row.id;
}


// 保存
function reserveEvents() {
	$("#fm").form(
			"submit",
			{
				url : url,
				onSubmit : function() {
					return $(this).form("validate");
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						$.messager.alert('系统提示', "<font color=red>"+ result.errorMsg + "</font>");
						return;
					} else {
						$.messager.alert('系统提示', '保存成功');
						closeEventsDialog();
						$("#dg").datagrid("reload");
					}
				}
	});
}

// 关闭添加修改角色对话框
function closeEventsDialog() {
	$("#fm").form('clear');
	$("#dlg").dialog("close");
}



// 删除
function deleteEvents() {
	var selectedRows = $("#dg").datagrid('getSelections');
	if (selectedRows.length == 0) {
		$.messager.alert('系统提示', '请选择要删除的数据！');
		return;
	}
	var strIds = [];
	for ( var i = 0; i < selectedRows.length; i++) {
		strIds.push(selectedRows[i].id);
	}
	var ids = strIds.join(",");
	$.messager.confirm("系统提示", "您确认要删除这些数据吗？", function(r) {
		if (r) {
			$.post("deleteEvents.htm", {
				ids : ids
			}, function(result) {
				if (result.success) {
					$.messager.alert('系统提示', "您已成功删除数据！");
					$("#dg").datagrid("reload");
				} else {
					$.messager.alert('系统提示', result.errorMsg);
				}
			}, "json");
		}
	});
}


