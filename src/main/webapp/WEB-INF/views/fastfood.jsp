


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fastfood.com</title>
        <link rel="stylesheet" href="homepage.css">
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
                    <div id=left>
                        <div id="qc1">
                            <a href=""><img src="images/qc1.jpg" alt=""/></a>
                            <a href=""><img src="images/qc2.jpg" alt=""/></a>
                        </div>
                    </div>

                    <div id=right>
                        <p id=bestseller>Đồ ăn nhanh</p>
                        <br>
                        <div id="allProducts">
                            <c:if test="${not empty ProductList}">
                                <c:forEach var="p" items="${ProductList}">
                                    <div class="product">
                                        <form action="Fbuy">
                                            <img class=pic src="${p.anh}" alt="">
                                            <br>
                                            <p style="padding-bottom: 10px;" class="tit">${p.tensp}</p>
                                            <label style="margin-left: 80px;margin-right: 5px;">Đơn giá:</label>${p.gia}đ<br><br/>                                            <label style="margin-left: 80px;margin-right: 5px;">Số lượng:</label>
                                            <input style="text-align: center;width: 50px;" type="number" min="1" name="txtNumber" value="1"/><br/><br/>
                                            <input type="hidden" name="hiddenKey" value="${p.masp}"/>
                                            <input type="hidden" name="hiddenName" value="${p.tensp}"/>
                                            <input type="hidden" name="hiddenType" value="${p.loaisp}"/>
                                            <input type="hidden" name="hiddenPrice" value="${p.gia}"/>
                                            <input type="hidden" name="hiddenUrl" value="${p.anh}"/>                                 
                                            <div style="text-align: center;"><button name="add">Add to cart</button></div>
                                        </form>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div id="pagings">
                            <c:forEach begin="1" end="3" varStatus="i">
                                <form action="Fpaging">
                                    <c:choose>
                                        <c:when test="${Fhighlight eq i.index}">
                                            <button name="${i.index}" class="paging" style="background: red; color: white">${i.index}</button>
                                        </c:when>
                                        <c:otherwise>
                                            <button name="${i.index}" class="paging">${i.index}</button>
                                        </c:otherwise>
                                    </c:choose>
                                </form>
                            </c:forEach>
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
