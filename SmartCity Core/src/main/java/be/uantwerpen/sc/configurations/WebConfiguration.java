package be.uantwerpen.sc.configurations;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Thomas on 25/02/2016.
 */
@Configuration
public class WebConfiguration
{
    @Bean
    @Profile("dev")
    ServletRegistrationBean h2servletRegistration()
    {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2console/*");

        return registrationBean;
    }
}
