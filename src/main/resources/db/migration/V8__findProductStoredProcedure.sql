DELIMITER $$

CREATE PROCEDURE findProduct(minPrice DECIMAL, maxPrice DECIMAL)
BEGIN

SELECT id,name,price,PRODUCT.category_id,description from product where price between minPrice and maxPrice order by name;

END$$

DELIMITER;