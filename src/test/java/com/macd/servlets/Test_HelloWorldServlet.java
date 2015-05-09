package com.macd.servlets;

import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.macd.servlets.HelloWorldServlet.getGreeting;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by IntelliJ IDEA.
 * User: marcel
 * Date: 9/28/12
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test_HelloWorldServlet {


    @Test
    public void testEmptyGetGreeting() {
        assertThat( getGreeting( "" ), is( "Hello World!" ) );
    }



    @Test
    public void testNullGetGreeting() {
        assertThat( getGreeting( null ), is( "Hello World!" ) );
    }



    @Test
    public void testMarcelGetGreeting() {
        assertThat( getGreeting( "Marcel" ), is( "Hello Marcel" ) );
    }



    @Test
    public void testDoGet()
            throws IOException, ServletException {
        HttpServletRequest request = mock( HttpServletRequest.class );
        RequestDispatcher dispatcher = mock( RequestDispatcher.class );

        when( request.getParameter( "name" ) ).thenReturn( "TestName" );
        when( request.getRequestDispatcher( anyString() ) ).thenReturn( dispatcher );

        HelloWorldServlet servlet = new HelloWorldServlet();
        servlet.doGet( request, null );

        verify( request ).setAttribute( "greeting", getGreeting( "TestName" ) );
    }
}
