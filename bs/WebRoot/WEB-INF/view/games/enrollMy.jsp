<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>项目主页</title>
   	<script type="text/javascript" src="${path }/js/games/enroll.js"></script>
    </head>
 
 
<body style="margin:1px">

<!-- 加载数据表格 -->
<table  id="dg" class="easyui-datagrid" fitColumns="true"
   				 pagination="true" rownumbers="true" url="enrollMyList.htm" fit="true" toolbar="#tb">
        <thead>
            	<tr>
            		<th data-options="field:'ck',checkbox:true"></th>
                	<th data-options="fidel:'id',hidden:'true'">编号</th>
                	<th field="eName"    width="60" align="center"  formatter="formatEName">名称</th>
                	<th field="type"    width="60" align="center"  formatter="formatEType">类型</th>
            	</tr>
        </thead>
        <script>
        	function formatEName(value,row,index){
        		return row.events.name;
        	}
        	
        	function formatEType(value,row,index){
        		return row.events.type;
        	}
        </script>
</table>

<div id="tb" >
	<div class="updownInterval"> </div>
	<div>
		<a href="javascript:openEnrollAddDialog()" class="easyui-linkbutton" iconCls="icon-add" >我要报名</a>
	</div>
	<div class="updownInterval"> </div>
</div>

<input  type="hidden"  id="sex"  value="${sex }"  />


<!-- 新增和修改对话框 -->
<div id="dlg" class="easyui-dialog" style="text-align:right;width: 620px;height: 320px;padding: 10px 20px"
  closed="true" buttons="#dlg-buttons">
 <form id="fm" method="post">
 	<table cellspacing="5px;">
  		<tr>
  			<td>项目：</td>
  			<td>
  				<input class="easyui-combobox"  id="eventsid"  name="eventsid" >
  			</td>
  		</tr>	
  	</table>
 </form>
</div>
<div id="dlg-buttons" style="text-align:center">
	<a href="javascript:reserveEnroll()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	<a href="javascript:closeEnrollDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

</body>
</html>
