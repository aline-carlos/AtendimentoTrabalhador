/* Database generated with pgModeler (PostgreSQL Database Modeler).
  Project Site: pgmodeler.com.br
  Model Author: --- */


/* Database creation must be done outside an multicommand file.
   These commands were put in this file only for convenience.

-- object: fgtas | type: DATABASE -- 
CREATE DATABASE fgtas
  ENCODING = 'UTF8'
;

*/

-- object: servicos | type: SCHEMA -- 
CREATE SCHEMA servicos;
-- object: servicos.regional | type: TABLE -- 
CREATE TABLE servicos.regional(
	codigo integer NOT NULL,
	nome varchar(40) NOT NULL,
	descricao character varying(150),
	ativa boolean NOT NULL DEFAULT true,
	CONSTRAINT pk_regional PRIMARY KEY (codigo)
)
WITH (OIDS=FALSE);

-- object: servicos.municipio | type: TABLE -- 
CREATE TABLE servicos.municipio(
	codigo integer NOT NULL,
	nome varchar(40) NOT NULL,
	regional integer NOT NULL,
	ativo boolean NOT NULL DEFAULT true,
	CONSTRAINT pk_municipio PRIMARY KEY (codigo)
)
WITH (OIDS=FALSE);

-- object: servicos.agencia | type: TABLE -- 
CREATE TABLE servicos.agencia(
	codigo integer NOT NULL,
	nome varchar(50) NOT NULL,
	tipo varchar(15),
	municipio integer NOT NULL,
	ativa boolean NOT NULL DEFAULT true,
	endereco varchar(100),
	telefone varchar(20),
	email varchar(50),
	infadicionais varchar(500),
	CONSTRAINT pk_agencia PRIMARY KEY (codigo)
)
WITH (OIDS=FALSE);

-- object: servicos.usuario | type: TABLE -- 
CREATE TABLE servicos.usuario(
	login varchar(30) NOT NULL,
	nome varchar(60) NOT NULL,
	isadministrador boolean NOT NULL,
	senha varchar(20),
	CONSTRAINT pk_usuario PRIMARY KEY (login)
)
WITH (OIDS=FALSE);

-- object: servicos.desempenho | type: TABLE -- 
CREATE TABLE servicos.desempenho(
	agencia integer NOT NULL,
	periodo integer NOT NULL,
	vagas integer,
	inscritos integer,
	encaminhados integer,
	colocados integer,
	segurodesemprego integer,
	ctps integer,
	usuario varchar(30),
	dtmodificacao date,
	CONSTRAINT pk_desempenho PRIMARY KEY (agencia,periodo)
)
WITH (OIDS=FALSE);

-- object: servicos.publicacao | type: TABLE -- 
CREATE TABLE servicos.publicacao(
	periodo integer NOT NULL,
	intermediacao boolean NOT NULL DEFAULT false,
	caged boolean NOT NULL DEFAULT false,
	segurodesemprego boolean NOT NULL DEFAULT false,
	ctps boolean NOT NULL DEFAULT false,
	usuario varchar(30),
	dtmodificacao date,
	CONSTRAINT pk_publicacao PRIMARY KEY (periodo)
)
WITH (OIDS=FALSE);

-- object: servicos.meta | type: TABLE -- 
CREATE TABLE servicos.meta(
	municipio integer NOT NULL,
	desde date,
	ate date,
	valor float,
	CONSTRAINT pk_meta PRIMARY KEY (municipio,desde)
)
WITH (OIDS=FALSE);

-- object: servicos.caged | type: TABLE -- 
CREATE TABLE servicos.caged(
	periodo integer NOT NULL,
	municipio integer NOT NULL,
	admitidos integer,
	usuario varchar(30),
	dtmodificacao date,
	CONSTRAINT pk_caged PRIMARY KEY (periodo,municipio)
)
WITH (OIDS=TRUE);

-- object: fk_caged_munic | type: CONSTRAINT -- 
ALTER TABLE servicos.caged ADD CONSTRAINT fk_caged_munic FOREIGN KEY (municipio)
REFERENCES servicos.municipio (codigo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

ALTER TABLE servicos.caged ADD CONSTRAINT fk_caged_usuario FOREIGN KEY (usuario)
REFERENCES servicos.usuario (login) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_meta_munic | type: CONSTRAINT -- 
ALTER TABLE servicos.meta ADD CONSTRAINT fk_meta_munic FOREIGN KEY (municipio)
REFERENCES servicos.municipio (codigo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_public_usuario | type: CONSTRAINT -- 
ALTER TABLE servicos.publicacao ADD CONSTRAINT fk_public_usuario FOREIGN KEY (usuario)
REFERENCES servicos.usuario (login) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_desempenho_agencia | type: CONSTRAINT -- 
ALTER TABLE servicos.desempenho ADD CONSTRAINT fk_desempenho_agencia FOREIGN KEY (agencia)
REFERENCES servicos.agencia (codigo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_desempenho_usuario | type: CONSTRAINT -- 
ALTER TABLE servicos.desempenho ADD CONSTRAINT fk_desempenho_usuario FOREIGN KEY (usuario)
REFERENCES servicos.usuario (login) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_agencia_municipio | type: CONSTRAINT -- 
ALTER TABLE servicos.agencia ADD CONSTRAINT fk_agencia_municipio FOREIGN KEY (municipio)
REFERENCES servicos.municipio (codigo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;

-- object: fk_mun_regional | type: CONSTRAINT -- 
ALTER TABLE servicos.municipio ADD CONSTRAINT fk_mun_regional FOREIGN KEY (regional)
REFERENCES servicos.regional (codigo) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION NOT DEFERRABLE;


