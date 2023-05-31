<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>成绩报名</title>
   	<script type="text/javascript" src="${path }/js/games/enroll.js"></script>
    </head>
 
 
<body style="margin:1px">

<!-- 加载数据表格 -->
<table  id="dg" class="easyui-datagrid" fitColumns="true"
   				 pagination="true" rownumbers="true" url="enrollList.htm" fit="true" toolbar="#tb">
        <thead>
            	<tr>
            		<th data-options="field:'ck',checkbox:true"></th>
                	<th data-options="fidel:'id',hidden:'true'">编号</th>
                	<th field="eName"    width="60" align="center"  formatter="formatEName">名称</th>
                	<th field="pName"        width="60" align="center"  formatter="formatPName">姓名</th>
                	<th field="pSex"      width="60" align="center"  formatter="formatPSex">性别</th>
                	<th field="pDept"  width="60" align="center" formatter="formatPDept">班级</th>
                	<th field="pCode"    width="60" align="center" formatter="formatPCode">学号</th>
                	<th field="yscore"    width="60" align="center" >初赛成绩</th>
                	<th field="jscore"    width="60" align="center" >决赛成绩</th>
            	</tr>
        </thead>
        <script>
        	function formatEName(value,row,index){
        		return row.events.name;
        	}
        	function formatPName(value,row,index){
        		return row.player.realName;
        	}
        	function formatPSex(value,row,index){
        		return row.player.sex;
        	}
        	function formatPDept(value,row,index){
        		return row.player.dept;
        	}
        	function formatPCode(value,row,index){
        		return row.player.code;
        	}
        </script>
</table>
    	
<!-- 数据表格上的搜索和添加等操作按钮 -->
<div id="tb" >
	<div class="updownInterval"> </div>
	<div>
		&nbsp;姓名：&nbsp;<input type="text" name="s_keyword" id="s_keyword" size="20" onkeydown="if(event.keyCode==13) searchEnroll()"/>
		&nbsp;项目：&nbsp;<input class="easyui-combobox" id="s_eventsid"   />
		<a href="javascript:searchEnroll()" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
		&nbsp;&nbsp;
		<a href="javascript:splitGroup()" class="easyui-linkbutton" iconCls="icon-edit" >一键分组</a>&nbsp;
		<a href="javascript:deleteGroup()" class="easyui-linkbutton" iconCls="icon-edit" >取消分组</a>&nbsp;&nbsp;&nbsp;
		<a href="javascript:openAchieveDialog()" class="easyui-linkbutton" iconCls="icon-edit" >成绩管理</a>
		
	</div>
	<div class="updownInterval"> </div>
</div>


<div id="dlg2" class="easyui-dialog" style="text-align:right;width: 620px;height: 320px;padding: 10px 20px"
  closed="true" buttons="#dlg-buttons">
 <form id="fmSpilt" method="post">
 	<table cellspacing="5px;">
  		<tr>
  			<td>该项目总人数：</td>
  			<td id="totalPlayer"   ></td>
  		</tr>	
  		
  		<tr>
  			<td>每组人数：</td>
  			<td><input  name="playerPerGroup"  type="number"   name="playerPerGroup"  /></td>
  		</tr>	
  	</table>
 </form>
</div>
<div id="dlg-buttons" style="text-align:center">
	<a href="javascript:reserveSplitGroup()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	<a href="javascript:closeSpiltDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>










<div id="dlgAchieve" class="easyui-dialog" style="text-align:right;width: 620px;height: 320px;padding: 10px 20px"
  closed="true" buttons="#dlg2-buttons">
 <form id="fmAchieve" method="post">
 	<table cellspacing="5px;"  id="tableAchieve">
  			
  	</table>
 </form>
</div>
<div id="dlg2-buttons" style="text-align:center">
	<a href="javascript:reserveAchieve()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	<a href="javascript:closeAchieveDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>





</body>
</html>
