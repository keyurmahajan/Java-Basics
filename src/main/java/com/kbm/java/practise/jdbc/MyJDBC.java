package com.kbm.java.practise.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String createTableQuery = "CREATE TABLE USERS(" + "USER_ID NUMBER(5) NOT NULL, "
				+ "USERNAME VARCHAR(20) NOT NULL, " + "PRIMARY KEY (USER_ID) " + ")";
		String addRowToTable = "INSERT INTO USERS VALUES('001','Keyur')";
		String addRowToTable2 = "INSERT INTO USERS VALUES('002','Mahajan')";
		String addRowToTable3 = "INSERT INTO USERS VALUES('003','Tech-Note')";
		String deletefromTable3 = "DELETE FROM USERS WHERE USER_ID='003'";
		String dbName = "test.db";
		Statement statement = null;
		Connection connection = null;
		try {

			File file = new File(dbName);
			if (file.exists()) {
				file.delete();
			}

			MyJDBC obj = new MyJDBC();
			Class.forName("org.sqlite.JDBC");
			connection = obj.createConnection("jdbc:sqlite:" + dbName);
			statement = connection.createStatement();

			int result = statement.executeUpdate(createTableQuery);
			System.out.println("1. User table created");

			result = statement.executeUpdate(addRowToTable);
			System.out.println("\n2. Values added to Table.");
			System.out.println("No. of row affected-" + result);

			// Normal Batch execution without transcation
			System.out.println("\nCreating Batch for inserting Values...");
			statement.addBatch(addRowToTable2);
			statement.addBatch(addRowToTable3);
			statement.executeBatch();
			System.out.println("3. Batch Execution done...");

			ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
			System.out.println("\n4. Reading Users from Databse...");
			while (resultSet.next()) {
				String name = resultSet.getString("USERNAME");
				int id = resultSet.getInt("USER_ID");
				System.out.println("User: ID:" + id + " Name:" + name);
			}

			System.out.println("\n5. Deleting User with ID=003 from Databse...");
			result = statement.executeUpdate(deletefromTable3);
			System.out.println("No. of row affected-" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		}
	}

	private Connection createConnection(String driver) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(driver, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
