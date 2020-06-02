

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="cart.css">
        <script src="scriptcode.js"></script>
    </head>
    <body>
        <div id=wrapper>
            <div id=header>
                <div id=topmenu>
                    
                    <ul>
                            <li><a href="home">TRANG CHỦ</a></li>
                            <li><a href="fastfood">FASTFOOD</a></li>
                            <li><a href="beverage">ĐỒ UỐNG</a></li>
                            <li><a href="cart">GIỎ HÀNG</a></li>
                    </ul>

                    <form id=search action="Search" method="post">
                            <input id=oo type="text" name="txtSearch" required="" placeholder="  TÌM KIẾM SẢN PHẨM ...">

                            <button id="ss" name="search">Tìm kiếm</button>
                    </form>
                    <% if(session.getAttribute("USER")==null){ %>
                        <a href="register.jsp" class="sess">Đăng ký</a>
                        <a href="login.jsp" class="sess">Đăng nhập</a>
                    <% }else{ %>
                        <a href="Controller?action=logout" class="sess">Đăng xuất</a>
                        <a href="customerInfo.jsp" class="sess"><%=session.getAttribute("USER")%></a>
                    <%}%>
                    
                </div>
                <img id=headpic src="images/h1.jpg" alt="">
            </div>
		
            <div id=center>
                <div id=innerCen>
                    <h1 style="margin-left: 155px;margin-top: 50px;">Giỏ hàng của bạn</h1>
                    <c:set var="shop" value="${cartList}"/>
                    <br/><br/>
                    <table border="1" style="text-align: center;" cellpadding="0" cellspacing="0">
                        <tr>
                            <th>STT</th>
                            <th id="sp">Sản phẩm</th>
                            <th>Số lượng</th>
                            <th id="gia">Đơn giá</th>
                            <th id="sum">Thành tiền</th>
                            <th id="del">Chức năng</th>
                        </tr>
                        <c:if test="${not empty shop}">
                            <c:set var="count" value="0"/>
                            <c:set var="totalSum" value="0"/>
                            <c:forEach var="rows" items="${shop}">
                                <form action="ItemDel">
                                    <c:set var="count" value="${count+1}"/>
                                    <c:set var="sumPlus" value="${rows.value.total}"/>
                                    <c:set var="totalSum" value="${totalSum+sumPlus}"/>
                                    <tr>
                                        <td>${count}</td>
                                        <td><img style="width: 195px;height: 146px;" src="${rows.value.sp.anh}"/><br/>
                                            ${rows.value.sp.tensp}
                                        </td>
                                        <td>
                                            <input style="width: 35px;" type="number" min="1" max="99" name="quantity" value="${rows.value.quantity}"/>
                                        </td>
                                        <td>${rows.value.sp.gia}đ</td>
                                        <td>${rows.value.total}đ</td>
                                        <td><button style="width: 70px;" name="delete">Xóa</button>
                                            <button style="width: 70px;" name="update">Cập nhật</button>
                                            <input type="hidden" name="hiddenDel" value="${rows.value.sp.masp}"/>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                            <tr>
                                <td colspan="4" style="height: 35px;"><b>Tổng tiền</b></td>
                                <td>${totalSum}đ</td>
                                <td></td>
                            </tr>
                        </c:if>
                    </table>
                    <br/><br/>
                    <a href="home">Tiếp tục mua hàng</a>
                    <a id="pay" href="">Thanh toán đơn hàng</a>
                </div>
            </div>
		
            <div id=footer>
                <p class="ft">Fastfood.com</p>
                <p class="ft">Copyright 1999-2019</p>
                <p class="ft">All right reserved</p>
            </div>
	</div>
    </body>
</html>
