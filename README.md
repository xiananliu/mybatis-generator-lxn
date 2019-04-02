# mybatis-generate-lxn

根据mybatis-generate插件修改而来,原作者地址 :https://gitee.com/rohou


定制化修改如下：

1. 删除无用的空mapper
2. 增加对 mybatis-paginator 的支持,参考 https://github.com/miemiedev/mybatis-paginator
3. 增加批量插入
4. 增加insert (...) values(...) ON DUPLICATE KEY UPDATE a=b,c=d,e=f
5. 增加对CDSRouter的支持(内部功能)

生成的mapper 如下：
```
public interface OrderBaseMapper {

    int insertOrder(Order object);

    int insertBatchOrder(@Param("list") List<Order> object);

    int insertBatchOrder(@Param("list") List<Order> object,CDSRouter cdsRouter);

    int updateOrder(Order object);

    int update(Order.UpdateBuilder object);

    int insertOrUpdate(@Param("add")Order insert,@Param("set")Order update);

    PageList<Order> queryOrder(@Param("object")Order object,PageBounds pageBounds);

    PageList<Order> queryOrder(@Param("object")Order object,PageBounds pageBounds,CDSRouter cdsRouter);

    Order queryOrderLimit1(Order object);

    Order queryOrderLimit1(Order object,CDSRouter cdsRouter);

}

```

