
    alter table EBO_PROCEDIMENT 
       drop constraint EBO_PROCEDIMENT_UNITAT_FK;

    drop table if exists EBO_PROCEDIMENT cascade;

    drop table if exists EBO_UNITATORGANICA cascade;

    drop sequence if exists EBO_PROCEDIMENT_SEQ;

    drop sequence if exists EBO_UNITATORGANICA_SEQ;
