

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="login.css">
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
                    <div id=logbox>
                        <form id="login" action="signin"> <!--FORM DANG NHAP-->
                            <div id="dagnhap"><b>Đăng nhập</b></div>
                            <%-- <%
                            if(request.getParameter("error") != null){
                            out.print("<p style='color:red'>Sai tên đăng nhập hoặc mật khẩu </p>");
                            }
                            %> --%>
                            <p style='color:red'>${error}</p>
                            <p>Tên đăng nhập</p>
                            <input class="nom" type="mail" placeholder=" Account" name="txtLogName">
                            <p>Mật khẩu</p>
                            <input class="nom" type="password" placeholder=" Password" name="txtLogPass">
                            <br>
                            <button name="login" id="logbtn">Login</button>
                            Chưa có tài khoản? Đăng ký tại <a href="register">đây</a>
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
