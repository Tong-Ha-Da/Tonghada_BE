package com.github.tonghada.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
    //    TypeResolver typeResolver = new TypeResolver();
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.tonghada.controller")) // //  Swagger API 문서로 만들기 원하는 BasePackage 경로. (필수)
                .paths(PathSelectors.any()) // URL 경로를 지정하여 해당 URL에 해당하는 요청만 Swagger API 문서로 만든다. (any()로 설정 시 모든 api가 보여짐, (필수))
                .build()
                .apiInfo(apiInfo()) // Swagger API 문서에 대한 설명을 표기하는 메소드. (선택)
                .consumes(Collections.singleton(MediaType.MULTIPART_FORM_DATA_VALUE)) // 서버로 보낼 데이터의 Content-type을 설정
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE)); // 클라이언트에게 전송할 데이터의 Content-type을 설정
//                .ignoredParameterTypes(CustomUserDetail.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("통하다")
                .description("TongHaDa API 리스트입니다.")
                .version("1.0")
                .build();
    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("Authorization", "Authorization", "header");
//    }


}
