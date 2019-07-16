<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<title>用户信息修改</title>

<div id="ChangePassWdDiv">
    <form class="loginForm" action="forechangePassWd" method="post">
        <div id="loginSmallDiv" class="loginSmallDiv">
            <div class="login_acount_text">用户信息修改</div>

            <div class="loginInput" >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
                <input id="password" name="password" type="password" placeholder="新密码" type="text">
            </div>

            <a>保存信息后需要重新登录</a>
            <div style="margin-top:20px">
                <button class="btn btn-block redButton" type="submit">确定</button>
            </div>
        </div>
    </form>
</div>