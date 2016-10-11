<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
td { font-size: 12px }
th {
     font-size: 12px;
}
body {
	margin-left: 10px;
}
</style>

<script type="text/javascript">
	$(function(){
		$('#ff').form({
			success:function(data){
				$.messager.alert('提示', data);
			}
		});
		
	});
</script>
</head>
<body>
    <form id="ff" action="zk/saveData" method="post">
    <input type="hidden" value="${path}" name="path" />
    <input type="hidden" value="${cacheId}" name="cacheId" />
	<div>
		<table>
			<tr>
				<td><label >data：</label></td>
				<td>
					<textarea rows="20" cols="150" name="data">${data}
					</textarea>
				</td>
			</tr>
		</table>
		<table >
			<tr>
				<td><label >czxid：</label></td>
				<td>${czxid } &nbsp;</td>

				<td><label >mzxid：</label></td>
				<td>${mzxid } &nbsp;</td>

				<td><label >ctime：</label></td>
				<td>${ctime } &nbsp;</td>

				<td><label >mtime：</label></td>
				<td>${mtime } &nbsp;</td>

				<td><label >version：</label></td>
				<td>${version } &nbsp;</td>

				<td><label >cversion：</label></td>
				<td>${cversion } &nbsp;</td>

			</tr>
		</table>
		<table>
			<tr>
				<td><label >aversion：</label></td>
				<td>${aversion } &nbsp;</td>

				<td><label >ephemeralOwner：</label></td>
				<td>${ephemeralOwner } &nbsp;</td>

				<td><label >dataLength：</label></td>
				<td>${dataLength } &nbsp;</td>

				<td><label >numChildren：</label></td>
				<td>${numChildren } &nbsp;</td>

				<td><label >pzxid：</label></td>
				<td>${pzxid } &nbsp;</td>
			</tr>
		</table>
		<table>
				<c:forEach items="${acls }" var="acl">
					<tr>
						<td><label >scheme</label></td>
						<td>${acl.scheme } &nbsp;</td>

						<td><label >id</label></td>
						<td>${acl.id } &nbsp;</td>

						<td><label >perms</label></td>
						<td>${acl.perms } &nbsp;</td>
					</tr>

				</c:forEach>
		</table>
	</div>
	<br/>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="javascript:$('#ff').submit();">保存</a>
	</form>
	<%-- 	${data } ${czxid } ${mzxid } ${ctime } ${mtime } ${version } ${cversion
	} ${aversion } ${ephemeralOwner } ${dataLength } ${numChildren }
	${pzxid } --%>

</body>
</html>