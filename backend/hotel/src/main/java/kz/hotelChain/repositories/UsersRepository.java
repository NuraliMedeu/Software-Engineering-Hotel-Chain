package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.hotelChain.user.User;

public interface UsersRepository extends JpaRepository<User, String> {

}
