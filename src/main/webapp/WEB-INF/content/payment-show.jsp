<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request" value="Confirmation"/>

<jsp:include page="header.jsp" flush="true"/>
<h3><a href="/carts">Your cart</a> / <a href="/payment/new">Payment</a> / Confirmation</h3>
<hr/>
<form method="post" action="/payment">
    <p>${customer}</p>
    <input type="submit" name="" value="Confirm payment" class="btn btn-large btn-primary" />
</form>
<jsp:include page="footer.jsp" flush="true"/>

