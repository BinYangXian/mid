<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
   
</head>
<body>
<h1>模拟百度的ajax关键字查找</h1>
<form action="loginServlet?mark=login" method="post"  >
    <table id="tabId">
        <tr>
            <td><input type="text" onkeyup="test(this.value)" ></td>
            <td><input type="submit" value="搜索一下" ></td>
        </tr>
    </table>
</form>
</body>
 <script type="text/javascript">
        var tab=document.getElementById("tabId");
        var lastArrLen=0;
        function test(value){
            var request;
            if(window.XMLHttpRequest){
                request=new XMLHttpRequest();
            }else if(window.ActiveXObject){
                request=new ActiveXObject("Msxml2.XMLHTTP");
            }
            request.open("post","ajaxServlet2?"+new Date().getTime(),true);
            request.onreadystatechange=function(){


                //访问服务器
                //post方式传参 可以在url的后面
                //监听响应的状态
                //响应的状态
                var readyState=request.readyState;
                if(readyState==4){
                    //数据接收成功后的代码
                    //状态码
                    var status=request.status;
                    if(status==200){
                        /*  var div=document.getElementById("msgId");
                         //成功的时候获取数据    接收服务器write出来的字符串
                         var result=request.responseText;
                         div.innerHTML=result; */
                        var result=request.responseText;
                        var array=eval(result);
                        console.log(array);
                         for(var i=1;i<lastArrLen+1;i++){
                            tab.deleteRow(1);
                        }
                        lastArrLen=array.length;
                        for(var i=0;i<array.length;i++){
                            var newTr=tab.insertRow(tab.rows.length);
                            var chTd=newTr.insertCell(0);
                            chTd.innerHTML=array[i];
                        }
                    }else if(status==404){
                        alert("找不到服务器上的地址");
                    }else if(status==500){
                        alert("服务器内部程序错误");
                    }
                }else{
                    //数据接收中的代码
                }
            };



            //请求带的参数     send方法是 专门给post方式准备滴
            //如果要使用send传参数   必须在前面加一个请求头的编码格式   改成键值对      form表单的enctype默认值
            request.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            //alert("发送的参数为："+"uname="+value);
            request.send("searchWord="+value);
        }
    </script>
</html>