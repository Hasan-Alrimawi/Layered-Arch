package com.jpa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jpa.persistence.entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
