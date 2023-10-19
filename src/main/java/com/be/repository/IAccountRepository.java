package com.be.repository;

import com.be.model.Account;
import com.be.model.House;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


import java.util.List;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where a.username=:u")
    Account getAccountByUsername(@Param("u") String username);

    @Query("select a from Account a where a.username= :username and a.password= :password")
    Optional<Account> getAccountByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT a FROM Account a JOIN a.role r WHERE r.name = 'ROLE_HOST'")
    List<Account> findAccountsByRoleName_Vendor();

    @Query(value = "select h from House h where h.account.id=:idAccount and h.name like :name and h.status.name=:nameStatus")
    List<House> findByNameAndStatus(@Param("idAccount") int idAccount, @Param("name") String name, @Param("nameStatus") String nameStatus);


    @Query("select a from Account a where a.username=:u or a.phone=:p")
    Optional<Account> getAccountByUsernameAndPhone(@Param("u") String username, @Param("p") String phone);

    @Query(value = "select a from Account a where a.role.id=3 order by a.id desc")
    List<Account> findAccountUser();

    @Query("select a from Account  a where a.status.id= :status_id")
    List<Account> findAllByStatus(@Param("status_id") int status_id);

    @Transactional
    @Modifying
    @Query(value = "update account set status_id = :status_id where id = :idAccount", nativeQuery = true)
    void updateStatus(@Param("status_id") int status_id, @Param("idAccount") int idAccount);

    @Query("select a from Account a where a.role.id= :role_id")
    List<Account> findAccountByRole(@Param("role_id") int role_id);

    @Query(value = "select DISTINCT a from Account a join Message m on (a.id=m.receiverAccount.id or a.id=m.senderAccount.id) where (m.senderAccount.id=:idAccount or m.receiverAccount.id=:idAccount) and a.id!=:idAccount and a.role.id!=1")
    List<Account> findAccountsYouMessaged(@Param("idAccount") int idAccount);

    @Query("SELECT a FROM Account a WHERE a.username LIKE %:username% and (a.role.id=2 or a.role.name='ROLE_HOST') and (a.status.name!='BLOCKED' or a.status.id!=3)")
    List<Account> findAccountHostByUsername(@Param("username") String username);
    @Query("select a from Account a where a.password= :password")
    Account findAccountByPassword(@Param("password") String password);

    @Query(value = "select a from Account a order by a.id desc")
    List<Account> findAllByIdDesc();

    @Modifying
    @Transactional
    @Query(value = "update Account a set a.role.id=:roleId, a.status.id=:statusId where a.id=:accountId")
    void updateAccountToHost(@Param("roleId") int roleId, @Param("statusId") int statusId, @Param("accountId") int accountId);
}
