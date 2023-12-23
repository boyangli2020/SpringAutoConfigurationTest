package org.example.monkeysearch.spring.boot.autoconfigure;

import org.example.monkeysearch.Searcher;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.SmartLifecycle;

public class MonkeySearchFactoryBean implements FactoryBean<Searcher>, InitializingBean, SmartLifecycle {

    private Searcher searcher;

    @Override
    public void afterPropertiesSet() {
        searcher = new Searcher();
    }

    @Override
    public Searcher getObject() {
        return searcher;
    }

    @Override
    public Class<?> getObjectType() {
        return (searcher != null ? this.searcher.getClass() : Searcher.class);
    }

    @Override
    public void start() {
        searcher.start();
    }

    @Override
    public void stop() {
        searcher.stop();
    }

    @Override
    public boolean isRunning() {
        if (searcher == null) {
            return false;
        }
        if (searcher.getSearchThread() == null) {
            return false;
        }
        return searcher.getSearchThread().isAlive();
    }

}
