<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <body>
    <h1>员工管理系统</h1>
    ${msg }
     <form action="loginServlet?mark=login" method="post"  >
        <table>
            <tr>
                <th>用户名：</th>
                <th><input type="text" name="uname"/></th>
            </tr>
            <tr>
                <th>密码：</th>
                <th><input type="password" name="pwd" /></th>
            </tr>
            <tr>
                <th>&nbsp;&nbsp;&nbsp;</th>
                <td><input type="submit" value="登陆" >&nbsp;&nbsp;<input type="reset" /></td>
            </tr>
        </table>
    </form>
  </body>
</html>
