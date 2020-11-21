package com.bankapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bankapp.dao.exceptions.AccountNotFoundException;
@Primary
@Repository
public class AccountDaoImplJdbc implements AccountDao{
private DataSource datasource;
	@Autowired
	public AccountDaoImplJdbc(DataSource datasource) {
	this.datasource = datasource;
}
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts=new ArrayList<>();
        Account account=null;
        try {
            Connection connection=datasource.getConnection();
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from account");
            while(rs.next()) {
                account=new Account(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("balance"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return accounts;
	}

	@Override
	public void update(Account account) {
		Connection con;
		Account accountUpdate = findAccountById(account.getId());
		try {
			con=datasource.getConnection();
			PreparedStatement pst=con.prepareStatement("update account set balance= ?  where id =?");	
			pst.setInt(1, account.getBalance());
			pst.setInt(2,account.getId() );
			pst.executeUpdate();
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		
	}

	@Override
	public Account findAccountById(int id) {
		Connection con;
		Account account = null;
		try {
			con=datasource.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from account where id =?");	
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				account =new Account(
						rs.getInt("id"),
						rs.getString("name"), 
						rs.getInt("balance"));
			}else {
				throw new AccountNotFoundException("account with id ="+id+"not found");
			}
		
		
		}catch (Exception e) {
		e.printStackTrace();
		}
		return account;
	}

}
