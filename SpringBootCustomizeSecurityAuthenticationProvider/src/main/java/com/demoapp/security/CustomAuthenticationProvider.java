package com.demoapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        logger.info("Name = " + name + " ,Password = " + password);
        UserDetails user=  userDetailsService.loadUserByUsername(name);
//        // use the credentials and authenticate against the third-party system
//        if(("user".equals(name) && "user".equals(password)) 
//        		|| ("admin".equals(name) && "admin".equals(password))){
//        	logger.info("Succesful authentication!");
//         
//        	return new UsernamePasswordAuthenticationToken(name, password, authors);	
//        }
        if(""!=user.getUsername()&&null!=user.getUsername()){
        	return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());	
        }
        logger.info("Login fail!");
        
        return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
