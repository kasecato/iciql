SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE sqlsenryu;

CREATE DATABASE sqlsenryu WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'ja_JP.UTF-8' LC_CTYPE = 'ja_JP.UTF-8';


ALTER DATABASE sqlsenryu OWNER TO sqlsenryu;

\connect sqlsenryu

CREATE TABLE senryu (
    id_senryu bigint NOT NULL,
    id_user character(10) NOT NULL,
    category character(2) NOT NULL,
    tag character varying(256) NOT NULL,
    sql text NOT NULL,
    createdate timestamp with time zone NOT NULL,
    updatedate timestamp with time zone NOT NULL,
    count integer NOT NULL,
    delete boolean NOT NULL
);


ALTER TABLE public.senryu OWNER TO sqlsenryu;

CREATE SEQUENCE senryu_id_senryu_seq
    START WITH 5
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE senryu_id_senryu_seq OWNED BY senryu.id_senryu;

ALTER TABLE ONLY senryu ALTER COLUMN id_senryu SET DEFAULT nextval('senryu_id_senryu_seq'::regclass);


INSERT INTO senryu VALUES (1, 'bar       ', '04', 'MySQL', 'SELECT * FROM bar', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);
INSERT INTO senryu VALUES (2, 'foo       ', '09', 'SQLite', 'SELECT * FROM foo', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);
INSERT INTO senryu VALUES (3, 'fuga      ', '15', 'PostgreSQL', 'SELECT * FROM fuga', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);
INSERT INTO senryu VALUES (4, 'hoge      ', '12', 'MongoDB', 'SELECT * FROM hoge', '2015-02-01 00:00:00+09', '2015-02-01 00:00:00+09', 0, false);

SELECT pg_catalog.setval('senryu_id_senryu_seq', 1, true);

ALTER TABLE ONLY senryu
    ADD CONSTRAINT pk_senryu_id_senryu PRIMARY KEY (id_senryu);
