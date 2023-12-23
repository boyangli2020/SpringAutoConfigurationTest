package org.example.monkeysearch.spring.boot.autoconfigure;

import org.example.monkeysearch.Searcher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Searcher.class)
public class MonkeySearchAutoConfiguration {

    /*
    @Bean
    @ConditionalOnMissingBean(Searcher.class)
    public Searcher monkeySearcher(){
        return new Searcher();
    }
    */

    @Bean
    @ConditionalOnMissingBean(Searcher.class)
    public MonkeySearchFactoryBean monkeySearcher() {
        return new MonkeySearchFactoryBean();
    }

}
