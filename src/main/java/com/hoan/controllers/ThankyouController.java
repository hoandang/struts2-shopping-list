package com.hoan.controllers;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import com.hoan.services.ShopServicesImpl;

public class ThankyouController
{
    public HttpHeaders index()
    {
        return new DefaultHttpHeaders("index").withStatus(200);
    }
}
