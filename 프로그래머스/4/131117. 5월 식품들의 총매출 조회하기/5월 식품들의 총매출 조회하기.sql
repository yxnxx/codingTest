-- 코드를 입력하세요
WITH SALES AS (
    SELECT PRODUCT_ID, AMOUNT
    FROM FOOD_ORDER
    WHERE PRODUCE_DATE BETWEEN '2022-05-01' AND '2022-05-31'
)

SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(P.PRICE * S.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT AS P
JOIN SALES AS S ON P.PRODUCT_ID = S.PRODUCT_ID
GROUP BY PRODUCT_ID
ORDER BY TOTAL_SALES DESC, PRODUCT_ID
