package com.jsk.mylogue.main.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseDao {

    public SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 상세조회
     *
     * @param sqlId
     * @param param
     * @return
     */
    public Object select(String sqlId, Object param) {
        logger.debug("select {}", sqlId);
        return sqlSessionTemplate.selectOne(sqlId, param);
    }

    public Object select(String sqlId) {
        return select(sqlId, null);
    }

    /**
     * 목록조회
     *
     * @param sqlId
     * @param param
     * @return
     */
    public List<?> list(String sqlId, Object param) {
        return sqlSessionTemplate.selectList(sqlId, param);
    }

    public List<?> list(String sqlId) {
        return list(sqlId, null);
    }

    /**
     * 등록
     *
     * @param sqlId
     * @param param
     * @return
     */
    public Object insert(String sqlId, Object param) {
        return sqlSessionTemplate.insert(sqlId, param);
    }

    public Object insert(String sqlId) {
        return insert(sqlId, null);
    }

    /**
     * 수정
     *
     * @param sqlId
     * @param param
     * @return
     */
    public int update(String sqlId, Object param) {
        return sqlSessionTemplate.update(sqlId, param);
    }

    public int update(String sqlId) {
        return update(sqlId, null);
    }

    /**
     * 삭제
     *
     * @param sqlId
     * @param param
     * @return
     */
    public int delete(String sqlId, Object param) {
        return sqlSessionTemplate.delete(sqlId, param);
    }

    public int delete(String sqlId) {
        return delete(sqlId, null);
    }

}
