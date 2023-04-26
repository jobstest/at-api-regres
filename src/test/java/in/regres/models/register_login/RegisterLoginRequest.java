package in.regres.models.register_login;

import lombok.Data;

@Data
public class RegisterLoginRequest{
	private String password;
	private String email;

	@Override
	public String toString() {
		return "{\"email\":\"" + email + "\"," +
				" \"password\":\"" + password + "\"}";
	}
}
