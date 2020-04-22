-- noinspection SqlDialectInspectionForFile

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: theme
#------------------------------------------------------------

CREATE TABLE theme(
        id_theme   Int  Auto_increment  NOT NULL ,
        background Varchar (255) NOT NULL
	,CONSTRAINT theme_PK PRIMARY KEY (id_theme)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: avatar
#------------------------------------------------------------

CREATE TABLE avatar(
        id_avatar Int  Auto_increment  NOT NULL ,
        name      Varchar (255) NOT NULL
	,CONSTRAINT avatar_PK PRIMARY KEY (id_avatar)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: user
#------------------------------------------------------------

CREATE TABLE user(
        id_user    Int  Auto_increment  NOT NULL ,
        pseudo     Varchar (250) NOT NULL ,
        password   Varchar (250) NOT NULL ,
        birth_date Date NOT NULL ,
        avatar     Varchar (80) NOT NULL ,
        id_avatar  Int
	,CONSTRAINT user_PK PRIMARY KEY (id_user)

	,CONSTRAINT user_avatar_FK FOREIGN KEY (id_avatar) REFERENCES avatar(id_avatar)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: gift_list
#------------------------------------------------------------

CREATE TABLE gift_list(
        id_gift_list Int  Auto_increment  NOT NULL ,
        title        Varchar (150) NOT NULL ,
        dead_line    Date NOT NULL ,
        share_link   Varchar (255) NOT NULL ,
        description  Text NOT NULL ,
        notify_gift  Bool NOT NULL ,
        id_user      Int NOT NULL ,
        id_theme     Int
	,CONSTRAINT gift_list_PK PRIMARY KEY (id_gift_list)

	,CONSTRAINT gift_list_user_FK FOREIGN KEY (id_user) REFERENCES user(id_user)
	,CONSTRAINT gift_list_theme0_FK FOREIGN KEY (id_theme) REFERENCES theme(id_theme)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: gift
#------------------------------------------------------------

CREATE TABLE gift(
        id_gift      Int  Auto_increment  NOT NULL ,
        title        Varchar (150) NOT NULL ,
        description  Text NOT NULL ,
        preference   Int NOT NULL ,
        image        Varchar (255) NOT NULL ,
        url_dealer   Varchar (150) NOT NULL ,
        price        Float NOT NULL ,
        id_gift_list Int NOT NULL
	,CONSTRAINT gift_PK PRIMARY KEY (id_gift)

	,CONSTRAINT gift_gift_list_FK FOREIGN KEY (id_gift_list) REFERENCES gift_list(id_gift_list)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: user_gift
#------------------------------------------------------------

CREATE TABLE user_gift(
        id_gift Int NOT NULL ,
        id_user Int NOT NULL ,
        message Text NOT NULL
	,CONSTRAINT user_gift_PK PRIMARY KEY (id_gift,id_user)

	,CONSTRAINT user_gift_gift_FK FOREIGN KEY (id_gift) REFERENCES gift(id_gift)
	,CONSTRAINT user_gift_user0_FK FOREIGN KEY (id_user) REFERENCES user(id_user)
)ENGINE=InnoDB;

