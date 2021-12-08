package kz.hotelChain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.hotelChain.IDType.IDType;

@Repository
public interface IDTypesRepository extends JpaRepository<IDType, Integer>  {

}
