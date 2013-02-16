package com.hoan.controllers;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.Date;
import java.util.Map;

public class ProductsController
{
    private String id;
    private Map session;

    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    @Action(results={@Result(name="success", location="/", type="redirect")})
    public String execute() throws Exception
    {
        session = ActionContext.getContext().getSession();
        if (session.containsKey("id"))
            session.put("id", id);

        return "success";
    }
}
