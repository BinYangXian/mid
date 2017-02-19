<%@page import="com.cdsxt.vo.Person"%>
<%@page import="com.cdsxt.vo.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setAttribute("a", "");
	request.setAttribute("b", " ");
	request.setAttribute("c", new ArrayList());
	request.setAttribute("d", new HashMap());
	
	request.setAttribute("m", 5);
	request.setAttribute("n", 10);
%>

${empty a}
<hr/>
${empty b}
<hr/>
${empty c}
<hr/>
${empty d}
<hr/>
<!-- 作用域中没有保存e   所以e取出的来的结果是null -->
${empty e}

<hr/>
<!-- el表达式的数学运算 -->
${m }+${n }
<hr/>
${m+n }
<hr/>
<!-- 除法有小数 -->
${m/n }
<hr/>
${m>n?"m大于n":"m小于等于n" }
<hr/>
<!-- el表达式没有字符串的拼接  遇上加号 必定是数学的加法运算 -->
${"100"+200 }
<hr/>
<!-- 注释el表达式必须使用  jsp的注释 -->
<%-- ${"100abc"+200 } --%>


