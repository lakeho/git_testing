

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="stylesheet" href="cssCustomer.css">
        <script src="scriptcode.js"></script>
    </head>
    <body>
        <div id=wrapper>
            <div id=header>
                <div id=topmenu>
                    
                    <ul>
                            <li><a href="homep">TRANG CHỦ</a></li>
                            <li><a href="fastfood">FASTFOOD</a></li>
                            <li><a href="beverage">ĐỒ UỐNG</a></li>
                            <li><a href="cart">GIỎ HÀNG</a></li>
                    </ul>

                    <form id=search action="Search" method="post">
                            <input id=oo type="text" name="txtSearch" required="" placeholder="  TÌM KIẾM SẢN PHẨM ...">

                            <button id="ss" name="search">Tìm kiếm</button>
                    </form>
                    
                    <% if(session.getAttribute("USER")==null){ %>
                        <a href="register" class="sess">Đăng ký</a>
                        <a href="login" class="sess">Đăng nhập</a>
                    <% }else{ %>
                        <a href="logout" class="sess">Đăng xuất</a>
                        <a href="customerInfo" class="sess"><%=session.getAttribute("USER")%></a>
                    <%}%>
                    
                </div>
                <img id=headpic src="images/h1.jpg" alt="">
            </div>
		
            <div id=center>
                <div id=innerCen>
                    
                    <div id="info">
                        <form action="changepass">
                            <b>Đổi mật khẩu</b><br/><br/>
                            <p style='color:red'>${error}</p>
                            Mật khẩu cũ: <input type="password" name="txtpasscu" value=""/><br/><br/>
                            Mật khẩu mới: <input type="password" name="txtpassmoi" value=""/><br/><br/>
                            Xác nhận : <input type="password" name="txtxacnhan" value=""/><br/><br/>
                            <button id="nut" name="update">Change password</button><br/><br/>
                        </form>
                    </div>
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

