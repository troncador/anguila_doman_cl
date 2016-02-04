package cl.doman.anguila.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import cl.doman.anguila.spring.converter.CountryConverter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "cl.doman.anguila.controller")
public class WebConfig extends WebMvcConfigurerAdapter {
	static Logger log =LoggerFactory.getLogger(WebConfig.class);

	public WebConfig(){
		log.info(WebConfig.class.getName());
	}
	
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }
	
	@Bean
    //@Description("Thymeleaf template resolver serving HTML 5")
    public TemplateResolver templateResolver() {
		
        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix("/opt/html/troncador/mandomedio/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        
        return templateResolver;
    }
    
    @Bean
    //@Description("Thymeleaf template engine with Spring integration")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        TemplateResolver templateResolver = templateResolver();
        templateEngine.setTemplateResolver(templateResolver);
        
        return templateEngine;
    }
    
    @Bean
    //@Description("Thymeleaf view resolver")
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        SpringTemplateEngine springTemplateEngine = templateEngine();
        viewResolver.setTemplateEngine(springTemplateEngine);
        
        return viewResolver;
    }
    
    @Bean
    //@Description("Spring message resolver")
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();  
        messageSource.setBasename("i18n/messages");  
        
        return messageSource;  
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }  
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration resourceRegistration = registry.addResourceHandler("/resources/**");
        resourceRegistration.addResourceLocations("file:/opt/html/troncador/mandomedio/resources/");
    }
}