/* V1__init.sql – 최초 테이블 & 기본 계정 구조 */

-- 회원 테이블
CREATE TABLE member (
                        member_id     BIGINT AUTO_INCREMENT PRIMARY KEY,
                        member_type   VARCHAR(10)  NOT NULL COMMENT 'NORMAL 또는 KAKAO',
                        role          VARCHAR(10)  NOT NULL COMMENT 'USER 또는 ADMIN',
                        phone         VARCHAR(15)  UNIQUE,
                        password_hash VARCHAR(255),
                        nickname      VARCHAR(50),
                        points        INT          DEFAULT 0,
                        stamps        INT          DEFAULT 0,
                        created_at    TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
);

-- 전화 인증 테이블
CREATE TABLE phone_auth (
                            id          BIGINT AUTO_INCREMENT PRIMARY KEY,
                            phone       VARCHAR(20) NOT NULL UNIQUE,
                            code        VARCHAR(6),
                            verified    BOOLEAN     NOT NULL DEFAULT FALSE,
                            expires_at  DATETIME,
                            INDEX idx_phone_auth_phone (phone)
);

-- 관리자 초기 계정 삽입 (선택 사항)
INSERT INTO member (member_type, role, phone, password_hash, nickname)
VALUES ('NORMAL', 'ADMIN', '01000000000', '$2a$10$abcde1234567890hashedpwvalue', '관리자');


CREATE TABLE menu_item (
                           menu_item_id BINARY(16) NOT NULL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           base_price INT NOT NULL,
                           is_sold_out BOOLEAN NOT NULL
);

