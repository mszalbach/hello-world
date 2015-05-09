package com.macd.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

/**
 * Created by IntelliJ IDEA.
 * User: marcel
 * Date: 9/28/12
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet( urlPatterns = { "helloServlet/*" } )
public class HelloWorldServlet
        extends HttpServlet {

    @Override
    public void doGet( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ServletException {
        String name = request.getParameter( "name" );
        /*
         * sends requests to any resource on the server
         * Is used to separate logic from web representation
         */
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/template/hello.jsp" );
        request.setAttribute( "greeting", getGreeting( name ) );
        dispatcher.forward( request, response );
    }



    protected final static String getGreeting( String name ) {
        if ( isNotEmpty( name ) ) {
            return "Hello " + name;
        }
        return "Hello World!";

    }

}
