/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ffast.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shiagaga
 */
@WebServlet(name = "Login", urlPatterns = {"/dologin"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // response.setContentType("text/html;charset=UTF-8");
     // User user= new User();
      String u= request.getParameter("username");
      String p=request.getParameter("password");
      
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
            PreparedStatement ps=c.prepareStatement("select username,password from APP.FFAST where username=? and password=?");
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
             response.sendRedirect("Home.html");
             return;
            }
            
            response.sendRedirect("index.html");
            
//      user.setUserName(request.getParameter("uname"));
//      user.setPassword(request.getParameter("password"));
//       RequestDispatcher success= request.getRequestDispatcher("douserhome");
//      // RequestDispatcher fail= request.getRequestDispatcher("dologinfail");
//       
//      // if(user.getUserName().equals("shivam") && user.getPassword().equals("shivam"))
//       {
//         HttpSession s=request.getSession();
//         s.getAttribute("u");
//         s.setMaxInactiveInterval(3000);
//         success.forward(request, response);
//       }
//       else
//       {
//        response.sendRedirect("index.html");
//       }        
        } catch (ClassNotFoundException |SQLException ex) {
            ex.printStackTrace();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
