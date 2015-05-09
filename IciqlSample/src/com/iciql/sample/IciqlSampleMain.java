package com.iciql.sample;

import com.iciql.Db;
import com.iciql.sample.constraint.CommonConst;
import com.iciql.sample.model.senryu.Senryu;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class IciqlSampleMain {

    public static void main(String[] args) {

        Db db = null;

        try {
            /*==================================================
             * Instantiating a Db
             *==================================================*/
            String url = "jdbc:postgresql://localhost:5432/sqlsenryu";
            String user = "sqlsenryu";
            String password = "sqlsenryu";
            db = Db.open(url, user, password);

            /*==================================================
             * SQL DSL > Select Statements
             *==================================================*/
            // SELECT * FROM senryu WHERE category IN('09', '15') AND sql LIKE '%SELECT%' AND count < 1 ORDER BY updatedate DESC, id_senryu
            Senryu t = new Senryu();
            List<Senryu> dbData =
                    db
                            .from(t)
                            .where(t.category)
                            .oneOf(
                                    CommonConst.Category.SQLite,
                                    CommonConst.Category.PostgreSQL)
                            .and(t.sql).like("%SELECT%")
                            .and(t.count).lessThan(1)
                            .orderByDesc(t.updatedate)
                            .orderBy(t.idSenryu)
                            .select();

            /*==================================================
             * Lambda Expression
             *==================================================*/
            final Function<String, Predicate<Senryu>> getCategory
                    = category -> senryu -> senryu.category.equals(category);

            dbData
                    .stream()
                    .filter(getCategory.apply(CommonConst.Category.PostgreSQL))
                    .forEach(y -> {
                        print(y);
                        update(y);
                    });

            dbData
                    .stream()
                    .filter(getCategory.apply(CommonConst.Category.SQLite))
                    .forEach(IciqlSampleMain::print);

            /*==================================================
             * SQL DSL > Update Statements
             *==================================================*/
            // UPDATE senryu SET updatedate = ?, count = ? WHERE id_senryu = ?
            db.updateAll(dbData);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) db.close();
        }
    }

    private static void update(Senryu senryu) {
        senryu.updatedate = new Timestamp(System.currentTimeMillis());
        senryu.count++;
    }

    private static void print(Senryu senryu) {
        System.out.println(senryu.toString());
    }

}
