

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="codeReg.css">
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
<!--                    <ul>
                        <li>-->
                            <a href="register" class="sess">Đăng ký</a>
                            <a href="login" class="sess">Đăng nhập</a>
<!--                        </li>
                    </ul>-->
                    <% } %>
                </div>
                <img id=headpic src="images/h1.jpg" alt="">
            </div>
		
            <div id=center>
                <div id=innerCen>
                    <div id=signbox>
                        <form id="signup" action="signup">
                            <div id="dagky"><b>Đăng ký</b></div>
                            <p style='color:red'>${error}</p>
                            <p>Tên đăng nhập</p>
                            <input class="nom" type="text" placeholder=" Account" name="txtRegUser" required="">
                            <p>Mật khẩu</p>
                            <input class="nom" type="password" placeholder=" Password" name="txtRegPass" required="">
                            <p>Nhập lại mật khẩu</p>
                            <input class="nom" type="password" placeholder=" RePass" name="txtRegRepass" required="">
                            <p>Họ tên</p>
                            <input class="nom" type="text" placeholder=" Name" name="txtRegName" required="">
                            <!--<input type="submit" value="Sign up" id="signbtn" name="action">-->
                            <button id="signbtn" name="submit">Sign up</button>
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
