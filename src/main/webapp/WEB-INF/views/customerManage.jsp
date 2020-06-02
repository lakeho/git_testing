

<%@page import="jv5.ass.entity.Customer"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Manager</title>
        <link rel="stylesheet" href="cssCManage.css">
    </head>
    <body>
        <div id=wrapper>
            <div id=header>
                <div id=topmenu>
                    <ul>
                            <li><a href="productManage">QUẢN LÝ SẢN PHẨM</a></li>
                            <li><a href="customerManage">QUẢN LÝ KHÁCH HÀNG</a></li>
                    </ul>
                    <a href="adminLogin" class="sess">Đăng xuất</a>
                </div>
                <img id=headpic src="images/manager.png" alt="">
            </div>
		
            <div id=center>
                <div id=innerCen>
                    <table id="col" border="1" cellPadding="0" cellSpacing="0">
                        <tr>
                            <th style="width: 40px;">STT</th>
                            <th style="width: 50px;">Mã KH</th>
                            <th style="width: 180px;">Tên khách hàng</th>
                            <th style="width: 100px;">Tên tài khoản</th>
                            <th style="width: 80px;">Mật khẩu</th>
                            <th style="width: 80px;">Giới tính</th>
                            <th style="width: 100px;">Số điện thoại</th>
                            <th style="width: 225px;">Địa chỉ</th>
                            <th style="width: 28px;">Xóa</th>
                        </tr>
                    </table>
                    <div id="scroll">
                        <table border="1" cellPadding="0" cellSpacing="0" style="text-align: center;">
                            <c:forEach var="kh" items="${CustomerList}" varStatus="i">
                                <form action="CList">
                                    <tr>
                                        <td style="width: 40px;">${i.count}</td>
                                        <td style="width: 50px;">${kh.makh}</td>
                                        <td style="width: 180px;">${kh.tenkh}</td>
                                        <td style="width: 100px;">${kh.username}</td>
                                        <td style="width: 80px;">${kh.pass}</td>
                                        <td style="width: 80px;">
                                            <c:choose>
                                                <c:when test="${kh.sex eq true}">
                                                    Nam
                                                </c:when>
                                                <c:otherwise>
                                                    Nữ
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td style="width: 100px;">${kh.tel}</td>
                                        <td style="width: 225px;">${kh.add}</td>
                                        <td style="width: 28px;">
                                            <input type="hidden" name="txtId" value="${kh.makh}"/>
                                            <button name="del">Xóa</button>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>            
                        </table>
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
