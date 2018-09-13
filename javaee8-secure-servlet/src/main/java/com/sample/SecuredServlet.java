package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.enterprise.authentication.mechanism.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "test", urlPatterns = { "/test" })
@BasicAuthenticationMechanismDefinition(realmName = "Admin")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "Admin" }))
public class SecuredServlet extends HttpServlet {

    public SecuredServlet() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("Welcome to secure servlet!");
        out.close();

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
