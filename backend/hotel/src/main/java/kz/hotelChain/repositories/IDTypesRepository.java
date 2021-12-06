package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.hotelChain.user.IDType;

public interface IDTypesRepository extends JpaRepository<IDType, Integer>  {

}
