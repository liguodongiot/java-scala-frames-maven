

### 反射
```
通过返回去回调某个类的某个方法
```


### 设计模式

#### 类与类之间的关系
```
类与类之间的关系
1、依赖：形参|局部变量
2、关联：属性
    聚合：属性  整体与部分 不一致的生命周期 人与手
    组合：属性 整体与部分 一致的生命周期 人与大脑
3、继承：父子类关系
4、实现：接口与实现类关系
```

**design.pattern.relation**

#### 单例设计模式
**design.pattern.singleton**



#### 装饰设计模式
**design.pattern.decorator**
```
饿汉式
HungryManSingleton
懒汉式
LazyManSingleton
静态内部类式
StaticInnerSingleton
反射破解单例
ReflectCrackSingleton
反序列化破解单例
SerializableCrackSingleton
防止反射破解单例
SloveReflectSingleton
防止反序列化破解单例
SloveSerializableSingleton

注：反射和反序列化不能破解枚举创建的单例。
```

****

****
****