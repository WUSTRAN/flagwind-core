package com.flagwind.services;

public interface ServiceStorage extends Iterable<ServiceEntry>
{
    /**
     * 添加一个服务项至仓储中。
     * @param  entry 服务项实例。
     * 
     */
   boolean add(ServiceEntry entry);

    /**
     * 清空当前仓储下的所有服务项。
     * 
     */
   void clear();

    /**
     * 移除指定的服务名对应的服务项。
     * @param  name 服务名称。
     * @return ServiceEntry 服务项实例
     */
    ServiceEntry remove( String name);

    /**
     * 获取指定名称的服务项实例。
     * @param  name
     * @return ServiceEntry 服务项实例。
     */
    ServiceEntry get( String name) ;
    /**
     * 获取指定服务类型对应的服务项实例。
     * @param  serviceType 服务类型。
     * @return ServiceEntry 服务项实例。
     */
    ServiceEntry  get(Class<?> serviceType);

    /**
     * 获取指定服务类型的所有服务项实例。
     * @param serviceType 服务类型。
     * @return Iterable<ServiceEntry> 服务项列表。
     */
    Iterable<ServiceEntry> getAll(Class<?> serviceType) ;

}
