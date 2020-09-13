package com.security.vividswan.oauth;

import com.security.vividswan.auth.PrincipalDetails;
import com.security.vividswan.model.User;
import com.security.vividswan.oauth.provider.FacebookUserInfo;
import com.security.vividswan.oauth.provider.GoogleUserInfo;
import com.security.vividswan.oauth.provider.OAuth2UsreInfo;
import com.security.vividswan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        OAuth2UsreInfo userInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            userInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            userInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        }

        String provider = userInfo.getProvider();
        String providerId = userInfo.getProviderId();
        String username = provider + "_" + providerId;
        String password = bCryptPasswordEncoder.encode("vividswan");
        String email =  userInfo.getEmail();
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername("username");
        if(userEntity == null){
            userEntity = new User().builder()
                    .username(username)
                    .provider(provider)
                    .providerId(providerId)
                    .password(password)
                    .email(email)
                    .role(role)
                    .build();
            userRepository.save(userEntity);
        }

        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }
}
