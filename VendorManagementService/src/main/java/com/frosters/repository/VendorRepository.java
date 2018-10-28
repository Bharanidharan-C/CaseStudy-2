package com.frosters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frosters.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>{

}
