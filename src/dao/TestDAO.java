package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Test;


public class TestDAO extends Dao<Test>{
	
	private Connection con;
	
	/**
	 * this is the TestDAO constructor. This use a connection in the Connection pool to have access to the database
	 * @param conn
	 */ 
	
	public TestDAO(Connection conn) {
		super(conn);
        this.con=conn;
	}
	
	public Connection getConnection(){
        return this.con;
    }

	@Override
	public boolean create(Test obj) {
		   try{
	            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("INSERT INTO test(lastname, firstname) values (\'"+obj.getLastName()+"\',\'"+obj.getFirstName()+"\')");
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean delete(Test obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Test obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Test find(String lName, String fName) {
		  try{
	            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id, lastname, firstname FROM test Where lastname='"+lName+"' and firstname='"+fName+"'");
	            while(result.next()) {
	            	Test t = new Test(result.getInt("id"), result.getString("lastname"), result.getString("firstname"));
	                return t;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

	@Override
	public Test find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
