package model;

public class Viewer {
	private String id;
	private String lastName;
	private String firstName;
	private String email;
	private String avatar;
	private String gender;
	private String ip;
	private String country;
	private String birthday;
	private Viewer right;
	private Viewer left;

	public Viewer(String id, String firstName, String lastName, String email, String avatar, String gender, String ip, String country, String birthday) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.avatar = avatar;
		this.gender = gender;
		this.ip = ip;
		this.country = country;
		this.birthday = birthday;
		right = null;
		left = null;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Viewer getRight() {
		return right;
	}

	public void setRight(Viewer right) {
		this.right = right;
	}

	public Viewer getLeft() {
		return left;
	}

	public void setLeft(Viewer left) {
		this.left = left;
	}
}