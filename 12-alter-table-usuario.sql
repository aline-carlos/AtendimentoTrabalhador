ALTER TABLE servicos.usuario ADD COLUMN senha2 bytea;

ALTER TABLE servicos.usuario drop COLUMN senha;

