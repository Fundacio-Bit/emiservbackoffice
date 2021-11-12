
    create sequence EBO_PROCEDIMENT_SEQ start 1 increment 1;
    create sequence EBO_UNITATORGANICA_SEQ start 1 increment 1;

    create table EBO_PROCEDIMENT (
       ID int8 not null,
        CODISIA varchar(8) not null,
        NOM varchar(50) not null,
        UNITATORGANICAID int8 not null,
        constraint EBO_PROCEDIMENT_PK primary key (ID)
    );

    create table EBO_UNITATORGANICA (
       ID int8 not null,
        CODIDIR3 varchar(9) not null,
        DATACREACIO date not null,
        ESTAT int4 not null,
        NOM varchar(50) not null,
        constraint EBO_UNITAT_PK primary key (ID)
    );

    create index EBO_PROCEDIMENT_PK_I on EBO_PROCEDIMENT (ID);
    create index EBO_PROCEDIMENT_CODISIA_UK_I on EBO_PROCEDIMENT (CODISIA);
    create index EBO_PROCEDIMENT_UNITAT_FK_I on EBO_PROCEDIMENT (UNITATORGANICAID);

    alter table EBO_PROCEDIMENT 
       add constraint EBO_PROCEDIMENT_CODISIA_UK unique (CODISIA);

    create index EBO_UNITAT_PK_I on EBO_UNITATORGANICA (ID);
    create index EBO_UNITAT_CODIDIR3_UK_I on EBO_UNITATORGANICA (CODIDIR3);

    alter table EBO_UNITATORGANICA 
       add constraint EBO_UNITAT_CODIDIR3_UK unique (CODIDIR3);

    alter table EBO_PROCEDIMENT 
       add constraint EBO_PROCEDIMENT_UNITAT_FK 
       foreign key (UNITATORGANICAID) 
       references EBO_UNITATORGANICA;
