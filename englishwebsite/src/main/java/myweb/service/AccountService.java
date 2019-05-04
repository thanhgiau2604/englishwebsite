package myweb.service;

import org.springframework.data.repository.query.Param;

import myweb.entity.Account;

public interface AccountService {
	
	Iterable<Account> findAll();

    Account findOne(String username);
    
    void UpdateInforPersonal(String fullname, String email, String phone, 
	String address, String username);
    
    void UpdateInforUser(String fullname, String email, String phone, 
    		String address, int isAd, String username);
    
    void UpdatePassword(String password, String username);
    
    void AddUser(String username, String password, String fullname, String phone, String email, String address);
    
    void DeleteUser(String username);
    
    void AdminAddUser(String username, String password, String fullname, String phone, String email, String address, int isad);
}
