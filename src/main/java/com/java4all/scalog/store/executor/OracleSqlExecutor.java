package com.java4all.scalog.store.executor;

import com.java4all.scalog.annotation.LoadLevel;
import com.java4all.scalog.store.LogInfoDto;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Oracle SqlExecutor
 * @author wangzhongxiang
 */
@LoadLevel(name = "oracle")
public class OracleSqlExecutor implements BaseSqlExecutor{

    private static final Logger LOGGER = LoggerFactory.getLogger(OracleSqlExecutor.class);

    private DataSource dataSource;

    public OracleSqlExecutor() {
    }

    public OracleSqlExecutor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * insert
     */
    @Override
    public void insert(LogInfoDto dto) throws Exception{
        //TODO
        throw new NoSuchMethodException("Not support Oracle now!");
    }


    /**
     * insert batch
     */
    @Override
    public void insertBatch(List<LogInfoDto> dtos) throws Exception {
        throw new UnsupportedOperationException();
    }
}
