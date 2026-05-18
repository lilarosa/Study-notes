package objektorientierung;

public class Benutzer {
String name;
String email;
String passwort;

public String getPasswort()
{
	return passwort;
}

public void setPasswort(String passwort) {
	this.passwort = passwort;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}
