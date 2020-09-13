package com.security.vividswan.oauth.provider;

public interface OAuth2UsreInfo {
    String getProvider();
    String getProviderId();
    String getName();
    String getEmail();
}