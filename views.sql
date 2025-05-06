CREATE MATERIALIZED VIEW display_accommodations_by_host AS
SELECT
    h.name,
    h.surname,
    COUNT(a.id) AS num_accommodations
FROM
    host h
        LEFT JOIN
    accommodation a ON a.host_id = h.id
GROUP BY
    h.name, h.surname;
