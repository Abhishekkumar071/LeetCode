select query_name,
ROUND(SUM(rating/position)/count(*), 2) as quality,
ROUND((SUM(rating<3)/COUNT(*))*100, 2) 
as poor_query_percentage
from Queries
group by query_name;