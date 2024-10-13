INSERT INTO BRAND (ID, NAME, DESCRIPTION)
VALUES (1, 'ZARA', 'Brand specializing in trendy clothing and accessories'),
       (2, 'Nike', 'Global brand known for athletic footwear and apparel'),
       (3, 'Adidas', 'International corporation that designs and manufactures sports shoes, clothing, and accessories'),
       (4, 'H&M', 'Multinational clothing-retail company known for its fast-fashion clothing'),
       (5, 'Gap', 'American worldwide clothing and accessories retailer');

INSERT INTO PRICE (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
       (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
       (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
       (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');
