<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>员工列表</h2>
<table border="1" id="emplist">
<thead>
<td>ID</td><td>姓名</td><td>性别</td><td>入职时间</td><td>薪水</td><td>部门</td>
</thead>
<tbody></tbody>
</table>
</body>
<script type="text/javascript" src="/Maven/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON('/Maven/list.sw',{},function(data){
			for(var i=0;i<data.length;i++){
				var emp = data[i];
				$('<tr></tr>')
					.append( $('<td></td>').html(emp.eid)  )
			    	.append( $('<td></td>').html(emp.ename)  )
			    	.append( $('<td></td>').html(emp.sex)  )
			    	.append( $('<td></td>').html(emp.hire)  )
			   		.append( $('<td></td>').html(emp.sar)  )
			   		.append( $('<td></td>').html(emp.dept.dname)  )
			    	.appendTo('#emplist tbody');
			}
		});
	});
</script>
</html>
