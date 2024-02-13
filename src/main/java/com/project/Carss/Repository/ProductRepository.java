package com.project.Carss.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Carss.entities.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findBypid(Integer pid);
	

}
