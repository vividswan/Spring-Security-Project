package com.security.vividswan.oauth.provider;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UsreInfo{

    private Map<String ,Object> attributes;

    public GoogleUserInfo(Map<String ,Object> attributes){
        this.attributes = attributes;
    }

    @Override
    public String getProvider() {
        return (String)attributes.get("sub");
    }

    @Override
    public String getProviderId() {
        return "google";
    }

    @Override
    public String getName() {
        return (String)attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String)attributes.get("email");
    }
}
