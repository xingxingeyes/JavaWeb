<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%-- 静态包含 base标签，css样式，JQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

		$(function () {
			$("a.deleteItem").click(function () {
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗？")
			});

			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗？")
			});
			// 给输入框绑定内容发生改变事件
			$(".updateCount").change(function () {
				var name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				var bookId = $(this).attr('bookId');
				if(confirm("你确定要将【"+name+"】商品数量修改为【"+count+"】吗")){
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&id="+bookId+"&count="+count;
				} else {
					// this.defaultValue属性是表单项dom对象的属性。它表示默认的value属性值
					this.value = this.defaultValue;
				}
			});



		});



	</script>

</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<%-- 静态包含 登录成功之后的菜单--%>
				<%@include file="/pages/common/login_success_menu.jsp"%>
			</div>
	</div>

	<div id="main">

		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
            <c:if test="${empty sessionScope.cart.items}">
                <tr>
                    <td colspan="5"><a href="index.jsp"> 亲，当前购物车为空！快去浏览吧</a></td>
                </tr>
            </c:if>
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>
						<input class="updateCount" type="text" style="width: 80px"
							   bookId="${entry.value.id}"
							   value="${entry.value.count}" >
					</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>

		</table>

		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	</div>

	<%-- 静态包含页脚内容 --%>
	<%@include file="/pages/common/footer.jsp"%>>
</body>
</html>