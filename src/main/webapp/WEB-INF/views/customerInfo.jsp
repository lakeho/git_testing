<%-- 
    Document   : cart.jsp
    Created on : Aug 11, 2019, 4:52:32 PM
    Author     : hotua
--%>
<%@page import="jv5.ass.entity.Customer"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<%@page import="java.text.SimpleDateFormat"%>
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
                    
                    <div id="info">
                        <form action="updateInfo">
                            <b>Thông tin khách hàng</b><br/><br/>
                             <%! String checkMale(boolean sex){
                                    if(sex){
                                        return "checked";
                                    }else{
                                        return "";
                                    }
                                }   
                                String checkFeMale(boolean sex){
                                    if(sex){
                                        return "";
                                    }else{
                                        return "checked";
                                    }
                                }    
                            %> 
                             <%  Customer cm = (Customer)session.getAttribute("CurrentUser"); 
                            %> 
                            <p style='color:red; margin-bottom: 10px;'>${error}</p>
                            <input type="hidden" name="txtmakh" value="<%=cm.getMakh()%>" readonly=""/>
                            
                            Tên khách hàng: <input class="infor" type="text" name="txttenkh" value="<%=cm.getTenkh()%>"/><br/><br/>
                            
                            Giới tính: <input style="margin-left: 61px;" type="radio" name="rdSex" value="true" <%=checkMale(cm.getSex())%>/>Nam
                            <input style="margin-left: 15px;" type="radio" name="rdSex" value="false" <%=checkFeMale(cm.getSex())%>/>Nữ<br/><br/>
                                       
                            Tên tài khoản: <input class="infor" type="text" name="txttentk" value="<%=cm.getUsername()%>"/><br/><br/>
                            
                            Mật khẩu: <input class="infor" type="password" name="txtmatkhau" value="<%=cm.getPass()%>" readonly=""/><a href="updatepass">Đổi mật khẩu</a><br/><br/>
                            
                            Số điện thoại: <input class="infor" type="text" name="txttel" value="<%=cm.getTel()%>"/><br/><br/>
                            
                            Địa chỉ thường trú: <input class="infor" type="text" name="txtdiachi" value="<%=cm.getAdd()%>"/><br/><br/>
                            <button name="update" id="nut">Update information</button><br/><br/>
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

