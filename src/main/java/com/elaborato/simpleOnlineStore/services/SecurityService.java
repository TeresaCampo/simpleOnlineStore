package com.elaborato.simpleOnlineStore.services;

public interface SecurityService {
    public boolean isUserAuthenticated() ;

    public String getAuthenticatedUserName() ;
}
