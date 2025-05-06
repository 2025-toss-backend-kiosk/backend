/* V1__init.sql  – 최초 테이블&계정 구조  */

CREATE TABLE member (
                        member_id     BIGINT AUTO_INCREMENT PRIMARY KEY,
                        member_type   VARCHAR(10)  NOT NULL,
                        role          VARCHAR(10)  NOT NULL,
                        phone         VARCHAR(15)  UNIQUE,
                        password_hash VARCHAR(255),
                        nickname      VARCHAR(50),
                        points        INT          DEFAULT 0,
                        stamps        INT          DEFAULT 0,
                        created_at    TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);
