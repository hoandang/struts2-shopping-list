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
    <h3>Shoppling List</h3>
    <form action="carts/update" method="post">
        <s:hidden name="_method" value="put" />
        <div class="row-fluid">
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
                            <input type="text" name="quantity" class="quantity" value="${product.quantity}"/>
                        </td>
                        <td>${product.price}</td>
                        <td>100</td>
                        <td>
                            <a class="btn btn-remove" href="carts/${product.id}?_method=delete">
                                <i class="icon-remove"></i> Remove</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row-fluid">
            <div class="span2">
                <a class="btn btn-large btn-danger" href="#" id="empty">
                    <i class="icon-trash icon-large"></i> Empty Cart</a>
            </div>

            <div class="span2">
                <button type="submit" class="btn btn-large btn-primary">
                    <i class="icon-repeat icon-large"></i> Update Cart
                </button>
            </div>

            <div class="span4">
                <a class="btn btn-large btn-success" href="#">
                    <i class="icon-shopping-cart icon-large"></i> Checkout</a>
            </div>
        </div>
    </form>
</s:else>

<jsp:include page="footer.jsp" flush="true"/>
