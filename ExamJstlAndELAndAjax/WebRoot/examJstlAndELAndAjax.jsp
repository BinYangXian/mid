<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="jsUtil.js"></script>
		<script src="ajaxUtil.js"></script>
	</head>
	<body>
		<table  width="100%" height="10%"  border = "1"  >
			<tr>
				<td align="center"  >
					<input type="button"  value="删除"   onclick="delRow();"  >
				</td>
				<td align="center"  colspan="5">
					弹性预算规则：<input type="button"  value="添加"  onclick="addRow();"    >
				</td>
            </tr>
			<tr>
				<table   id="table1" width="100%" height="100%"  border = "1"  >
					<tr id="tr0" >
						<td align="center"  >&nbsp;
						</td>
						<th align="center"  >编码</th>
						<th align="center"  >弹性计算规则</th>	
						<th align="center"  >摘要</th>
						<th align="center"  >参数</th>
						<th align="center"  >说明</th>
					</tr>
					<c:forEach items="${ruleList}" var="li">
					<tr  id="tr1">
						<td align="center"  >
                            保存/编辑<input type="checkbox"   name="cb1" value="111"  onclick="chaValue(this);" >
						</td>
						<td align="center"  >${li.id }</td>
						<td align="center"  >${li.rule }</td>	
						<td align="center"  >${li.summary }</td>
						<td align="center"  >${li.param }</td>
						<td align="center"  >${li.info }</td>
					</tr>
					</c:forEach>
				</table>		
			</tr>
		</table>
	</body>
	<script>
			//删除按钮  点击删除 删除选中行
			//添加按钮  点击添加 添加一行  第一个是选中状态的checkbox    后面每列是空的普通文本框
			//点击页面的checkbox如果  是选中  则后面列的值变为可修改状态(将值放入文本框)  如果没有选中  将文本框中的值 存入td变为不可修改状态

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
				chTd.innerHTML="<input type='checkbox' name='cb1' checked onclick='chaValue(this);' />";
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
						chObj.parentNode.parentNode.cells[i].innerHTML="保存/编辑<input type='text'  value='"+val+"'/>";
					}
				}else{
				var arr=[];
					for(var i=1;i<chObj.parentNode.parentNode.cells.length;i++){
						var val=getChildNodes(chObj.parentNode.parentNode.cells[i])[0].value;
						arr.push(val);
						chObj.parentNode.parentNode.cells[i].innerHTML=val;
					}
					var sendParam="chaData="+"{"+"'id':'"+arr[0]+"',"+"'rule':'"+arr[1]+"',"+"'summary':'"+arr[2]
					+"',"+"'param':'"+arr[3]+"',"+"'info':'"+arr[4]+"'}";
					ajax("post","rulePageServlet","saveTag=change&"+sendParam,function(data){
							eval("var stusArray="+data)
						})
				}
			}
		</script>
</html>
