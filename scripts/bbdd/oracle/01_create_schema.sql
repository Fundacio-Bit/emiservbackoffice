
    create sequence EBO_PROCEDIMENT_SEQ start with 1 increment by  1;
    create sequence EBO_UNITATORGANICA_SEQ start with 1 increment by  1;

    create table EBO_PROCEDIMENT (
        ID number(19,0) not null,
        CODISIA varchar2(8 char) not null,
        NOM varchar2(50 char) not null,
        UNITATORGANICAID number(19,0) not null
    );

    create table EBO_UNITATORGANICA (
        ID number(19,0) not null,
        CODIDIR3 varchar2(9 char) not null,
        DATACREACIO date not null,
        ESTAT number(10,0) not null,
        NOM varchar2(50 char) not null
    );

    create index EBO_PROCEDIMENT_PK_I on EBO_PROCEDIMENT (ID);
    create index EBO_PROCEDIMENT_CODISIA_UK_I on EBO_PROCEDIMENT (CODISIA);
    create index EBO_PROCEDIMENT_UNITAT_FK_I on EBO_PROCEDIMENT (UNITATORGANICAID);

    alter table EBO_PROCEDIMENT
        add constraint EBO_PROCEDIMENT_PK primary key (ID);

    alter table EBO_PROCEDIMENT
        add constraint EBO_PROCEDIMENT_CODISIA_UK unique (CODISIA);

    create index EBO_UNITAT_PK_I on EBO_UNITATORGANICA (ID);
    create index EBO_UNITAT_CODIDIR3_UK_I on EBO_UNITATORGANICA (CODIDIR3);

    alter table EBO_UNITATORGANICA
        add constraint EBO_UNITAT_PK primary key (ID);

    alter table EBO_UNITATORGANICA
        add constraint EBO_UNITAT_CODIDIR3_UK unique (CODIDIR3);

    alter table EBO_PROCEDIMENT
        add constraint EBO_PROCEDIMENT_UNITAT_FK
        foreign key (UNITATORGANICAID)
        references EBO_UNITATORGANICA;

    -- Grants per l'usuari www_emiservbackoffice
    -- seqüències
    GRANT SELECT, ALTER ON EBO_PROCEDIMENT_SEQ TO WWW_EMISERVBACKOFFICE;
    GRANT SELECT, ALTER ON EBO_UNITATORGANICA_SEQ TO WWW_EMISERVBACKOFFICE;
    -- taules
    GRANT SELECT, INSERT, UPDATE, DELETE ON EBO_PROCEDIMENT TO WWW_EMISERVBACKOFFICE;
    GRANT SELECT, INSERT, UPDATE, DELETE ON EBO_UNITATORGANICA TO WWW_EMISERVBACKOFFICE;


