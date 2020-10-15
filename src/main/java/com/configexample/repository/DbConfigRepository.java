package com.configexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.configexample.domain.DbConfig;

@Repository
public interface DbConfigRepository extends JpaRepository<DbConfig, Long>{
	
	public DbConfig findByDbType(String dbType);
}
