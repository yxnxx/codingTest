-- 코드를 입력하세요
SELECT (SELECT CATEGORY 
        FROM BOOK AS B 
        WHERE B.BOOK_ID = BS.BOOK_ID) AS CATEGORY, 
        SUM(BS.SALES) AS TOTAL_SALES 
FROM BOOK_SALES AS BS
WHERE SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY CATEGORY
ORDER BY CATEGORY                                            