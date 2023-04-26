package in.regres.models.create;

import lombok.Data;

@Data
public class CreateRequest {
	private String name;
	private String job;

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}";
	}
}
