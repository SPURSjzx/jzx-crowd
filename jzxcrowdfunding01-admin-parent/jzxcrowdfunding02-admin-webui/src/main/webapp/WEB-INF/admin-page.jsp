<%--
  Created by IntelliJ IDEA.
  User: Jzxxxx
  Date: 2020/9/19
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="include-head.jsp" %>
<script src="jquery/jquery.pagination.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/pagination.css">
<script type="text/javascript">
    // 因为点击下一页是会重新发送一个请求 但是查询条件会消失 导致条件查询失败 所以我们需要讲keyword查出拼接到href中
    <%--var keyword = ${requestScope.pageInfo.keyword};--%>
    $(function () {
        <!--调用后面声明的函数对页码导航条进行初始化-->
        initPagination();
    });
    // 生成页码导航条的函数
    function  initPagination() {
        // 先从传入页面的pageInfo获取总记录数 即pageInfo.total
        var totalRecord = ${requestScope.pageInfo.total};
        // 声明一个JSON对象存储Pagination要设置的属性
        var properties = {
          // 边缘页数
          num_edge_entries: 3,
          // 主体页数
          num_display_entries: 5,
          // 回调函数
          callback: pageSelectCallback,
          // 每页要显示的数量
          items_per_page: ${requestScope.pageInfo.pageSize},
          // 当前页  因为pageInfo的页码从1开始 pagIntion的页码从0开始 所以需要-1
          current_page:${requestScope.pageInfo.pageNum -1},
          // 上下页按钮上面显示的文本
          prev_text: "上一页",
          next_text: "下一页"
        };
        // 生成页码导航条
        $("#Pagination").pagination(totalRecord,properties);
    }

    // 用户点击 页码 上下页 时调用这个函数实现页面跳转
    // page_index是pagIntation传给我们的，是从0开始的那个页码  不是pageInfo的从1开始的
    function pageSelectCallback (pageIndex,jQuery) {
         // 根据pageIndex计算得到pageNum
        var pageNum = pageIndex+1;
        // 跳转页面
        window.location.href="admin/get/page.html?pageNum="+pageNum+"&keyword"+keyword;
        // 由于每一个页码都是超链接 所以在这个函数最后取消超链接的默认行为
        // 去pagInation.js中将opts.callback(current_page,this)给注释了。否则会引起死循环;
        return false;
    }

</script>
<body>
<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form action="admin/get/page.html" method="post" class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input name="keyword" class="form-control has-success" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                    <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='add.html'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!--如果为空-->
                            <c:if test="${empty requestScope.pageInfo.list}">
                                <tr>
                                    <td colspan="6" align="center">抱歉！没有查询到数据！</td>
                                </tr>
                            </c:if>
                            <c:if test="${!empty requestScope.pageInfo.list}">
                                <!--进行遍历 利用varStatus="myStatus"可以生成连续的序号-->
                                <c:forEach items="${requestScope.pageInfo.list}"  varStatus="myStatus" var="admin">
                                    <tr>
                                        <!--不显示具体的ID 利用myStatus的计数器-->
                                        <td>${myStatus.count}</td>
                                        <td><input type="checkbox"></td>
                                        <td>${admin.loginAcct}</td>
                                        <td>${admin.userName}</td>
                                        <td>${admin.email}</td>
                                        <td>
                                            <button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>
                                            <button type="button" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>
                                            <button type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6" align="center">
                                    <!--原有的页码部分-->
<%--                                    <ul class="pagination">--%>
<%--                                        <li class="disabled"><a href="#">上一页</a></li>--%>
<%--                                        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>--%>
<%--                                        <li><a href="#">2</a></li>--%>
<%--                                        <li><a href="#">3</a></li>--%>
<%--                                        <li><a href="#">4</a></li>--%>
<%--                                        <li><a href="#">5</a></li>--%>
<%--                                        <li><a href="#">下一页</a></li>--%>
<%--                                    </ul>--%>
                                    <!--使用pagination代替后的代码 -->
                                    <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                                </td>
                            </tr>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
