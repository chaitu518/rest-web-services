package com.chaitu.rest.webservices.restwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	private static int count=0;
	static {
		users.add(new User(++count,"Surya",LocalDate.now().minusYears(10)));
		users.add(new User(++count,"Gowtham",LocalDate.now().minusYears(10)));
		users.add(new User(++count,"Raju",LocalDate.now().minusYears(10)));
		users.add(new User(++count,"Yaswanth",LocalDate.now().minusYears(10)));
	}
	public List<User> findAll(){
		return users;
	}
	public User save(User user){
		user.setId(++count);
		users.add(user);
		return user;
	}
	public User findOne(int id){
		Predicate<? super User> predicate = user->user.getId()==id;
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	public void deleteById(int id){
		Predicate<? super User> predicate = user->user.getId()==id;
		users.removeIf(predicate);
		
	}

}
