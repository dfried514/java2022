package com.friedman.tvshows.services;

import java.util.ArrayList;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.friedman.tvshows.models.LoginUser;
import com.friedman.tvshows.models.Rating;
import com.friedman.tvshows.models.Show;
import com.friedman.tvshows.models.User;
import com.friedman.tvshows.repositories.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	// Reject if email is taken (present in database)
    	if (potentialUser.isPresent())
    		result.rejectValue("email", "exists", "This email already exists in the system!");
    	// Reject if password doesn't match confirmation
    	if (!newUser.getPassword().equals(newUser.getConfirm()))
    		result.rejectValue("password", "notMatching", "Password and confirm password do not match!");
    	// Return null if result has errors
    	if (result.hasErrors())
    		return null;
    	// Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	
    	return userRepo.save(newUser);
    }

    
    
    // This method will be called from the controller
    // whenever a user submits a login form.
        public User login(LoginUser newLoginObject, BindingResult result) {
        	// TO-DO - Reject values:
        	// Find user in the DB by email
        	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        	// Reject if NOT present
        	if (!potentialUser.isPresent()) {
        		result.rejectValue("email", "notFound", "This email was not found in the system!");
        		return null;
        	}
        	// User exists, retrieve user from database
        	User user = potentialUser.get();
        	// Reject if BCrypt password match fails
        	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
        		result.rejectValue("password", "Matches", "Invalid Password!");
        	} // Return null if result has errors
        	if (result.hasErrors())
        		return null;
        	// Otherwise, return the user object
        	return user;
        }
        
        public User findUser(Long id) {
        	Optional<User> optionalUser = userRepo.findById(id);
        	if (optionalUser.isPresent())
        		return optionalUser.get();
        	return null;
        }
        
        public User addRating(Long id, Rating rating) {
        	Optional<User> optionalUser = userRepo.findById(id);
        	if (optionalUser.isPresent()) {
        		User user = optionalUser.get();
        		user.getRatedShows().add(rating);
        		return optionalUser.get();
        	}
        	return null;
        }
   
}
