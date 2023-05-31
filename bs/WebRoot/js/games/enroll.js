var splitGroupUrl="";
function splitGroup(){
	var eventsid  =  $('#s_eventsid').combobox("getValue");
	if(eventsid==null || eventsid==''){
		$.messager.alert('系统提示', "请选择一个项目");
		return;
	}
	$.ajax({
		url:'searchCountPlayer.htm',
		data:{
			eventsid:eventsid
		},
		dataType:'json',
		type:'post',
		async:false,
		success:function(data){
			if (data.errorMsg) {
				$.messager.alert('系统提示', "<font color=red>"+ data.errorMsg + "</font>");
				return;
			} else {
				$("#totalPlayer").html(data.total); // 总人数
				splitGroupUrl= "splitGroup.htm?eventsid="+eventsid;
				$("#dlg2").dialog("open").dialog("setTitle", "确定分组信息");
			}
		}
	});
}




function reserveSplitGroup(){
	$("#fmSpilt").form("submit",
			{
				url : splitGroupUrl,
				onSubmit : function() {
					return $(this).form("validate");
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						$.messager.alert('系统提示', "<font color=red>"+ result.errorMsg + "</font>");
						return;
					} else {
						$.messager.alert('系统提示', '分组成功');
						closeSpiltDialog();
						$("#dg").datagrid("reload");
					}
				}
	});
}

function closeSpiltDialog(){
	$("#fmSpilt").form('clear');
	$("#dlg2").dialog("close");
}

function deleteGroup(){
	var eventsid  =  $('#s_eventsid').combobox("getValue");
	if(eventsid==null || eventsid==''){
		$.messager.alert('系统提示', "请选择一个项目");
		return;
	}
	$.messager.confirm("系统提示", "您确认要取消该项目分组吗？", function(r) {
		if (r) {
			$.post("deleteGroup.htm", {
				eventsid : eventsid
			}, function(result) {
				if (result.success) {
					$.messager.alert('系统提示', "您已成功删除该项目分组！");
				} else {
					$.messager.alert('系统提示', result.errorMsg);
				}
			}, "json");
		}
	});
}



function searchEnroll() {
	$('#dg').datagrid('load', {
		keyword : $('#s_keyword').val(),
		eventsid : $('#s_eventsid').combobox("getValue")
	});
}


$(function() {
	var relation_id_sign = 0;
	$("#s_eventsid").combobox({
		url : path + '/events/eventsCombobox.htm',
		method : 'post',
		valueField : 'id',
		textField : 'name',
		editable : false,
		panelHeight : 'auto',
		onLoadSuccess : function() {
			if (relation_id_sign == 0) {
				var data = $(this).combobox('getData');
				data.unshift({
					'id' : '',
					'name' : '-----全部-----'
				});
				relation_id_sign++;
				$("#s_eventsid").combobox("loadData", data);//重新加载数据，且当 relation_id_sign==1时加载
			}
		}
	});
});



function openEnrollAddDialog(){
	var relation_id_sign = 0;
	var sex = $("#sex").val();
	$("#eventsid").combobox({
		url : path + '/events/eventsCombobox.htm?sex='+sex,
		method : 'post',
		valueField : 'id',
		textField : 'name',
		editable : false,
		panelHeight : 'auto'
	});
	$("#dlg").dialog("open").dialog("setTitle", "报名");
}



function closeEnrollDialog(){
	$("#fm").form('clear');
	$("#dlg").dialog("close");
}


function reserveEnroll(){
	$("#fm").form("submit",
			{
				url : "addEnroll.htm",
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
						closeEnrollDialog();
						$("#dg").datagrid("reload");
					}
				}
	});
}





var achieveUrl = "";
function openAchieveDialog(){
	var selectedRows = $("#dg").datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条要编辑的数据！');
		return;
	}
	var row = selectedRows[0];
	var yusai = row.events.yusai;  //是否有预赛
	var yscore = row.yscore; // 预赛成绩
	var jscore = row.jscore; // 决赛成绩
	$("#dlgAchieve").dialog("open").dialog("setTitle", "成绩管理");
	var str = "";
	if("是"==yusai){
		str += "<tr><td>预赛成绩</td><td>";
		if(yscore!=null && yscore!='' && yscore!="null"){
			str += (yscore+"</td></tr>");
		} else {
			str += ("<input  name='yscore'  width='120px'  /></td></tr>");
		}
	}
	str += "<tr><td>决赛成绩</td><td>";
	if(jscore!=null && jscore!='' && jscore!="null"){
		str += (jscore+"</td></tr>");
	} else{
		str += ("<input  name='jscore'  width='120px'  /></td></tr>");
	}
	$("#tableAchieve").html(str);
	achieveUrl = "reserveAchieve.htm?id="+row.id+"&yusai="+yusai
	+"&record="+row.events.record+"&rtype="+row.events.rtype+"&eventsid="+row.events.id;
}

function reserveAchieve(){
	$("#fmAchieve").form("submit",
			{
				url : achieveUrl,
				onSubmit : function() {
					return $(this).form("validate");
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						$.messager.alert('系统提示', "<font color=red>"+ result.errorMsg + "</font>");
						return;
					} else {
						$.messager.alert('系统提示', result.other);
						closeAchieveDialog();
						$("#dg").datagrid("reload");
					}
				}
	});
}


function closeAchieveDialog(){
		$("#fmAchieve").form('clear');
		$("#dlgAchieve").dialog("close");
}