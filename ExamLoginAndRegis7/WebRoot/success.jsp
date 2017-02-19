<%@ page language="java"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
<script src="jsUtil.js"></script>
<script src="ajaxUtil.js"></script>
  </head>
  
  <body>
    <h1>欢迎登陆本系统</h1>
    <hr/>
	 	
    		<table  width="100%" height="10%"  border = "1"  >
			<tr>
				<td align="center"  >
					<input type="button"  value="删除"   onclick="delRow();"  >
				</td>
				<td align="center"  colspan="5">
					员工管理：<input type="button"  value="添加"  onclick="addRow();"    >
				</td>
            </tr>
			<tr>
				<table   id="table1" width="100%" height="100%"  border = "1"  >
					<tr id="tr0" >
						<td align="center"  >&nbsp;
						</td>
						 <th>员工编号</th>
			    		 <th>员工姓名</th>
			    		 <th>员工职位</th>
					</tr>
					<c:forEach items="${empList}" var="i">
					<tr  id="tr1">
						<td align="center"  >
                            保存/编辑<input type="checkbox"   name="cb1" value="111"  onclick="chaValue(this);" >
						</td>
							<td align="center">${i.number }</td>
		    				<td align="center">${i.name }</td>
		    				<td align="center">${i.job }</td>
					</tr>
					</c:forEach>
				</table>		
			</tr>
		</table>
  </body>
  <script type="text/javascript">
  	//删除选中行
			function delRow(){
				var cbs=$("cb1");
	            var table1=$("#table1");
	            var arr=[];
	            //服务器删除选中行
	            for(var i=0;i<cbs.length;i++){
	                if(cbs[i].checked){
	                    arr.push(getFirstChild(getNextSibling(cbs[i].parentNode)).value);
	                }
	            }
	            var sendParam=arr.toString();
	            alert(sendParam);
	             ajax("post","rulePageServlet","saveTag=del&"+"delData="+sendParam,function(data){
	                eval("var stusArray="+data)
	            }) ;  

	            //页面删除选中行
	            for(var i=0;i<cbs.length;i++){
	                if(cbs[i].checked){
	                    table1.deleteRow(cbs[i].parentNode.parentNode.rowIndex);
	                    i--;
	                }
	            }
			}
  	//页面新添加一行
			function addRow(){
				var table1=$("#table1");
				var newTr=table1.insertRow(table1.rows.length);
				newTr.align="center";
				var chTd=newTr.insertCell(0);
				//偷懒的方式
				chTd.innerHTML="保存/编辑<input type='checkbox' name='cb1' checked onclick='chaValue(this);' />";
				for(var i=1;i<table1.rows[0].cells.length;i++){
					var newTd=newTr.insertCell(i);
					newTd.innerHTML="<input type='text' />";
				}
			}

			//如果是选中状态  则变为可输入   如果是非选中状态  则变为锁定
			function chaValue(chObj){
				if(chObj.checked){
					//利用for循环对每一个列进行操作
					for(var i=1;i<chObj.parentNode.parentNode.cells.length;i++){
						var val=chObj.parentNode.parentNode.cells[i].innerHTML;
						chObj.parentNode.parentNode.cells[i].innerHTML="<input type='text'  value='"+val+"'/>";
					}
				}else{
				var arr=[];
					for(var i=1;i<chObj.parentNode.parentNode.cells.length;i++){
						var val=getChildNodes(chObj.parentNode.parentNode.cells[i])[0].value;
						arr.push(val);
						chObj.parentNode.parentNode.cells[i].innerHTML=val;
					}
				 	var sendParam="chaData="+"{"+"'number':'"+arr[0].trim()+"',"+"'name':'"+arr[1].trim()+"',"+"'job':'"+arr[2].trim();
					ajax("post","rulePageServlet","saveTag=change&"+sendParam,function(data){
							eval("var stusArray="+data)
						}) ;
				}
			}
  </script>
</html>