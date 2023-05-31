<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>田径运动会管理系统</title>
    <script type="text/javascript" src="${path }/js/sys/main.js"></script>
  </head>
 
<body class="easyui-layout" >
<div region="north" style="height: 68px;">
<div style="padding: 0px;margin: 0px;background-color: #E0ECFF;">
<table>
	
	<tr>
		<td> <img src="${path }/images/mainlogo.png"/>
		</td>
		<td valign="bottom">欢迎：${currentUser.name }&nbsp;『${currentUser.roleName }』
			&nbsp;&nbsp;
			<a href="javascript:openPasswordUpdateDialog()" 	class="easyui-linkbutton" >修改密码</a>  
			&nbsp;&nbsp;
			<a href="javascript:logout()" 	class="easyui-linkbutton" >退出登陆</a>  
			&nbsp;&nbsp;
			<SPAN id="Clock"></SPAN>  
		</td>
	</tr>
	
	


</table>
</div>
</div>

<div region="center">
	<div class="easyui-tabs" fit="true" border="false" id="tabs" >
		<div  title="首页" data-options="iconCls:'icon-home'">
			
		
		</div>
	</div>
</div>


	

<div region="west" style="width: 160px;padding: 5px;" title="导航菜单" split="true">
<ul id="tree" class="easyui-tree"></ul>
</div>


<div region="south" style="height: 25px;padding: 5px;" align="center">
	田径运动会管理系统
</div>

<div id="dlg" class="easyui-dialog" style="width: 400px;height: 220px;padding: 10px 20px" 
 closed="true" buttons="#dlg-buttons" data-options="iconCls:'icon-modifyPassword'">
 <form id="fm" method="post">
 <input type="hidden" name="id" id="id" value="${currentUser.id }">
 	<table cellspacing="4px;" style="text-align:right">
 		<tr>
 			<td>用户名：</td>
 			<td><input type="text" name="name" id="name" readonly="readonly" value="${currentUser.name }" style="width: 200px;" /></td>
 		</tr>
 		<tr>
 			<td>原密码：</td>
 			<td><input type="password" class="easyui-validatebox" name="oldPassword" id="oldPassword" style="width: 200px;" required="true" /></td>
 		</tr>
 		<tr>
 			<td>新密码：</td>
 			<td><input type="password" class="easyui-validatebox" name="newPassword" id="newPassword" style="width: 200px;" required="true"  /></td>
 		</tr>
 		<tr>
 			<td>确认新密码：</td>
 			<td><input type="password" class="easyui-validatebox" name="newPassword2" id="newPassword2" style="width: 200px;" required="true" /></td>
 		</tr>
 	</table>
 </form>
</div>
<div id="dlg-buttons" style="text-align:center">
	<a href="javascript:updatePassword()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	<a href="javascript:closePasswordUpdateDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


<!-- 右键菜单 -->
<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabrefresh">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
</div>
	
			
		

</body>
</html>
