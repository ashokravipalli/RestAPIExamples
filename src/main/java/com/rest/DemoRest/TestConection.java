/*
 * package com.rest.DemoRest;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.ResultSet; import java.sql.Statement;
 * 
 * class TestConection { public static void main(String args[]) { try {
 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
 * DriverManager.getConnection(
 * "jdbc:mysql://localhost:3306/restdb?useSSL=false", "root", "root"); if (con
 * != null) { Statement stmt = con.createStatement();
 * 
 * ResultSet rs = stmt.executeQuery("select * from customer");
 * 
 * while (rs.next()) System.out.println(rs.getInt(1) + "  " + rs.getString(2) +
 * "  " + rs.getInt(3)); } con.close(); } catch (Exception e) {
 * System.out.println(e); } } }
 */