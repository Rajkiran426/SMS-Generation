package com.flight_reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flight_reservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String emailId);
}
