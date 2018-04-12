package ukraine.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/*
Аннотации:
В данной конфигурации мы указываем, где искать все наши контроллеры, сервисы и другие компоненты
 с помощью тега: context:component-scan,
 а также инициализируем InternalResourceViewResolver, который отвечайте за показ View в нашем случае это jsp страницы.

@Configuration — собственно эта аннотация и говорит о том, что данный класс является Java Configuration;
@EnableWebMvc — эта аннотация разрешает нашему проекту использовать MVC;
@ComponentScan(«com.devcolibri.common») — аналогично тому component-scan который
 был в mvc-dispatcher-servlet.xml, говорит, где искать компоненты проекта.
Bean — указывает на то что это инициализация бина, и он будет создан с помощью DI.

Конфигурация

WebMvcConfigurerAdapter — унаследовавшись от этого класса мы получим возможность сконфигурировать ResourceLocations.
addResourceHandlers(ResourceHandlerRegistry registry) — переопределив данный метод мы
можем указать где будут лежать ресурсы нашего проекта, такие как css, image, js и другие.
InternalResourceViewResolver — аналогичная конфигурация с mvc-dispatcher-servlet.xml.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ukraine.example")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/pages/**").addResourceLocations("/pages/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }
}
