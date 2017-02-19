
/**
 * 
 * @param method  请求方式
 * @param url  请求地址
 * @param params  参数  多个参数  键1=值1&键2=值2...
 * @param handle200  成功时候处理的函数
 * @param asyn  同步异步
 * @param loading    没有成功接受数据之前执行的函数
 * @param handle404  找不到页面执行的函数
 * @param handle500  服务器代码有问题的时候执行的函数
 */
function ajax(method,url,params,handle200,asyn,loading,handle404,handle500){
	url+="?"+new Date().getTime()
	if(method=="get"&&typeof params=="string" &&params){
		url+="&"+params;
	}
	var request;
	if(window.XMLHttpRequest){
		request=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		request=new ActiveXObject("Msxml2.XMLHTTP");
	}
	
	request.open(method,url,typeof asyn=="boolean"?asyn:true);
	
	request.onreadystatechange=function(){
		var readyState=request.readyState;
		if(readyState==4){
			var status=request.status;
			if(status==200){
				var data=request.responseText;
				if(typeof handle200=="function"){
					handle200(data);
				}
			}else if(status==404){
				if(typeof handle404=="function"){
					handle404();
				}
			}else if(status==500){
				if(typeof handle500=="function"){
					handle500();
				}
			}
		}else{
			//准备过程中执行的代码
			if(typeof loading=="function"){
				loading();
			}
		}
	};
	if("post"==method){
		request.setRequestHeader("content-type","application/x-www-form-urlencoded" );
		request.send(params);
	}else{
		request.send(null);
	}
}