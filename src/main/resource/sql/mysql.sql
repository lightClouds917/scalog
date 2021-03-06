# create table
CREATE TABLE `log_info` (
    `id` char(50) NOT NULL,
    `country_name` char(200) DEFAULT NULL COMMENT '国家',
    `group_name` char(200) DEFAULT NULL COMMENT '集团名称',
    `organization_name` char(200) DEFAULT NULL COMMENT '组织名称',
    `company_name` char(200) DEFAULT NULL COMMENT '公司名称',
    `project_name` char(200) DEFAULT NULL COMMENT '项目名称',
    `module_name` char(200) DEFAULT NULL COMMENT '模块名称',
    `function_name` char(200) DEFAULT NULL COMMENT '功能名称',
    `class_name` char(200) DEFAULT NULL COMMENT '接口所在类名称',
    `method_name` char(200) DEFAULT NULL COMMENT '方法名称',
    `method_type` char(200) DEFAULT NULL COMMENT '方法类型',
    `url` varchar(2000) DEFAULT NULL COMMENT '接口url',
    `request_params` varchar(2000) DEFAULT NULL COMMENT '接口入参',
    `result` text COMMENT '接口返回值',
    `remark` char(200) DEFAULT NULL COMMENT '备注',
    `cost` bigint(50) DEFAULT NULL COMMENT '接口耗时',
    `ip` char(200) DEFAULT NULL COMMENT '用户ip',
    `user_id` char(200) DEFAULT NULL COMMENT '用户id',
    `user_name` char(200) DEFAULT NULL COMMENT '用户名称',
    `client_type` varchar(200) DEFAULT NULL COMMENT '客户端类型',
    `user_agent` varchar(200) DEFAULT NULL COMMENT '客户端信息',
    `log_type` tinyint(1) DEFAULT NULL COMMENT '此条操作状态：0 正常  1 异常',
    `gmt_start` datetime DEFAULT NULL COMMENT '操作开始时间',
    `gmt_end` datetime DEFAULT NULL COMMENT '操作结束时间',
    `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
    `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
    `error_message` varchar(2000) DEFAULT NULL COMMENT '错误信息',
    `error_stack_trace` varchar(2000) DEFAULT NULL COMMENT '错误堆栈',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='接口日志记录表';
