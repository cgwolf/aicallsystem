package com.aicallsystem.acs.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * <p>
 *      swagger2 配置文件
 * </p>
 * @author ispong
 * @since 4/2/2019
 * @version 1.0.0
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    @Autowired
//    private TypeResolver typeResolver;

//    private ApiKey apiKey() {
//        return new ApiKey("mykey", "api_key", "header");
//        return new ApiKey("Authorization", "Authorization", "header");
//    }

//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope
//                = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return newArrayList(
//                new SecurityReference("mykey", authorizationScopes)
//                new SecurityReference("Authorization", authorizationScopes)
//        );
//    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("/anyPath.*"))
//                .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("人工智能拨号系统-接口文档")
//                .contact(new Contact("asc", "", ""))
//                .version("1.0.0")
//                .description("人工智能拨号系统")
                .build();
    }

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.aicallsystem.acs.controller"))
//                .paths(PathSelectors.any())
//                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build()
//                .pathMapping("/")
//                .directModelSubstitute(LocalDate.class, String.class)
//                .genericModelSubstitutes(ResponseEntity.class)
//                .alternateTypeRules(
//                        newRule(typeResolver.resolve(DeferredResult.class,
//                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
//                                typeResolver.resolve(WildcardType.class)))
//                .useDefaultResponseMessages(false)
//                .globalResponseMessage(RequestMethod.GET,
//                        newArrayList(new ResponseMessageBuilder()
//                                .code(500)
//                                .message("500 message")
//                                .responseModel(new ModelRef("Error"))
//                                .build()))
//                .securitySchemes(newArrayList(apiKey()))
//                .securityContexts(newArrayList(securityContext()))
//                .enableUrlTemplating(true)
                .globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("token")
                                .description("验证令牌")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build()))
//                .tags(new Tag("Pet Service", "All apis relating to pets"))
//                .additionalModels(typeResolver.resolve(AdditionalModel.class))
                ;
    }

//    @Bean
//    SecurityConfiguration security() {
//        return SecurityConfigurationBuilder.builder()
//                .clientId("test-app-client-id")
//                .clientSecret("test-app-client-secret")
//                .realm("test-app-realm")
//                .appName("test-app")
//                .scopeSeparator(",")
//                .additionalQueryStringParams(null)
//                .useBasicAuthenticationWithAccessCodeGrant(false)
//                .build();
//    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder
                .builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }

}
