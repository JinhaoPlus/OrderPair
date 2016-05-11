package com.jinhaoplus.oj.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jinhaoplus.oj.dao.PairDao;
import com.jinhaoplus.oj.domain.Pair;


@Repository
public class PairDaoImpl extends SqlMapClientDaoSupport implements PairDao{

	@Resource(name = "dataSource")  
    private DataSource dataSource;  
    @PostConstruct  
        public void initDataSource(){  
         super.setDataSource(dataSource);
    }   

	@Resource(name = "sqlMapClient")  
    private SqlMapClient sqlMapClient;  
    @PostConstruct  
        public void initSqlMapClient(){  
         super.setSqlMapClient(sqlMapClient);  
    }   

    @Override
    public Pair getPairByBitCode(String bitCode){
    	return (Pair)getSqlMapClientTemplate().queryForObject("getPair",bitCode);
    }
}
