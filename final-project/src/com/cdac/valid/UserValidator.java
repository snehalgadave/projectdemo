package com.cdac.valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cdac.dto.User;

@Service
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName","unmKey", "User Name required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPass", "passKey","User Password required.");
		
		User user = (User)target;
		if(user.getUserPass()!=null) {
			if(user.getUserPass().length()<3) { 
				errors.rejectValue("userPass", "passKey", " User Password should contain more than 2 characters.");
			}
		}
		
		User user1 = (User)target;
		if(user1.getUserPass()!=null) {
			if(user1.getUserName().length()<3) { 
				errors.rejectValue("userName", "passKey", "User Name should contain more than 2 characters.");
			}
		}
		
		
	}
	
}
