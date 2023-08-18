package com.study.design_pattern._02_structural_patterns._06_adapter._01_before.security;

public interface UserDetailsService {
    
    UserDetails loadUser(String username);
    
}
