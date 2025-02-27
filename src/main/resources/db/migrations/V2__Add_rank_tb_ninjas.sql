-- V2: Migration para adicionar a coluna de rank na tb_ninjas

ALTER TABLE tb_ninjas
ADD COLUMN `ranking_ninja` VARCHAR(255);