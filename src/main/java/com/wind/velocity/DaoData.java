package com.wind.velocity;


import java.util.List;

/**
 * DaoData
 *
 * @author qianchun
 * @date 2019/1/15
 **/
public class DaoData {

    /**
     * dao 包名
     */
    private String daoPkg;

    /**
     * model 包名
     */
    private String modelPkg;

    /**
     * 数据库
     */
    class DB {
        /**
         * 库名
         */
        private String dbName;

        /**
         * 数据库库名(去除前缀)
         */
        private String catalogName;

        /**
         * 表名
         */
        private String tablePattern;
    }

    /**
     * 列
     */
    class Field{
        /**
         * 是否主键标识
         */
        private boolean keyIdentity;

        /**
         * 是否覆盖
         */
        private boolean convert;
        /**
         * 列名
         */
        private String name;

        /**
         * 列名映射Java字段名
         */
        private String cName;

        /**
         * 数据库字段类型
         */
        private String columnType;

        /**
         * java 字段属性类型
         */
        private String cType;

        /**
         * 注释
         */
        private String comment;
    }

    /**
     * 表
     */
    class Table {
        /**
         * 类名
         */
        private String pascalName;

        /**
         * 表名
         */
        private String mybatisTableName;

        /**
         * 查询列名字符串
         */
        private String selectBody;

        /**
         *
         */
        private String  selectUnionStyleBody;

        /**
         * 列
         */
        private List<String> fields;
    }

}
