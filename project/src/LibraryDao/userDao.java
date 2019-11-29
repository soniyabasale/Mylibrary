package LibraryDao;

import utils.*;
import pojo.Person;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class userDao implements Closeable
{
	private Connection connection;
	private PreparedStatement insertUStatement;
	private PreparedStatement insertCStatement;
	private PreparedStatement updateEStatement;
	private PreparedStatement updatePStatement;
	private PreparedStatement selectSignStatement;
	private PreparedStatement selectUStatement;
	private PreparedStatement selectPayStatement;
	
	public userDao()throws Exception
	{
		this.connection = DbUtils.getConnection();
		this.insertUStatement = connection.prepareStatement("INSERT INTO users (users_name,users_email,users_phone,users_passwd,users_role) VALUES(?,?,?,?,?)");
		this.insertCStatement = connection.prepareStatement("INSERT INTO copies VALUES(?,?,?,?)");
		this.updateEStatement = connection.prepareStatement("UPDATE SET users_email=? WHERE users_name=?");
		this.updatePStatement = connection.prepareStatement("UPDATE SET users_phone=? WHERE users_name=?");
		this.selectUStatement = connection.prepareStatement("SELECT * FROM users where users_role='M'");
		this.selectSignStatement = connection.prepareStatement("SELECT users_email,users_passwd from users");
	}
	public int insertU(Person person)throws Exception
	{
		this.insertUStatement.setString(1, person.getUsers_name());
		this.insertUStatement.setString(2, person.getUsers_email());
		this.insertUStatement.setInt(3, person.getUsers_phone());
		this.insertUStatement.setString(4,person.getUsers_passwd());
		this.insertUStatement.setString(5,person.getUsers_role());
		return this.insertUStatement.executeUpdate();
	}
	public int insertC(Person person)throws Exception
	{
		this.insertCStatement.setString(2, person.getUsers_name());
		this.insertUStatement.setString(3, person.getUsers_email());
		this.insertUStatement.setInt(4, person.getUsers_phone());
		this.insertUStatement.setString(5,person.getUsers_passwd());
		this.insertUStatement.setString(6,person.getUsers_role());
		return this.insertUStatement.executeUpdate();
	}
	public int updateE(String users_email, String users_name)throws Exception
	{
		this.updateEStatement.setString(1, users_email);
		this.updateEStatement.setString(2, users_name);
		
		return this.updateEStatement.executeUpdate();
	}
	public int updateP(int users_phone, String users_name)throws Exception
	{
		
		return this.updatePStatement.executeUpdate();
	}
	
	public List<Person> getUsers()throws Exception
	{
		List<Person> userList = new ArrayList<Person>();
		try( ResultSet rs = this.selectUStatement.executeQuery())
		{
			while( rs.next())
			{
				Person user = new Person(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
				userList.add(user);
			}
		}
		return userList;
	}
	@Override
	public void close() throws IOException 
	{
		try
		{
			this.insertCStatement.close();
			this.insertUStatement.close();
			this.updateEStatement.close();
			this.updatePStatement.close();
			this.selectUStatement.close();
			this.selectSignStatement.close();
			this.connection.close();
		}
		catch( SQLException cause )
		{
			throw new IOException(cause);
		}
	}
	
}