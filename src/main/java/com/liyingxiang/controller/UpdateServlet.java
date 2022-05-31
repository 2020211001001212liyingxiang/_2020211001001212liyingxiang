package com.liyingxiang.controller;

import com.liyingxiang.dao.UserDao;
import com.liyingxiang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet", value = "/updateuser")
public class UpdateServlet extends HttpServlet {
    Connection con;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID=request.getParameter("ID");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("Email");
        String Gender=request.getParameter("Gender");
        String birthday=request.getParameter("birthday");

        User preUser=(User) request.getSession().getAttribute("user");
        preUser.setPassword(password);
        preUser.setUsername(username);
        preUser.setGender(Gender);
        preUser.setBirthday(birthday);
        preUser.setEmail(Email);

        UserDao userDao=new UserDao();
        try {
            userDao.updateUser(con,preUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("accountDetails").forward(request,response);
    }
}
