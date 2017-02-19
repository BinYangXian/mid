<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'empAge.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="getAgeArea()">
    <div id="main" style="width: 600px;height:400px;"></div>
  </body>
</html>
<script src="ajaxUtil.js" ></script>
<script src="echarts.js" ></script>
<script type="text/javascript">

	function getAgeArea(){
		// 基于准备好的dom，初始化echarts实例
	    var myChart = echarts.init(document.getElementById('main'));

	    // 指定图表的配置项和数据
	    var option = {
	        title: {
	            text: '年龄分布图'
	        },
	        tooltip: {},
	        legend: {
	            data:['年龄']
	        },
	        xAxis: {
	            data: []
	        },
	        yAxis: {},
	        series: [{
	            name: '年龄',
	            type: 'bar',
	            data: []
	        }]
	    };
	    ajax("get","employeeServlet","mark=queryAgeArea",function(data){
	    	eval("var ageArray="+data);
	    	for(var i=0;i<ageArray.length;i++){
	    		var ageArea=ageArray[i].ageArea;
	    		var count=ageArray[i].count;
	    		option.xAxis.data.push(ageArea);
	    		option.series[0].data.push(count);
	    	}
	    	//给报表添加事件
	    	myChart.on('click', function (params) {
	    	    window.open("employeeServlet?mark=queryByAge&ageArea="+params.name,"newWindow");
	    	});
		    // 使用刚指定的配置项和数据显示图表。
		    myChart.setOption(option);
	    });
	}
    
</script>