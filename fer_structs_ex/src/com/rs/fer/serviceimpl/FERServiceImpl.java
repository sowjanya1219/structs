package com.rs.fer.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	public boolean registration(User user) {
		boolean isRegister = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO user(firstname,middlename,lastname,email,username,password,mobile) VALUES(?,?,?,?,?,?,?)");

			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getMiddleName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getMail());
			statement.setString(5, user.getUsername());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getMobile());

			int noOfRecordsInserted = statement.executeUpdate();
			System.out.println("no of records inserted(registration) : " + noOfRecordsInserted);
			isRegister = noOfRecordsInserted > 0;

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isRegister;
	}

	@Override
	public int login(String username, String password) {
		int id = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("SELECT * FROM USER WHERE username=? AND PASSWORD=?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt("id");
				System.out.println("Match found....");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return id;
	}

	@Override
	public boolean addExpense(Expense expense) {
		boolean isAddExpense = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO expense(type,date,price,numberofitems,total,bywhom,userid) VALUES(?,?,?,?,?,?,?)");

			statement.setString(1, expense.getType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberOfItems());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getByWhom());
			statement.setInt(7, expense.getUserid());

			int noOfRecordsInserted = statement.executeUpdate();
			System.out.println("no of records inserted: " + noOfRecordsInserted);
			isAddExpense = noOfRecordsInserted > 0;

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isAddExpense;
	}

	@Override
	public boolean editExpense(Expense expense) {
		boolean isEditExpense = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getConnection();
			statement = connection.prepareStatement(

					"UPDATE expense SET TYPE=?,DATE=?,price=?,numberofitems=?,total=?,bywhom=? WHERE id=? ");

			statement.setString(1, expense.getType());
			statement.setString(2, expense.getDate());
			statement.setFloat(3, expense.getPrice());
			statement.setInt(4, expense.getNumberOfItems());
			statement.setFloat(5, expense.getTotal());
			statement.setString(6, expense.getByWhom());
			statement.setInt(7, expense.getId());

			int noOfRecordsUpdated = statement.executeUpdate();
			System.out.println("no of records updated : " + noOfRecordsUpdated);
			isEditExpense = noOfRecordsUpdated > 0;

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isEditExpense;
	}

	@Override
	public boolean deleteExpense(int expenseid) {
		boolean isDeleteExpense = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("delete from expense where id=?");

			statement.setInt(1, expenseid);

			int noOfRecordsDeleted = statement.executeUpdate();
			System.out.println("no of records deleted : " + noOfRecordsDeleted);
			isDeleteExpense = noOfRecordsDeleted > 0;

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isDeleteExpense;
	}

	@Override
	public boolean resetPassword(int id, String currentPassword, String newPassword) {
		boolean isResetPassword = false;
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("UPDATE user SET password=? where password=? and id=? ");

			statement.setString(1, newPassword);
			statement.setString(2, currentPassword);
			statement.setInt(3, id);

			int noOfRecordsDeleted = statement.executeUpdate();

			isResetPassword = noOfRecordsDeleted > 0;

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isResetPassword;
	}

	@Override
	public Expense getExpense(int expenseid) {

		Connection connection = null;
		PreparedStatement statement = null;
		Expense expense = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("SELECT * FROM expense WHERE id=?");
			statement.setInt(1, expenseid);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				expense = new Expense();

				expense.setId(resultSet.getInt("id"));
				expense.setType(resultSet.getString("type"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfItems(resultSet.getInt("numberofitems"));
				expense.setTotal(resultSet.getInt("total"));
				expense.setByWhom(resultSet.getString("bywhom"));

				System.out.println(
						resultSet.getInt("id") + "," + resultSet.getString("type") + "," + resultSet.getString("date")
								+ "," + resultSet.getFloat("price") + "," + resultSet.getInt("numberofitems") + ","
								+ resultSet.getInt("total") + "," + resultSet.getString("bywhom"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;
	}

	@Override
	public List<Expense> getExpenses(int userid) {
		Connection connection = null;
		PreparedStatement statement = null;
		Expense expense = null;
		List<Expense> expenses = new ArrayList<Expense>();
		try {
			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("SELECT * FROM expense WHERE userid=?");
			statement.setInt(1, userid);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				expense = new Expense();

				expense.setId(resultSet.getInt("id"));
				expense.setType(resultSet.getString("type"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfItems(resultSet.getInt("numberofitems"));
				expense.setTotal(resultSet.getInt("total"));
				expense.setByWhom(resultSet.getString("bywhom"));
				expenses.add(expense);

				System.out.println(
						resultSet.getInt("id") + "," + resultSet.getString("type") + "," + resultSet.getString("date")
								+ "," + resultSet.getFloat("price") + "," + resultSet.getInt("numberofitems") + ","
								+ resultSet.getInt("total") + "," + resultSet.getString("bywhom"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenses;
	}

	@Override
	public List<Expense> expenseReport(int userid, String expenseType, String fromDate, String toDate) {
		Connection connection = null;
		PreparedStatement statement = null;

		List<Expense> expenseReport = new ArrayList<Expense>();
		Expense expense = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM expense WHERE userId=? and type=? and Date between ? and ?");
			statement.setInt(1, userid);
			statement.setString(2, expenseType);
			statement.setString(3, fromDate);
			statement.setString(4, toDate);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				expense = new Expense();

				expense.setId(resultSet.getInt("id"));
				expense.setType(resultSet.getString("type"));
				expense.setDate(resultSet.getString("date"));
				expense.setPrice(resultSet.getFloat("price"));
				expense.setNumberOfItems(resultSet.getInt("numberofitems"));
				expense.setTotal(resultSet.getInt("total"));
				expense.setByWhom(resultSet.getString("bywhom"));

				System.out.println(
						resultSet.getInt("id") + "," + resultSet.getString("type") + "," + resultSet.getString("date")
								+ "," + resultSet.getFloat("price") + "," + resultSet.getInt("numberofitems") + ","
								+ resultSet.getInt("total") + "," + resultSet.getString("bywhom"));

				expenseReport.add(expense);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expenseReport;
	}

	@Override
	public User getPersonalInfo(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		User user = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.prepareStatement(
					"select u.*,a.* from user u left join " + "address a on u.id=a.userid where u.id='" + id + "'");
			// statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setMiddleName(resultSet.getString("middlename"));
				user.setLastName(resultSet.getString("lastname"));
				user.setMail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setMobile(resultSet.getString("mobile"));

				Address address = new Address();
				address.setLineOne(resultSet.getString("lineone"));
				address.setLineTwo(resultSet.getString("linetwo"));
				address.setStreet(resultSet.getString("street"));
				address.setCity(resultSet.getString("city"));
				address.setState(resultSet.getString("state"));
				address.setZip(resultSet.getString("zip"));
				address.setUserid(resultSet.getInt("userid"));

				user.setAddress(address);

				System.out.println(resultSet.getInt("id") + "," + resultSet.getString("firstname") + ","
						+ resultSet.getString("middlename") + "," + resultSet.getString("lastname") + ","
						+ resultSet.getString("email") + "," + resultSet.getString("username") + ","
						+ resultSet.getString("password") + "," + resultSet.getString("mobile") + ","
						+ resultSet.getString("lineone") + "," + resultSet.getString("linetwo") + ","
						+ resultSet.getString("street") + "," + resultSet.getString("city") + ","
						+ resultSet.getString("state") + "," + resultSet.getString("zip") + ","
						+ resultSet.getInt("userid"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return user;
	}

	@Override
	public boolean updatePersonal(User user) {
		Connection connection = null;
		PreparedStatement statement = null;
		int updateUser = 0;
		boolean isUpdate = false;
		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(
					"update user set firstname=?,middlename=?,lastname=?,email=?,mobile=? where id=?");
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getMiddleName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getMail());
			statement.setString(5, user.getMobile());
			statement.setInt(6, user.getId());

			updateUser = statement.executeUpdate();
			System.out.println(updateUser + " user record updated");
			Address address = user.getAddress();
			String inputAddress = "";
			if (updateUser > 0) {
				if (address.getId() == 0)
					inputAddress = "insert into address(lineone,linetwo,street,city,state,zip,userid) values(?,?,?,?,?,?,?)";
				else
					inputAddress = "update address set lineone=?,linetwo=?,street=?,city=?,state=?,zip=? where id=?";
			}

			statement = connection.prepareStatement(inputAddress);
			statement.setString(1, address.getLineOne());
			statement.setString(2, address.getLineTwo());
			statement.setString(3, address.getStreet());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getState());
			statement.setString(6, address.getZip());
			if (inputAddress.contains("update")) {
				statement.setInt(7, address.getId());
			} else {
				statement.setInt(7, address.getUserid());
			}

			int addressRegistered = statement.executeUpdate();
			System.out.println(addressRegistered + "address record updated");
			isUpdate = addressRegistered > 0;
			System.out.println(user.getFirstName() + "," + user.getMiddleName() + "," + user.getLastName() + ","
					+ user.getMail() + "," + user.getMobile() + "," + user.getId() + "," + address.getLineOne() + ","
					+ address.getLineTwo() + "," + address.getStreet() + "," + address.getCity() + ","
					+ address.getState() + "," + address.getZip() + "," + address.getId());

			if (isUpdate) {
				connection.commit();
			} else {
				connection.rollback();

			}
			return isUpdate;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return true;
	}
}