<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
    var lastArrLen=0;
            //页面加载的时候 通过ajax获取员工信息
        function getEmps(className){
            var tab1=document.getElementById("tab1");
            var request;
            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }else if(window.ActiveXObject){
                request=new ActiveXObject("Msxml2.XMLHTTP");
            }

            request.open("get","employeeServlet?className="+className+"&"+new Date());

            request.onreadystatechange=function(){
                var readyState=request.readyState;
                if(readyState==4){
                    var status=request.status;
                    if(status==200){
                        //[{},{},{}]
                        var data=request.responseText;
                        eval("var empArray="+data);
                          for(var i=2;i<lastArrLen+2;i++){
                            tab1.deleteRow(2);
                        }
                        lastArrLen=empArray.length;
                        for(var i=0;i<empArray.length;i++){
                            //在表格最后一行添加
                            var newTr=tab1.insertRow(tab1.rows.length);
                            newTr.insertCell(0).innerHTML=empArray[i].id;
                            newTr.insertCell(1).innerHTML=empArray[i].name;
                            newTr.insertCell(2).innerHTML=empArray[i].age;
                            newTr.insertCell(3).innerHTML=empArray[i].className;
                        }
                    }
                }
            };
            request.send(null);
        }

    </script>
</head>
<body onload="getEmps(1)">
<h4>欢迎管理者${manager }，使用本系统。</h4>
<hr/>
<div>
    <a href="javascript:void(0);" onclick="getEmps(1);">一班</a>
    <a href="javascript:void(0);" onclick="getEmps(2);">二班</a>
    <a href="javascript:void(0);" onclick="getEmps(3);">三班</a>
</div>
<table border="1" width="80%" align="center" id="tab1">
    <tr>
        <th colspan="5">
            <h1>学生信息</h1>
        </th>
    </tr>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>班级</th>
    </tr>
</table>
</body>
</html>