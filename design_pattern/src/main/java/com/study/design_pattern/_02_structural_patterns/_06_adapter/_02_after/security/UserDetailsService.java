package com.study.design_pattern._02_structural_patterns._06_adapter._02_after.security;

public interface UserDetailsService {
    
    UserDetails loadUser(String username);
    
}
