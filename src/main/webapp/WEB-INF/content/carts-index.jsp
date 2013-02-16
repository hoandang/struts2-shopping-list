<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request" value="Shopping List"/>

<jsp:include page="header.jsp" flush="true"/>

<%--<h1><s:property value="#session.shoppingList"/></h1>--%>

<s:if test="%{#session.shoppingList == null}">
    <h1>Empty cart</h1>
</s:if>
<s:else>
    <table id="shoppingList" class="table table-bordered table-hover">
        <thead>
            <tr class="well well-small">
                <th>Id</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.description}</td>
                <td>
                    <form action="carts/${product.id}" class="update_cart">
                        <input type="text" name="quantity" class="quantity" value="${product.quantity}"/>
                    </form>
                </td>
                <td>${product.price}</td>
                <td>100</td>
                <td>
                    <a class="btn btn-remove" href="#">
                        <i class="icon-remove"></i> Remove
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-large btn-danger" href="#">
    <i class="icon-trash icon-large"></i> Empty cart</a>

    <a class="btn btn-large btn-success pull-right" href="#">
        <i class="icon-shopping-cart icon-large"></i> Checkout</a>
</s:else>

<jsp:include page="footer.jsp" flush="true"/>
