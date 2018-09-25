package com.example.demo.base.sharding.write;

import com.dangdang.ddframe.rdb.sharding.api.rule.BindingTableRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.example.demo.base.sharding.ShardingDataSourceFactoryBean;
import com.example.demo.base.sharding.ShardingTableRule;
import com.example.demo.model.po.DataSourceNames;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 写库分离
 */
public class RecordShardingDataSourceFactoryBean extends ShardingDataSourceFactoryBean {

    ShardingInfo shardingInfo = ShardingInfo.getInstance();

    @Override
    protected ShardingRule createShardingRule() {
        DataSourceRule dataSourceRule = new DataSourceRule(createDataSourceMap());
        ShardingTableRule recordTable = new ShardingTableRule("t_user");
        //ShardingTableRule recordTableDispatch = new ShardingTableRule("cgt_redpacket_dispatch");

        TableRule recordTableRule = TableRule.builder(recordTable.getLogicTableName()).actualTables(recordTable.getActualTableNames()).dataSourceRule(dataSourceRule).build();
        //TableRule recordTableRuleDispatch = TableRule.builder(recordTableDispatch.getLogicTableName()).actualTables(recordTableDispatch.getActualTableNames()).dataSourceRule(dataSourceRule).build();

        /*ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule).tableRules(Arrays.asList(recordTableRule,recordTableRuleDispatch))
                .bindingTableRules(Collections.singletonList(new BindingTableRule(Arrays.asList(recordTableRule,recordTableRuleDispatch))))
                .tableShardingStrategy(new TableShardingStrategy(shardingInfo.shardingKeys, new TableShardingAlgorithm())).build();*/
        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule).tableRules(Arrays.asList(recordTableRule))
                .bindingTableRules(Collections.singletonList(new BindingTableRule(Arrays.asList(recordTableRule))))
                .tableShardingStrategy(new TableShardingStrategy(shardingInfo.shardingKeys, new TableShardingAlgorithm())).build();

        return shardingRule;
    }

    protected Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
       result.put(DataSourceNames.DB_WRITE, (DataSource)beanFactory.getBean(DataSourceNames.DB_WRITE, DataSource.class));
        return result;
    }


}
