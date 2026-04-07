CREATE TABLE post (
                      post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255),
                      content TEXT,
                      author VARCHAR(255),
                      viewcount BIGINT DEFAULT 0,
                      created_at DATETIME(6)
);