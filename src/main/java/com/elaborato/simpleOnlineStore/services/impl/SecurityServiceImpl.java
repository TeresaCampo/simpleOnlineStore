package com.elaborato.simpleOnlineStore.services.impl;

import com.elaborato.simpleOnlineStore.services.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Override
    public boolean isUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser");
    }
    @Override
    public String getAuthenticatedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (isUserAuthenticated()) {
            return authentication.getName();
        }
        return null;
    }
}
