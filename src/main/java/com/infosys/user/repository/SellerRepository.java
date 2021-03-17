package com.infosys.user.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.user.entity.Seller;
@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

	Seller getByPhonenumber(String phonenumber);

	Optional<Seller> getByEmail(String email);

}
