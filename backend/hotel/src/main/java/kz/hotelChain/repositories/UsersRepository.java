package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.hotelChain.userType.user.User;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {

}
