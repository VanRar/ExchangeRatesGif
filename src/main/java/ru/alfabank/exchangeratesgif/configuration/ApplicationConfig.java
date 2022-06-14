package ru.alfabank.exchangeratesgif.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.alfabank.exchangeratesgif.dto.DevelopersGiphyProperties;
import ru.alfabank.exchangeratesgif.dto.OpenExchangeRatesProperties;
import ru.alfabank.exchangeratesgif.interceptor.EndPointValidationInterceptor;


@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
    private final EndPointValidationInterceptor endPointValidationInterceptor;

    public ApplicationConfig(EndPointValidationInterceptor endPointValidationInterceptor) {
        this.endPointValidationInterceptor = endPointValidationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(endPointValidationInterceptor);
    }

    @Bean
    @ConfigurationProperties("openexchangerates")
    OpenExchangeRatesProperties openExchangeRatesProperties() {
        return new OpenExchangeRatesProperties();
    }

    @Bean
    @ConfigurationProperties("developersgiphy")
    DevelopersGiphyProperties developersGiphyProperties() {
        return new DevelopersGiphyProperties();
    }
}
