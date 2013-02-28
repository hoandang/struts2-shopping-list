<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request" value="Confirmation"/>

<jsp:include page="header.jsp" flush="true"/>
<h2>Thank you for your ordering. Your order is ${orderId}</h2>
<jsp:include page="footer.jsp" flush="true"/>
