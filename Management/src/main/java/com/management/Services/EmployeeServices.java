package com.management.Services;
import com.management.Entity.Employee;
import com.management.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepo repo;
    public List<Employee>listAll(){
    	try {
        return repo.findAll();}
    	catch(Exception ex) {
    		return null;
    	}
    }
    public void  save(Employee employee)
    {
    	try {
    		repo.save(employee);
    	}
        catch(Exception ex) {
        	
        }
    }
    public  Employee get(Long id){
    	try {
    		return repo.findById(id).get();
    	}
        catch(Exception ex) {
        	return null;
        }
    }
    public  void  delete(Long id){
    	try {
    		 repo.deleteById(id);
    	}
       catch(Exception ex) {
    	   
       }
    }
}
