package com.java4all.scalog.store.executor;

import com.java4all.scalog.annotation.LoadLevel;
import com.java4all.scalog.store.LogInfoDto;
import com.java4all.scalog.store.sql.PostgreSqlSql;
import com.java4all.scalog.utils.SourceUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * @author wangzhongxiang
 */
@LoadLevel(name = "postgresql")
public class PostgreSqlExecutor implements BaseSqlExecutor{

    private static final Logger LOGGER = LoggerFactory.getLogger(PostgreSqlExecutor.class);

    private DataSource dataSource;

    public PostgreSqlExecutor() {
    }

    public PostgreSqlExecutor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * insert
     */
    @SuppressWarnings("all")
    @Override
    public void insert(LogInfoDto dto) throws Exception {
        DataSource source = dataSource;
        Connection connection = null;
        try {
            connection = source.getConnection();
            connection.setAutoCommit(true);
            PreparedStatement ps = connection.prepareStatement(PostgreSqlSql.INSERT_LOG_SQL);
            ps = this.preparePs(ps, dto);
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error("log info insert failed,But it does not affect business logic:{}",e.getMessage(),e);
        } finally {
            SourceUtil.close(connection);
        }
    }


    /**
     * insert batch
     */
    @Override
    public void insertBatch(List<LogInfoDto> dtos) throws Exception {
        DataSource source = dataSource;
        Connection connection = null;
        try {
            connection = source.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(PostgreSqlSql.INSERT_LOG_SQL);
            if (!CollectionUtils.isEmpty(dtos)) {
                for (LogInfoDto dto : dtos) {
                    ps = this.preparePs(ps, dto);
                    ps.addBatch();
                }
            }
            ps.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.error("log info insert failed,But it does not affect business logic:{}",e.getMessage(),e);
        } finally {
            SourceUtil.close(connection);
        }
    }

}
