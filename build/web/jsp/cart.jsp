<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="model.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
<head>
    <title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>


<body bgcolor="#FFFFFF" text="#000000">
<h2 align="center"><b>The followings Items are in your shopping cart </b></h2>
<form name="form1" method="post" action="./books">
<input type="hidden" name="action" value="update_cart">
  <table width="100%" border="1" cellspacing="0" cellpadding="3" height="98">
    <tr> 
      <td width="13%" bgcolor="#CCCCCC"> 
        <div align="center"><font face="Arial, Helvetica, sans-serif" size="3">ISBN</font></div>
      </td>
      <td width="34%" bgcolor="#CCCCCC"> 
        <div align="center"><font face="Arial, Helvetica, sans-serif" size="3">Title</font></div>
      </td>
      <td width="13%" bgcolor="#CCCCCC"> 
        <div align="center"><font face="Arial, Helvetica, sans-serif" size="3">Price/unit</font></div>
      </td>
      <td width="9%" bgcolor="#CCCCCC"> 
        <div align="center"><font face="Arial, Helvetica, sans-serif" size="3">Quantity</font></div>
      </td>
      <td width="20%" bgcolor="#CCCCCC"> 
        <div align="center"><font face="Arial, Helvetica, sans-serif" size="3">Subtotal</font></div>
      </td>
      <td width="11%" bgcolor="#CCCCCC"> 
        <div align="center"><font face="Arial, Helvetica, sans-serif" size="3">Remove</font></div>
      </td>
    </tr>
    <c:set var="items" value="${sessionScope.cart}" />
                <c:set var="totalCostOfOrder" value="0.00" />
                <c:forEach var="entry" items="${items.entrySet()}">
                    <c:set var="isbn" value="${entry.key}" />
                    <c:set var="item" value="${entry.value}" />
                    <c:set var="book" value="${item.book}" />
                    <c:set var="title" value="${book.title}" />
                    <c:set var="price" value="${book.dollarPrice}" />
                    <c:set var="quantity" value="${item.quantity}" />
                    <c:set var="cost" value="${item.orderCost}" />
                    <c:set var="dollarCost" value="${item.dollarOrderCost}" />
                    <c:set var="totalCostOfOrder" value="${totalCostOfOrder + cost}" />
                    <tr bgcolor="#F0F0F0">
                        <td width="13%" height="5">${isbn}</td>
                        <td width="34%" height="5">${title}</td>
                        <td width="13%" height="5">${price}</td>
                        <td width="9%" height="5">
                            <input type="text" name="${isbn}" size="2" value="${quantity}" maxlength="4">
                        </td>
                        <td width="20%" height="5">
                            <div align="right">${dollarCost}</div>
                        </td>
                        <td width="11%" height="5">
                            <div align="center">
                                <input type="checkbox" name="remove" value="${isbn}">
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <tr bgcolor="#E4E4E4">
                    <td width="13%" height="2" bordercolor="#CCCCCC">
                        <input type="submit" name="Submit" value="Update Cart">
                    </td>
                    <td width="34%" height="2" bordercolor="#CCCCCC">&nbsp;</td>
                    <td width="13%" height="2" bordercolor="#CCCCCC">&nbsp;</td>
                    <td width="9%" height="2" bordercolor="#CCCCCC">&nbsp;</td>
                    <td width="20%" height="2" bordercolor="#CCCCCC">
                        <div align="right">
                            <b>ORDER TOTAL: 
                                <fmt:setLocale value="en_US"/>
                                <fmt:formatNumber value="${totalCostOfOrder}" type="currency"/>
                            </b>
                        </div>
                    </td>
                    <td width="11%" height="2" bordercolor="#CCCCCC">&nbsp;</td>
                </tr>
            </table>
</form>
<p><a href="./books?action=continue">Continue Shopping</a></p>
<p><a href="./books?action=checkout">Check Out</a></p>
</body>
</html>
