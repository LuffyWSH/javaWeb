<%--
  Created by IntelliJ IDEA.
  User: wushuhong
  Date: 2023/4/8
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <%--表单校验--%>
    <script>
        window.onload=function (){
        //获取表单
        var form = document.getElementById("form");
        //给表单绑定事件
        form.onsubmit=submit;
        function submit(){
            if(!(check_name() && check_age() && check_qq() && check_email())){
                form.action="#";
            }
        }
        //获取姓名
        var name = document.getElementsByName("name")[0];
        //绑定事件
        name.onblur=check_name;
        //定义函数
        function check_name(){
            //判断
            var flag_name = name.value.match("[a-zA-Z]{1}[a-zA-Z\\s]{0,20}[a-zA-Z]{1}");
            //获取span，展示判断结果
            var name_span = document.getElementById("name_flag");
            if(flag_name){ //若结果为真，显示打勾图片
                name_span.innerHTML="<img width='25' height='35' src='img/gou.png'>";
            }else {//若结果为真，显示格式有误
                name_span.innerHTML="<font size='1' color='red'>格式有误</font>"
            }
            return flag_name;
        }

        //获取年龄
        var age = document.getElementsByName("age")[0];
        //绑定事件
        age.onblur=check_age;
        //定义函数
        function check_age(){
            //判断
            var flag_age=false;
           if(age.value>0 & age.value<130){
                flag_age=true;
           }
            //获取span，展示判断结果
            var age_span = document.getElementById("age_flag");
            if(flag_age){ //若结果为真，显示打勾图片
                age_span.innerHTML="<img width='25' height='35' src='img/gou.png'>";
            }else {//若结果为真，显示格式有误
                age_span.innerHTML="<font size='1' color='red'>格式有误</font>"
            }
            return flag_age;
        }

            //获取qq
            var qq = document.getElementsByName("qq")[0];
            //绑定事件
            qq.onblur=check_qq;
            //定义函数
            function check_qq(){
                //获取内容
                var flag_qq = qq.value.match("[1-9][0-9]{4,10}");
                //获取span
                var qq_span = document.getElementById("qq_flag");
                if(flag_qq){
                    qq_span.innerHTML="<img width='25' height='35' src='img/gou.png'>";
                }else {
                    qq_span.innerHTML="<font size='1' color='red'>格式有误</font>"
                }
                return flag_qq;
            }

        //获取Email
        var email = document.getElementsByName("email")[0];
        //绑定事件
        email.onblur=check_email;
        //定义函数
        function check_email(){
            //获取内容
            var flag_email = email.value.match("[\\w]+@[a-zA-Z0-9]{2,4}.[a-zA-Z]{2,4}");
            //获取span
            var email_span = document.getElementById("email_flag");
            if(flag_email){
                email_span.innerHTML="<img width='25' height='35' src='img/gou.png'>";
            }else {
                email_span.innerHTML="<font size='1' color='red'>格式有误</font>"
            }
            return flag_email;
        }
    }
    </script>

</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/Servlet_Add" method="post" id="form">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            <span id="name_flag"></span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            <span id="age_flag"></span>
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="jiguan">
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码"/>
            <span id="qq_flag"></span>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
            <span id="email_flag"></span>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>