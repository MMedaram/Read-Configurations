package com.configexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configexample.domain.DbConfig;
import com.configexample.repository.DbConfigRepository;

@Service
public class DbConfigService {
	
	@Autowired
	DbConfigRepository configRepository;
	
	public DbConfig getConfigFromDb(String dbType) {
		return configRepository.findByDbType(dbType);
	}
}
