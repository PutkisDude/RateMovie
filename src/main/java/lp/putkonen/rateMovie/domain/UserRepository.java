package lp.putkonen.rateMovie.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsernameIgnoreCase(String username);

}
