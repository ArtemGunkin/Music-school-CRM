CREATE TABLE users
(
  user_id       INTEGER PRIMARY KEY NOT NULL,
  phone         INTEGER,
  password      VARCHAR(255),
  profile_image VARCHAR(255),
  info          VARCHAR(255),
  login         VARCHAR(255),
  first_name    VARCHAR(255),
  user_role     VARCHAR(255),
  last_name     VARCHAR(255)
);

CREATE TABLE persistent_logins
(
  username  VARCHAR(64)             NOT NULL,
  series    VARCHAR(64) PRIMARY KEY NOT NULL,
  token     VARCHAR(64)             NOT NULL,
  last_used TIMESTAMP               NOT NULL
);

CREATE TABLE workers
(
  id         INTEGER PRIMARY KEY NOT NULL,
  first_name VARCHAR(255),
  info       VARCHAR(255),
  jobtitle   VARCHAR(255),
  last_name  VARCHAR(255)
);

CREATE TABLE schools
(
  id        INTEGER PRIMARY KEY NOT NULL,
  cost      INTEGER             NOT NULL,
  info      VARCHAR(255),
  name      VARCHAR(255),
  worker_id INTEGER,
  enable    BOOLEAN DEFAULT TRUE,
  CONSTRAINT fk_worker_id FOREIGN KEY (worker_id) REFERENCES workers (id)
);

CREATE TABLE user_school
(
  school_id INTEGER NOT NULL,
  user_id   INTEGER NOT NULL,
  CONSTRAINT fk_school_id FOREIGN KEY (school_id) REFERENCES schools (id),
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE news
(
  id       BIGINT PRIMARY KEY NOT NULL,
  content  VARCHAR(3000),
  pub_date DATE,
  title    VARCHAR(255)
);

CREATE TABLE comments
(
  id           INTEGER PRIMARY KEY NOT NULL,
  publish_date TIMESTAMP,
  content      VARCHAR(255),
  news_id      BIGINT,
  user_id      INTEGER,
  CONSTRAINT fk_comment_news_id FOREIGN KEY (news_id) REFERENCES news (id),
  CONSTRAINT fk_comment_user_id FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE SEQUENCE public.comment_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 2
CACHE 1;
ALTER TABLE public.comment_id_seq
  OWNER TO postgres;

CREATE SEQUENCE public.school_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 22
CACHE 1;
ALTER TABLE public.school_id_seq
  OWNER TO postgres;

CREATE SEQUENCE public.user_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 5
CACHE 1;
ALTER TABLE public.user_id_seq
  OWNER TO postgres;

CREATE SEQUENCE public.worker_id_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 6
CACHE 1;
ALTER TABLE public.worker_id_seq
  OWNER TO postgres;