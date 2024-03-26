import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletConfig;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//import javax.Servlet.*;
//import javax.Servlet.Http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
 Connection conn=null;
 PreparedStatement pstmt=null;
 ResultSet rs=null;
                                             
 String sql="select * from users where username=? and pwd=?";

 @Override
 public void init(ServletConfig config)throws ServletException

 {
 try
 {
 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

  conn =DriverManager.getConnection("jdbc:mysql://localhost/Frontend?"+
                                    "user=root&password=7995600388");
            System.out.println("obtained");
  //  log("obtained log");
   }
catch(Exception e)
{
e.printStackTrace();
}}

@Override

public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
PrintWriter out=res.getWriter();
res.setContentType("text/html");

String usern=req.getParameter("username");
String pwd=req.getParameter("userpass");
try
{
pstmt=conn.prepareStatement(sql);
 pstmt.setString(1,usern);
 pstmt.setString(2,pwd);
  rs=pstmt.executeQuery();
System.out.println("query executed successfully");

if(rs.next())
{
out.println("<body><h1 align=center>");
out.println("<h1>Login Successful,Welcome User!!</h1>");
}
else
{
out.println("<body><h1 align=center>");
out.println("<h1>Login Failed!!</h1></body>");
}}
catch(Exception e)
{
e.printStackTrace();
}}

@Override

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
doPost(req,res);
}}