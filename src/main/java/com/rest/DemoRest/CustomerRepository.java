package com.rest.DemoRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

public class CustomerRepository {

	Connection con = null;

	// return all customers data
	public List<Customer> getAllCust() {

		List<Customer> cust = new ArrayList<Customer>();
		con = ConnectionManager.getConnection();
		String sql = "select * from customer";

		try {
			if (con != null) {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Customer ct = new Customer();
					ct.setId(rs.getInt(1));
					ct.setName(rs.getString(2));
					ct.setPoints(rs.getInt(3));
					cust.add(ct);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cust;

	}
	// return only specific customer data based on url pattern

	public Customer getCust(int id) {
		Customer ct = new Customer();
		con = ConnectionManager.getConnection();
		String sql = "select * from customer where id=" + id;

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				ct.setId(rs.getInt(1));
				ct.setName(rs.getString(2));
				ct.setPoints(rs.getInt(3));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	// adding new customer to the Repository
	public void create(Customer cust) {
		con = ConnectionManager.getConnection();
		String sql = "insert into restdb.customer values(?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cust.getId());
			st.setString(2, cust.getName());
			st.setInt(3, cust.getPoints());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
