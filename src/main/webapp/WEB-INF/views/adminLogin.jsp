

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="CSSadLog.css">
    </head>
    <body>
        <div id=wrapper>
            <div id=header>
                <div id=topmenu>
                    <ul>
                        <li><a href="">TRANG QUẢN LÝ SẢN PHẨM VÀ KHÁCH HÀNG</a></li>
                    </ul>

                </div>
                <img id=headpic src="images/manager.png" alt="">
            </div>
		
            <div id=center>
                <div id=innerCen>
                    <div id=logbox>
                        <form id="login" action="aLogin"> <!--FORM DANG NHAP-->
                            <div id="dagnhap"><b>Đăng nhập</b></div>
                            <p style='color:red'>${error}</p>
                            <p>Tên đăng nhập</p>
                            <input class="nom" type="text" placeholder=" Account" name="user" required="">
                            <p>Mật khẩu</p>
                            <input class="nom" type="password" placeholder=" Password" name="pass" required="">
                            <br><br/>
                            <button id="logbtn" name="login">Login</button>
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
