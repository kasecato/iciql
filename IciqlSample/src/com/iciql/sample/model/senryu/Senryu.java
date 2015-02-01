package com.iciql.sample.model.senryu;

import java.sql.Timestamp;

import com.iciql.Iciql.IQColumn;
import com.iciql.Iciql.IQTable;

@IQTable(
        create = false,
        name = "senryu",
        memoryTable = false,
        annotationsOnly = true,
        inheritColumns = false)
public class Senryu {

    /*==================================================================
        CREATE TABLE senryu
        (
          id_senryu bigserial NOT NULL,
          id_user character(10) NOT NULL,
          category character(2) NOT NULL,
          tag character varying(256) NOT NULL,
          sql text NOT NULL,
          createdate timestamp with time zone NOT NULL,
          updatedate timestamp with time zone NOT NULL,
          count integer NOT NULL,
          delete boolean NOT NULL,
          CONSTRAINT pk_senryu_id_senryu PRIMARY KEY (id_senryu)
        );

        INSERT INTO senryu VALUES (1, 'bar       ', '04', 'MySQL', 'SELECT * FROM bar', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);
        INSERT INTO senryu VALUES (2, 'foo       ', '09', 'SQLite', 'SELECT * FROM foo', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);
        INSERT INTO senryu VALUES (3, 'fuga      ', '15', 'PostgreSQL', 'SELECT * FROM fuga', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);
        INSERT INTO senryu VALUES (4, 'hoge      ', '12', 'MongoDB', 'SELECT * FROM hoge', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);
     ==================================================================*/

    @IQColumn(
            primaryKey = true,
            name = "id_senryu",
            trim = false,
            scale = 0,
            length = 0,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public long idSenryu;

    @IQColumn(
            primaryKey = true,
            name = "id_user",
            trim = false,
            scale = 0,
            length = 10,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public String idUser;

    @IQColumn(
            primaryKey = false,
            name = "category",
            trim = false,
            scale = 0,
            length = 2,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public String category;

    @IQColumn(
            primaryKey = false,
            name = "tag",
            trim = false,
            scale = 0,
            length = 256,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public String tag;

    @IQColumn(
            primaryKey = false,
            name = "sql",
            trim = false,
            scale = 0,
            length = 0,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public String sql;

    @IQColumn(
            primaryKey = false,
            name = "createdate",
            trim = false,
            scale = 0,
            length = 0,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public Timestamp createdate;

    @IQColumn(
            primaryKey = false,
            name = "updatedate",
            trim = false,
            scale = 0,
            length = 0,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public Timestamp updatedate;

    @IQColumn(
            primaryKey = false,
            name = "count",
            trim = false,
            scale = 0,
            length = 0,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public int count;

    @IQColumn(
            primaryKey = false,
            name = "delete",
            trim = false,
            scale = 0,
            length = 0,
            nullable = false,
            defaultValue = "",
            autoIncrement = false)
    public boolean delete;

    public String toString() {
        return String.format(
                "%d %s %s %s %s %s %s %d %b",
                idSenryu,
                idUser,
                category,
                tag,
                sql,
                createdate,
                updatedate,
                count,
                delete);
    }
}
