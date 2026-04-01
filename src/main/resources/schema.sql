CREATE TABLE IF NOT EXISTS post
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(200)  NOT NULL,
    content    TEXT          NOT NULL,
    author     VARCHAR(50)   NOT NULL,
    view_count INT           NOT NULL DEFAULT 0,
    created_at DATETIME      NOT NULL DEFAULT NOW(),
    updated_at DATETIME      NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS comment
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id    BIGINT        NOT NULL,
    content    VARCHAR(500)  NOT NULL,
    author     VARCHAR(50)   NOT NULL,
    created_at DATETIME      NOT NULL DEFAULT NOW(),
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE
);
