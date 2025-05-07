CREATE TABLE orders (
                        order_id    BINARY(16) PRIMARY KEY,
                        order_type  VARCHAR(10) NOT NULL,
                        total_price INT         NOT NULL,
                        created_at  TIMESTAMP   NOT NULL
);