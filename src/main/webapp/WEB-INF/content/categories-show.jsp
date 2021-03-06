<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request" value="Products"/>

<jsp:include page="header.jsp" flush="true"/>

<div class="span2">
    <ul id="sidebar" class="nav nav-tabs nav-stacked">
        <li class="nav-header well well-small">Categories</li>
        <c:forEach var="category" items="${categories}">
            <c:if test="${category.id == id}">
                <c:set var="categoryName" value="${category.name}"/>
            </c:if>
            <li class="${category.id == id ? 'active' : ''}">
                <a href="${category.id}"><i class="icon-chevron-right pull-right"></i>${category.name}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<div class="span8">
    <strong class="lead text-info">${categoryName}</strong>
    <ul id="products">
    <c:forEach var="product" items="${products}">
        <li class="product">
        <span class="desc">${product.id}. ${product.description}</span>
            <strong class="price text-error">$${product.price}</strong>
            <form action="${pageContext.request.contextPath}/carts" method="post">
                <input type="hidden" name="id" value="${product.id}"/>
                <button type="submit" class="btn btn-success">
                    <i class="icon-shopping-cart"></i> Add to cart
                </button>
            </form>
        </li>
    </c:forEach>
    </ul>
</div>

<jsp:include page="footer.jsp" flush="true"/>

