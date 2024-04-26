package it.corso.service;

public interface BlackListService {

	void invalidateToken(String token);
	
	boolean isTokenRevoked(String token);
}
