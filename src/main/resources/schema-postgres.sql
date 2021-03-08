DROP SCHEMA IF EXISTS migrations CASCADE ;
SET search_path TO migrations, public;
CREATE SCHEMA migrations
    CREATE TABLE questiontypes(
        typeid serial primary key NOT NULL ,
        typename varchar(30) not null UNIQUE
    )
    CREATE TABLE questions (
    qid serial PRIMARY KEY,
    qtext text NOT NULL,
    typeid int NOT NULL,
    FOREIGN KEY(typeid)
    REFERENCES questiontypes(typeid)
    ON DELETE CASCADE
    )

    CREATE TABLE IF NOT EXISTS answers(
      answerid serial PRIMARY KEY,
      answer text NOT NULL,
      qid int NOT NULL,
      FOREIGN KEY(qid)
    REFERENCES questions(qid)
    ON DELETE CASCADE
    );

