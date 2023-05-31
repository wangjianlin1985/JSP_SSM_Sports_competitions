<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>公告主页</title>
   	<script type="text/javascript" src="${path }/js/games/notice.js"></script>
    </head>
 
 
<body style="margin:1px">

<!-- 加载数据表格 -->
<table  id="dg" class="easyui-datagrid" fitColumns="true"
   				 pagination="true" rownumbers="true" url="noticeList.htm" fit="true" toolbar="#tb">
        <thead>
            	<tr>
            		<th data-options="field:'ck',checkbox:true"></th>
                	<th data-options="fidel:'id',hidden:'true'">编号</th>
                	<th field="title"    width="60" align="center" formatter="formatTitle">标题</th>
                	<th field="time"        width="60" align="center">时间</th>
            	</tr>
        </thead>
        <script>
        	function formatTitle(value,row,index){
        		return "<a javascript:void(0) onclick='openNotice(\""+row.id+"\")'>"+value+"</a>";
        	}
        	
        	function openNotice(id){
        		window.open("findOne.htm?id="+id);
        	}
        </script>
</table>
    	
<!-- 数据表格上的搜索和添加等操作按钮 -->
<div id="tb" >
	<div class="updownInterval"> </div>
	<div>
		<privilege:operation operationId="bcf6874ab5c442149a65b0f719fa7e" clazz="easyui-linkbutton" onClick="openNoticeAddDialog()" name="添加"  iconCls="icon-add" ></privilege:operation>
		<privilege:operation operationId="8aec801cdb61401db99972710f8469" clazz="easyui-linkbutton" onClick="openNoticeUpdateDialog()" name="修改"  iconCls="icon-edit" ></privilege:operation>
		<privilege:operation operationId="2af6d42e4cd24a829baf683ebb4467" clazz="easyui-linkbutton" onClick="deleteNotice()()" name="删除"  iconCls="icon-remove" ></privilege:operation>
	</div>
	<div class="updownInterval"> </div>
	<div>
		&nbsp;标题：&nbsp;<input type="text" name="s_title" id="s_title" size="20" onkeydown="if(event.keyCode==13) searchNotice()"/>
		<a href="javascript:searchNotice()" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
	</div>
	<div class="updownInterval"> </div>
</div>




<div id="dlg" class="easyui-dialog" style="text-align:right;width: 820px;height: 520px;padding: 10px 20px"
  closed="true" buttons="#dlg-buttons">
 <form id="fm" method="post">
 	<table cellspacing="5px;">
 		<tr>
  			<td><a href="javascript:reserveNotice()" class="easyui-linkbutton" iconCls="icon-ok">保存</a></td>
  			<td ><a href="javascript:closeNoticeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a></td>
  		</tr>
  		<tr>
  			<td>标题：</td>
  			<td ><input type="text" id="title" name="title" class="easyui-validatebox" required="true"/></td>
  		</tr>
  		<tr>
  			<td>内容：</td>
  			<td  style="width:600px;"><script id="container" name="content" type="text/plain" />  </td>
  		</tr>
  		
	
  	</table>
 </form>
</div>

</body>
</html>
