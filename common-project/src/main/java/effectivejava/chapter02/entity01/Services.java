package effectivejava.chapter02.entity01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务提供者框架
 * Created by liguodong on 2016/11/28.
 */

//不可实例化类 用于 服务注册和访问
public class Services {
    //私有构造器阻止实例
    private Services(){}

    private static final Map<String,Provider> providers = new ConcurrentHashMap<String,Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    //提供者 注册API
    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME,p);
    }

    public static void registerProvider(String name,Provider p){
        providers.put(name,p);
    }

    //服务 访问API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if(p == null){
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }

}
