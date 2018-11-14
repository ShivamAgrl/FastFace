/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ffast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shiagaga
 */
@WebServlet(name = "NewUser", urlPatterns = {"/donewuser"})
public class NewUser extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 //      User u=new User();
//       u.setName(request.getParameter("name"));
//       u.setUserName(request.getParameter("uname"));
//       u.setEmail(request.getParameter("email"));
//       u.setPassword(request.getParameter("password"));
        
    


      String u= request.getParameter("username");
      String p=request.getParameter("password");
      String n=request.getParameter("name");
      String e=request.getParameter("email");
      
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            Statement st=c.createStatement();
            String sql="insert into APP.FFAST (name,username,password,email) values('"+n+"','"+u+"','"+p+"','"+e+"')";
            st.executeUpdate(sql);
           
        RequestDispatcher success= request.getRequestDispatcher("Home.html"); //(doUserSuccess) for servlet
        success.forward(request, response);

        } 
        catch (ClassNotFoundException |SQLException ex) 
        {
            ex.printStackTrace();
        }

    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
