package upq.edu.mx.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {

	@Serial
	private static final long serialVersionUID = -7007144763470421872L;
	private String username;

	private String email;

	private String fullName;

}
