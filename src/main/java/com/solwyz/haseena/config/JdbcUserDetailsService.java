package com.solwyz.haseena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.solwyz.haseena.entity.User;
import com.solwyz.haseena.repo.UserRepository;

@Service
public class JdbcUserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    

        public CurrentUser loadUserByUsernameAndPass(String username, String rawPassword) throws Exception {
            User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
                throw new BadCredentialsException("Invalid password");
            }

            return new CurrentUser(user); // Make sure this constructor exists
        }
    }

//
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.solwyz.haseena.entity.User;
//import com.solwyz.haseena.repo.UserRepository;
//
//@Component
//public class JdbcUserDetailsService implements UserDetailsService {
// 
//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Autowired
//	private UserRepository userRepo;
// 
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		Optional<User> userEntity = userRepo.findByUserName(userName);
// 
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
////		Collection<Role> roles = userEntity.get().getRoles();
////		for (Role role : roles) {
////			authorities.add(new SimpleGrantedAuthority(role.getName()));
////		}
// 
//		return new org.springframework.security.core.userdetails.User(userEntity.get().getUserName(), "", authorities);
// 
//	}
// 
//	public CurrentUser loadUserByUsernameAndPass(String username, String password) {
//		Optional<User> userEntity = userRepo.findByUserName(username);
//		if (userEntity.isEmpty()) {
//			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//		} else {
//			boolean match = bCryptPasswordEncoder.matches(password, userEntity.get().getPassword());
//			if (!match) {
//				throw new UsernameNotFoundException(String.format("Incorrect Password for '%s'.", username));
//			}
//			if (!userEntity.get().getIsActive()) {
// 
//				throw new UsernameNotFoundException(String.format("User is Inactive"));
//			}
//		}
// 
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		Collection<Role> roles = userEntity.get().getRoles();
//		for (Role role : roles) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
//		// authorities.add(new SimpleGrantedAuthority(userEntity.get().getMemberOf()));
//		CurrentUser currentUser = new CurrentUser(username, "", authorities);
// 
//		CopyPropertiesUtil.copyProperties(userEntity.get(), currentUser);
// 
//		return currentUser;
//	}
// 
//	public CurrentUser getCurrentUser(User user) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		Collection<Role> roles = user.getRoles();
//		for (Role role : roles) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
// 
//		CurrentUser currentUser = new CurrentUser(user.getUserName(), "", authorities);
// 
//		CopyPropertiesUtil.copyProperties(user, currentUser);
// 
//		return currentUser;
//	}
// 
//	public CurrentUser loadCustomerUserByUsername(String username) {
//		Optional<User> userEntity = userRepo.findByUserName(username);
//		if (userEntity.isEmpty()) {
//			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
//		} else {
////			if (!userEntity.get().getIsActive()) {
////				throw new UsernameNotFoundException(String.format("User is Inactive"));
////			}
//		}
// 
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		Collection<Role> roles = userEntity.get().getRoles();
// 
//		for (Role role : roles) {
//			authorities.add(new SimpleGrantedAuthority(role.getName()));
//		}
// 
//		CurrentUser currentUser = new CurrentUser(username, "", authorities);
// 
//		CopyPropertiesUtil.copyProperties(userEntity.get(), currentUser);
// 
//		return currentUser;
//	}
//}