package com.animeinfo.animeInfo.configuration;

import com.animeinfo.api.config.ApiSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends ApiSecurityConfig {
    @Override
    protected void configureHttpSecurity(HttpSecurity http) throws Exception {

    }

    @Override
    protected List<String> getCustomFreeAccessPaterns() {
        return new ArrayList<>(Arrays.asList("/api/v1/anime", "/api/v1/anime/data", "/api/v1/anime/{id}"));
    }
}
