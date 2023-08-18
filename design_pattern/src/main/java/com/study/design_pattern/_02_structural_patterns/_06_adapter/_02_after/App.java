package com.study.design_pattern._02_structural_patterns._06_adapter._02_after;

import com.study.design_pattern._02_structural_patterns._06_adapter._02_after.security.UserDetailsService;
import com.study.design_pattern._02_structural_patterns._06_adapter._02_after.security.LoginHandler;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        loginHandler.login("hsb", "hsb");
    }
}
