-- Run this in MySQL to create initial schema (optional since JPA can create tables)
CREATE DATABASE IF NOT EXISTS rvfoods_db;
y

CREATE TABLE IF NOT EXISTS restaurant (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  location VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS table_info (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  restaurant_id BIGINT,
  table_number INT,
  qr_code VARCHAR(512)
);

CREATE TABLE IF NOT EXISTS category (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  restaurant_id BIGINT,
  name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS menu_item (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  category_id BIGINT,
  name VARCHAR(255),
  description TEXT,
  price DOUBLE,
  veg TINYINT(1),
  image_url VARCHAR(512),
  available TINYINT(1)
);

CREATE TABLE IF NOT EXISTS order_main (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  table_id BIGINT,
  status VARCHAR(50),
  created_at DATETIME
);

CREATE TABLE IF NOT EXISTS order_item (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT,
  item_id BIGINT,
  quantity INT,
  status VARCHAR(50)
);
