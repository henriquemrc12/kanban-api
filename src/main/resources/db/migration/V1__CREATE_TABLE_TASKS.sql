CREATE TABLE IF NOT EXISTS `TB_TASKS` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(45) NOT NULL,
    `description` VARCHAR(1000) NOT NULL,
    `status` VARCHAR(15) NOT NULL,
    `updated_at` DATETIME NOT NULL,
    `created_at` DATETIME NOT NULL,
    PRIMARY KEY (`id`))