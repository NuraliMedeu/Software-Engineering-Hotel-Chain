package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.hotelChain.userType.UserType;

@Repository
public interface UserTypesRepository extends JpaRepository<UserType, String> {

}
