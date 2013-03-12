<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request" value="Search orders"/>

<jsp:include page="header.jsp" flush="true"/>
<h3 class="text-center">Search orders</h3>
<div class="row-fluid">
    <form id="form-search" method="get" class="span7">
        <div class="input-append">
            <input class="input-xxlarge" type="text" placeholder="Enter Order ID" name="id"/>
            <button type="submit" class="btn btn-info">
                <i class="icon-search"></i> Search Order
            </button>
        </div>
    </form>
</div>
<jsp:include page="footer.jsp" flush="true"/>
