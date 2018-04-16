<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/11
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 分页 template</title>

    <!-- Bootstrap -->
    <link href="<%=path%>/resources/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=path%>/resources/jquery/jquery-2.2.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=path%>/resources/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <script src="<%=path%>/resources/bootstrap/js/extendPagination.js"></script>
</head>
<body>
<div id="callBackPagination" class="piece">
    <h2> <small>扩展分页带回调函数(表格带分页)</small> </h2>
    <form role="form" action="#">
        <div class="form-group">
            <label for="totalCount">总数</label>
            <input type="text" class="form-control" id="totalCount" placeholder="请输入总数">
            <label for="showCount">展示选项数</label>
            <input type="text" class="form-control" id="showCount" placeholder="请输入分页栏展示数(默认10)">
            <label for="limit">每页显示数据量</label>
            <input type="text" class="form-control" id="limit" placeholder="请输入每页显示数据量(默认10)">
        </div>
        <button type="submit" onclick="callBackPagination();" class="btn btn-default">提交</button>
    </form>
    <div id="mainContent"></div>
    <div id="callBackPager"></div>
</div>
</body>
<script type="text/javascript">
    var shuju;
    function callBackPagination() {

        var totalCount = Number($('#totalCount').val()) || 252, showCount = $('#showCount').val(),

            limit = Number($('#limit').val()) || 10;
        var totalCount,limit;
        $.ajax({
            type: "POST",
            url: "<%=path%>/test/shop/shopList",
            // data: {username:$("#username").val(), content:$("#content").val()},
            dataType: "json",
            async:false,
            success: function(data){
                shuju=data;
            }
        });

        createTable(1, shuju.size, shuju.total);
        $('#callBackPager').extendPagination({

            totalCount: shuju.total,

            showCount: 5,

            limit: shuju.size,

            callback: function (curr, limit, totalCount) {
                console.log("当前页面:"+curr);
                $.ajax({
                    type: "POST",
                    url: "<%=path%>/test/shop/shopList",
                    data: {current:curr},
                    dataType: "json",
                    async:false,
                    success: function(data){
                        shuju=data;
                    }
                });
                createTable(curr, limit, totalCount);


            }

        });

    }

    function createTable(currPage, limit, total) {
        var html = [], showNum = limit;
       console.log(showNum+">>"+total+">>>"+currPage);
        if (total - (currPage * limit) < 0) showNum = total - ((currPage - 1) * limit);

        html.push(' <table class="table table-hover piece" style="margin-left: 0;">');

        html.push(' <caption>悬停表格(' + total + ')</caption>');

        html.push(' <thead><tr><th>名称</th><th>城市</th><th>密码</th></tr></thead><tbody>');

        for (var i = 1; i <= showNum; i++) {
            html.push('<tr><td>描述'+shuju.records[i-1].des +'</td>');

            html.push('<td>商品id' + shuju.records[i-1].id + 'id' + '</td>');

            html.push('<td>价格' + shuju.records[i-1].price + '元' + '</td>');

            html.push('</tr>');

        }

        html.push('</tbody></table>');

        var mainObj = $('#mainContent');

        mainObj.empty();

        mainObj.html(html.join(''));

    }

</script>







</body>
</html>

