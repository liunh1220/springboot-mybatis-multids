package com.example.demo.model.po;

public interface DataSourceNames {

    /**
     * 非默认数据源前缀
     */
    String DB_CUSTOM_PREFIX_KEY = "custom.datasource";

    /**
     * 测试库
     */
    String DB_TEST= "test";

    /**
     * 读库
     */
    String DB_READ = "read";
    /**
     * 分库写
     */
    String DB_WRITE = "custom.datasource.write";


    /**
     * sharding 不用真正映射物理库
     */
    String SHARDING_RP_WRITE = "shard.write.user";
    String SHARDING_RP_READ="shard.read.user";

}
