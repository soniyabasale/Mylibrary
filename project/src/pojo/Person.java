package pojo;
public class Person 
{
	private int users_id ;
	private String users_name;
	private String users_email;
	private int users_phone;
	private String users_passwd;
	private String users_role;
	
	public Person()
	{	}

	public Person(int users_id, String users_name, String users_email, int users_phone, String users_passwd, String users_role) 
	{
		this.users_id = users_id;
		this.users_name = users_name;
		this.users_email = users_email;
		this.users_phone = users_phone;
		this.users_passwd = users_passwd;
		this.users_role = users_role;
	}


	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_email() {
		return users_email;
	}

	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}

	public int getUsers_phone() {
		return users_phone;
	}

	public void setUsers_phone(int users_phone) {
		this.users_phone = users_phone;
	}

	public String getUsers_passwd() {
		return users_passwd;
	}

	public void setUsers_passwd(String users_passwd) {
		this.users_passwd = users_passwd;
	}

	public String getUsers_role() {
		return users_role;
	}

	public void setUsers_role(String users_role) {
		this.users_role = users_role;
	}
	
	
	 
	
}