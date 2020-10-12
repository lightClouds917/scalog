package com.java4all.scalog.store.executor;

import com.java4all.scalog.store.LogInfoDto;
import com.java4all.scalog.utils.SourceUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wangzhongxiang
 */
public interface BaseSqlExecutor {

    Logger LOGGER = LoggerFactory.getLogger(BaseSqlExecutor.class);

    /**
     * insert
     *
     * @param dto
     * @throws Exception
     */
    void insert(LogInfoDto dto) throws Exception;

    /**
     * insert batch
     * @param dtos
     * @throws Exception
     */
    void insertBatch(List<LogInfoDto> dtos) throws Exception;

    default PreparedStatement preparePs(PreparedStatement ps,LogInfoDto dto) {
        try {
            ps.setString(1, SourceUtil.generateId());
            ps.setString(2,dto.getCountryName());
            ps.setString(3,dto.getGroupName());
            ps.setString(4,dto.getOrganizationName());
            ps.setString(5,dto.getCompanyName());
            ps.setString(6,dto.getProjectName());
            ps.setString(7,dto.getModuleName());
            ps.setString(8,dto.getFunctionName());
            ps.setString(9,dto.getClassName());
            ps.setString(10,dto.getMethodName());
            ps.setString(11,dto.getMethodType());
            ps.setString(12,dto.getUrl());
            ps.setString(13,dto.getRequestParams());
            ps.setString(14,dto.getResult());
            ps.setString(15,dto.getRemark());
            ps.setLong(16,dto.getCost());
            ps.setString(17,dto.getIp());
            ps.setString(18,dto.getUserId());
            ps.setString(19,dto.getUserId());
            ps.setString(20,dto.getClientType());
            ps.setString(21,dto.getUserAgent());
            ps.setInt(22,1);
            ps.setString(23,dto.getGmtStart());
            ps.setString(24,dto.getGmtEnd());
            ps.setString(25,dto.getErrorMessage());
            ps.setString(26,dto.getErrorStackTrace());
        } catch (SQLException e) {
            LOGGER.error("Prepare preparedStatement failed,But it does not affect business logic:{}",e.getMessage(),e);
        }
        return ps;
    }
}
