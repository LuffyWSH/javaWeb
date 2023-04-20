<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
        #left{
            float: left;
        }
        #right{
            float: right;
            margin-bottom: 8px;
        }
    </style>
    <script type="text/javascript">
        window.onload=function (){
            //获取第一个框
            var first_id = document.getElementById("uid_first");
            first_id.onclick=function (){
                //获取其他的uid
                var ids = document.getElementsByName("uid");
                //遍历
                for (let i = 0; i < ids.length; i++) {
                    ids[i].checked=this.checked;
                }
            }
        }

           function del(id){
               //用户安全提示
               if(confirm("您确认删除吗")){
                   //确认删除
                   location.href="${pageContext.request.contextPath}/Servlet_delete?id="+id
               }
           }

        function deleAll(){
            //用户安全提示
            if(confirm("您确认删除吗")){
                //判断表单里是否有数据被选中
                var ids = document.getElementsByName("uid");
                //定义一个标记
                var flag=false;
                //遍历
                for (let i = 0; i < ids.length; i++) {
                    if(ids[i].checked){
                        flag=true;
                        break;
                    }
                }
                //对标记进行判断
                if(flag){
                    //提交表单
                    document.getElementById("form").submit();
                }
            }
        }

    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div id="left">
        <form class="form-inline" action="${pageContext.request.contextPath}/Servlet_FindUserByPage" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="name" value="${parameterMap.name[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputAddr2">籍贯</label>
                <input type="text" class="form-control" id="exampleInputAddr2" name="address" value="${parameterMap.address[0]}">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2" name="email" value="${parameterMap.email[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div id="right">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:deleAll();" id="deleAll">删除选中</a>
    </div>
    <form action="${pageContext.request.contextPath}/Servlet_delete_select" method="post" id="form">
    <table border="1" class="table table-bordered table-hover" >
        <tr class="success">
            <th><input type="checkbox" id="uid_first"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pb.list}" var="li">
        <tr>
            <td><input type="checkbox" name="uid" value="${li.id}"></td>
            <td>${li.id}</td>
            <td>${li.name}</td>
            <td>${li.gender}</td>
            <td>${li.age}</td>
            <td>${li.address}</td>
            <td>${li.qq}</td>
            <td>${li.email}</td>
            <td>
                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/Servlet_update_show?id=${li.id}">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="javascript:del(${li.id});">删除</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                </c:if>
               <c:if test="${pb.currentPage != 1}">
                 <li>
               </c:if>
                    <a href="${pageContext.request.contextPath}/Servlet_FindUserByPage?currentPage=${pb.currentPage-1}&rows=5&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/Servlet_FindUserByPage?currentPage=${i}&rows=5&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage !=i}">
                        <li><a href="${pageContext.request.contextPath}/Servlet_FindUserByPage?currentPage=${i}&rows=5&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>
                    <c:if test="${pb.currentPage == pb.totalPage}">
                        <li class="disabled">
                    </c:if>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                        <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/Servlet_FindUserByPage?currentPage=${pb.currentPage+1}&rows=5&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 20px;margin-left: 5px">共${pb.totalCount}条记录，共${pb.totalPage}页，当前是第${pb.currentPage}页</span>
            </ul>
        </nav>
    </div>

</div>
</body>
</html>
