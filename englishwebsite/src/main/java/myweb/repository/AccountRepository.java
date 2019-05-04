package myweb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import myweb.entity.Account;


@Repository
public interface AccountRepository extends CrudRepository<Account, String>{	
	@Modifying
	@Transactional
	@Query("Update Account ac SET ac.fullname=:fullname, ac.email=:email, ac.phone=:phone, ac.address=:address where ac.username=:username")
	void UpdateInforPersonal(@Param("fullname") String fullname, @Param("email") String email, @Param("phone") String phone, 
			@Param("address") String address, @Param("username") String username);
	
	
	@Modifying
	@Transactional
	@Query("Update Account ac SET ac.fullname=:fullname, ac.email=:email, ac.phone=:phone, ac.address=:address, ac.isad=:isAd where ac.username=:username")
	void UpdateInforUser(@Param("fullname") String fullname, @Param("email") String email, @Param("phone") String phone, 
			@Param("address") String address, @Param("isAd") int isAd, @Param("username") String username);
	
	@Modifying
	@Transactional
	@Query("Update Account ac SET ac.password=:password where ac.username=:username")
	void UpdatePassword(@Param("password") String password, @Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value = "Insert INTO Account (username,password,fullname,phone,email,address,isad) "
			+ "VALUES(:username,:password,:fullname,:phone,:email,:address,0)", nativeQuery=true)
	void AddUser(@Param("username") String username, @Param("password") String password, @Param("fullname") String fullname,
			@Param("phone") String phone, @Param("email") String email, @Param("address") String address);
	
	@Modifying
	@Transactional
	@Query("Delete Account ac where ac.username=:username")
	void DeleteUser(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query(value = "Insert INTO Account (username,password,fullname,phone,email,address,isad) "
			+ "VALUES(:username,:password,:fullname,:phone,:email,:address,:isad)", nativeQuery=true)
	void AdminAddUser(@Param("username") String username, @Param("password") String password, @Param("fullname") String fullname,
			@Param("phone") String phone, @Param("email") String email, @Param("address") String address, @Param("isad") int isad);
}
