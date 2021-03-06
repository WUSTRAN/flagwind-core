package com.flagwind.events;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.flagwind.commons.ConverterUtils;

public class EventProviderFactory {

    private ConcurrentMap<Object, EventProvider<?>> providers;
    private static EventProviderFactory instance;

    /**
     * 初始化事件提供程序工厂的新实例。
     */
    public EventProviderFactory() {
        providers = new ConcurrentHashMap<>();

    }

    /**
     * 获取所有事件提供程序。
     * 
     * 
     * @return IMap<any, IEventProvider>
     */
    protected ConcurrentMap<Object, EventProvider<?>> getProviders() {
        return this.providers;
    }

    /**
     * 获取事件提供程序工厂的单实例。
     * 
     * 
     * 
     * @return EventProviderFactory
     */
    public static EventProviderFactory getInstance() {
        if (instance == null) {
            instance = new EventProviderFactory();
        }

        return instance;
    }

    /**
     * 获取指定事件源的事件提供程序。
     * 
     * @param source IEventProvider 所抛出事件对象的源对象。
     * @return EventProdiver 返回指定名称的事件提供程序。
     */
    public <T extends EventArgs> EventProvider<T> getProvider(Object source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        EventProvider<T> provider = ConverterUtils.cast( this.providers.get(source));

        if (provider == null) {
            provider = this.createProvider(source);

            this.providers.put(source, provider);
        }

        return provider;
    }

    /**
     * 根据指定事件源创建一个事件提供程序。
     * 
     * @param source IEventProvider 所抛出事件对象的源对象。
     * @return IEventProvider 事件提供程序实例。
     */
    protected <T extends EventArgs> EventProvider<T> createProvider(Object source) {
        return new EventProvider<T>(source);
    }
}
