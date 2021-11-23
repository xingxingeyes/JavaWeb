<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <%-- 静态包含 base标签，css样式，JQuery文件--%>
  <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">

        $(function () {
            $("#sub_btn").click(function () {
                var usernameText = $("#username").val();
                var usernamePatt = /^\w{5,12}$/;

                if (!usernamePatt.test(usernameText)) {
                    $(".errorMsg").text("用户名不合法");
                    return false;
                }

                var passwordText = $("#password").val();
                var passwordPatt = /^\w{5,12}$/;

                if (!passwordPatt.test(passwordText)) {
                    $(".errorMsg").text("密码不合法");
                    return false;
                }

                // 确认密码
                var repwd = $("#repwd").val();
                if (repwd != passwordText) {
                    $(".errorMsg").text("密码不相同");
                    return false;
                }

                // 电子邮箱
                var emailText = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(emailText)) {
                    $(".errorMsg").text("邮箱不合法");
                    return false;
                }

                var codeText = $("#code").val();
                // 去空格
                var codeTextTrim = $.trim(codeText);
                if (codeTextTrim == "" || codeTextTrim == null) {
                    $(".errorMsg").text("验证码不合法");
                    return false;
                }

                $(".errorMsg").text("");
            });


            // 给验证码的图片，绑定单击事件
            $("#code_img").click(function () {
                // 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应的dom对象
                // src属性表示验证码img标签的图片路径。它可读，可写
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });



        });


    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        ${ requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <!--                    <form action="regist_success.jsp">-->
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 110px; height:35px; ">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%-- 静态包含页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>