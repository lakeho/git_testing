<%-- 
    Document   : login
    Created on : Aug 7, 2019, 3:51:35 PM
    Author     : hotua
--%>

<%@page import="jv5.ass.entity.Product"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Manager</title>
        <link rel="stylesheet" href="cssPManage.css">
    </head>
    <body>
        <div id=wrapper>
            <div id=header>
                <div id=topmenu>
                    <ul>
                            <li><a href="productManage">QUẢN LÝ SẢN PHẨM</a></li>
                            <li><a href="customerManage">QUẢN LÝ KHÁCH HÀNG</a></li>
                    </ul>
                    <p><% session.getAttribute("selectedProduct"); %></p>
                    <a href="adminLogin" class="sess">Đăng xuất</a>
                </div>
                <img id=headpic src="images/manager.png" alt="">
            </div>
		
            <div id=center>
                <div id=innerCen>
                    <form action="PMform">
                        <%  Product p = (Product)request.getAttribute("chosenP"); %>
                        <c:set var="p" value="${chosenP}"/>
                        <%! String commas(int i){
                                Locale localeEN = new Locale("en","EN");
                                NumberFormat en = NumberFormat.getInstance(localeEN);
                                long e = i;
                                String c =  en.format(e) + "đ";
                                return c;
                            } 
                        %>
                        <div id="sp">
                            <div id="khung">
                                <div id="showpic"><img style="width: 260px; height: 195px;" src="<%=p.getAnh()%>" alt=""></div>
                                <%
                                if(request.getParameter("error") != null){
                                out.print("<p style='color:red'>Thêm sản phẩm thất bại!</p>");
                                }
                                %>
                                <%! String checked1(boolean i){
                                        if(i==true){
                                            return "checked";
                                        }
                                        return "";
                                    }
                                    String checked2(boolean i){
                                         if(i==false){
                                             return "checked";
                                         }
                                    return "";
                                    }
                                %>
                                <p style="color:red; margin-left: 10px;">${error}</p>
                                <label>Tên sản phẩm: </label><input class="txts" type="text" name="txtsp" value="<%=p.getTensp()%>"/><br/>
                                <!--<label>Loại sản phẩm: </label><input class="txts" type="text" name="txtType" value=""placeholder=" 1:Đồ ăn/2: Thức uống"/><br/>-->
                                <label>Loại sản phẩm: </label><input type="radio" name="rdtype" value="true" <%=checked1(p.getLoaisp())%>>Đồ ăn
                                                              <input type="radio" name="rdtype" value="false" <%=checked2(p.getLoaisp())%>>Thức uống<br/>
                                <label>Đơn giá: </label><input class="txts" type="text" name="txtprice" value="<%=p.getGia()%>"/><br/>
                                <label>Ảnh hiển thị: </label><input class="txts" type="text" name="txturl" value="<%=p.getAnh()%>"/><br/>
                                <input type="hidden" name="txtid" value="<%=p.getMasp()%>"/>
<!--                                <input class="btn" type="submit" name="action" value="Thêm"/>
                                <input class="btns" type="submit" name="action" value="Sửa"/>
                                <input class="btns" type="submit" name="action" value="Xóa"/>-->
                                <button class="btn" name="add">Thêm</button>
                                <button class="btns" name="update">Sửa</button>
                                <button class="btns" name="del">Xóa</button>
                            </div>
                        </div>  
                    </form>
                    <div id="listSP">
                        <table id="col" border="1" cellPadding="0" cellSpacing="0">
                                    <tr>
                                        <th style="width: 49px;">STT</th>
                                        <th style="width: 57px;">Mã SP</th>
                                        <th style="width: 173px;">Tên sản phẩm</th>
                                        <th style="width: 125px;">Đơn giá</th>
                                        <th style="width: 49px;">Chọn</th>
                                    </tr>
                            </table>
                        <div id="scroll">
                            <table border="1" cellPadding="0" cellSpacing="0" style="text-align: center;">
                                <c:forEach var="sp" items="${pList}" varStatus="i">
                                    <form action="productList">
                                        <c:choose>
                                            <c:when test="${sp.masp eq p.masp}">
                                                <tr style="background: blue;color: white;">
                                                    <td style="width: 50px;">${i.count}</td>
                                                    <td style="width: 60px;">${sp.masp}</td>
                                                    <td style="width: 180px;">${sp.tensp}</td>
                                                    <td style="width: 130px;">${sp.gia}đ</td>
                                                    <td style="width: 50px;">
                                                        <input type="hidden" name="txtId" value="${sp.masp}"/>
                                                        <input type="hidden" name="count" value="${i.count}"/>
                                                        <button name="choose">Chọn</button>
                                                    </td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td style="width: 50px;">${i.count}</td>
                                                    <td style="width: 60px;">${sp.masp}</td>
                                                    <td style="width: 180px;">${sp.tensp}</td>
                                                    <td style="width: 130px;">${sp.gia}đ</td>
                                                    <td style="width: 50px;">
                                                        <input type="hidden" name="txtId" value="${sp.masp}"/>
                                                        <input type="hidden" name="count" value="${i.count}"/>
                                                        <button name="choose">Chọn</button>
                                                    </td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                    </form>
                                </c:forEach>
                            </table>
                        </div>
<!--                        <form action="sorting">
                            Sắp xếp:<br/>
                            <input type="radio" name="order" value="true"/>Theo tên sản phẩm
                            <input type="radio" name="order" value="false"/>Theo loại giá<br/>
                            <input type="radio" name="flow" value="true"/>Từ trên xuống
                            <input type="radio" name="flow" value="false"/>Từ dưới lên<br/>
                            <input type="radio" name="type" value="1"/>Chỉ đồ ăn
                            <input type="radio" name="type" value="0"/>Chỉ thức uống
                            <input type="radio" name="type" value="2"/>Cả hai loại<br/>
                            <button name="sort">Sort</button>
                        </form>-->
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
