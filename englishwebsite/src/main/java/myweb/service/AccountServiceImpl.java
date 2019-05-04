package myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myweb.entity.Account;
import myweb.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
    private AccountRepository accountRepository;
	
	@Override
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findOne(String username) {
		return accountRepository.findOne(username);
	}

	@Override
	public void UpdateInforPersonal(String fullname, String email, String phone, String address, String username) {
		accountRepository.UpdateInforPersonal(fullname, email, phone, address, username);
	}

	@Override
	public void UpdateInforUser(String fullname, String email, String phone, String address, int isAd,
			String username) {
		accountRepository.UpdateInforUser(fullname, email, phone, address, isAd, username);
	}

	@Override
	public void UpdatePassword(String password, String username) {
		accountRepository.UpdatePassword(password, username);
	}

	@Override
	public void AddUser(String username, String password, String fullname, String phone, String email, String address) {
		accountRepository.AddUser(username, password, fullname, phone, email, address); 
		
	}

	@Override
	public void DeleteUser(String username) {
		accountRepository.DeleteUser(username); 
		
	}

	@Override
	public void AdminAddUser(String username, String password, String fullname, String phone, String email,
			String address, int isad) {
		accountRepository.AdminAddUser(username, password, fullname, phone, email, address, isad); 
	}
}
