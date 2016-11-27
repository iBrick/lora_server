package dao;

import endnodes.Info;

public abstract class DataBase {
	
	/**
	 * 
	 */
	private static final String driver ="com.mysql.jdbc.Driver";
	
	/**
	 * 
	 */
	protected static final String dbUrl = "jdbc:mysql://localhost/lora";
	
	/**
	 * 
	 */
	protected static final String dbUser = "root";
	/**
	 * 
	 */
	protected static final String dbPwd = "root";
	
	
	
	abstract public void SaveData(Info info);
	
	abstract public void Query(String str);
	
}
