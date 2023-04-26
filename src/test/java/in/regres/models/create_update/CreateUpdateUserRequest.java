package in.regres.models.create_update;

import lombok.Data;

@Data
public class CreateUpdateUserRequest {
	private String name;
	private String job;

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}";
	}
}
