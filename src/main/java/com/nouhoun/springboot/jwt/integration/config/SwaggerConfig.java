package com.nouhoun.springboot.jwt.integration.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${security.jwt.client-id}")
    private String clientId;

    @Value("${security.jwt.client-secret}")
    private String clientSecret;

    public static final String securitySchemaOAuth2 = "oauth2";
    public static final String authorizationScopeGlobal = "global";
    public static final String authorizationScopeGlobalDesc = "accessEverything";

    @Bean
    public Docket api() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        schemeList.add(securitySchema());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()/*
                .apis(RequestHandlerSelectors.basePackage("com.nouhoun.springboot.jwt.integration.controller"))*/
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(schemeList)
                .securityContexts(Collections.singletonList(securityContext()));
    }

    private OAuth securitySchema() {

        List<AuthorizationScope> authorizationScopeList = newArrayList();
        authorizationScopeList.add(new AuthorizationScope("global", "access all"));

        List<GrantType> grantTypes = newArrayList();
        final TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint("http://localhost:8080/oauth/token", clientId, clientSecret);
        final TokenEndpoint tokenEndpoint = new TokenEndpoint("http://localhost:8080/oauth/token", "access_token");
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint);

        grantTypes.add(authorizationCodeGrant);

        OAuth oAuth = new OAuth("oauth", authorizationScopeList, grantTypes);

        return oAuth;
    }


    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant("/**")).build();
    }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope authorizationScope =
                new AuthorizationScope(authorizationScopeGlobal, authorizationScopeGlobalDesc);
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections
                .singletonList(new SecurityReference(securitySchemaOAuth2, authorizationScopes));
    }
}

