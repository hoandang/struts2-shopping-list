<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<c:set var="pageTitle" scope="request" value="Payment"/>

<jsp:include page="header.jsp" flush="true"/>
<h3><a href="/carts">Your cart</a> / <a href="/payment/new">Payment</a> / <a href="#">Confirmation</a></h3>
<hr/>
<form method="post" action="/payment/confirm">
    <div class="row-fluid">
        <h4>Your Information</h4>
        <input type="text" placeholder="First Name" name="customer.firstName" value="${customer.firstName}"/>
        <input type="text" placeholder="Last Name" name="customer.lastName" value="${customer.lastName}"/>
        <input type="text" placeholder="Email" name="customer.email" value="${customer.email}"/>
    </div>
    <hr/>
    <div class="row-fluid">
        <h4>Shipping Address</h4>
        <p><input type="text" placeholder="Addres" name="customer.shippingAddress" 
                  value="${customer.shippingAddress}"/></p>
        <p>
            <input type="text" class="input-small" placeholder="City" 
                   name="customer.shippingCity" value="${customer.shippingCity}"/>
            <input type="text" class="input-small" placeholder="Zip" 
                   name="customer.shippingZip" value="${customer.shippingZip}"/>
        </p>
    </div>
    <hr/>
    <div class="row-fluid">
        <h4>Credit Card Information</h4>
        <input type="text" placeholder="Credit Card Number" 
               name="customer.creditNumber" value="${customer.creditNumber}"/>
        <input type="text" class="input-medium" placeholder="Expired Date" 
               name="customer.creditExpiredDate" value="${customer.creditExpiredDate}"/>
    </div>
    <hr/>
    <input type="submit" name="" value="Submit payment" class="btn btn-large btn-remove" />
</form>
<jsp:include page="footer.jsp" flush="true"/>
