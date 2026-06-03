SELECT e.title, e.city, e.start_date
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e ON r.event_id = e.event_id
WHERE e.status='upcoming'
AND u.city=e.city
ORDER BY e.start_date;

SELECT e.title,
AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f ON e.event_id=f.event_id
GROUP BY e.event_id,e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;

SELECT *
FROM Users
WHERE user_id NOT IN
(
SELECT user_id
FROM Registrations
WHERE registration_date >= CURDATE() - INTERVAL 90 DAY
);

SELECT e.title,
COUNT(s.session_id) AS total_sessions
FROM Events e
JOIN Sessions s ON e.event_id=s.event_id
WHERE HOUR(s.start_time) BETWEEN 10 AND 12
GROUP BY e.title;

SELECT u.city,
COUNT(DISTINCT r.user_id) AS total_users
FROM Users u
JOIN Registrations r ON u.user_id=r.user_id
GROUP BY u.city
ORDER BY total_users DESC
LIMIT 5;

SELECT e.title,
COUNT(r.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources r
ON e.event_id=r.event_id
GROUP BY e.title;

SELECT u.full_name,
f.comments,
e.title
FROM Feedback f
JOIN Users u ON f.user_id=u.user_id
JOIN Events e ON f.event_id=e.event_id
WHERE f.rating < 3;

SELECT e.title,
COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s
ON e.event_id=s.event_id
WHERE e.status='upcoming'
GROUP BY e.title;

SELECT u.full_name,
e.status,
COUNT(*) AS total_events
FROM Users u
JOIN Events e
ON u.user_id=e.organizer_id
GROUP BY u.full_name,e.status;

SELECT e.title
FROM Events e
JOIN Registrations r
ON e.event_id=r.event_id
LEFT JOIN Feedback f
ON e.event_id=f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.title;

SELECT registration_date,
COUNT(*) AS user_count
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date;

SELECT e.title,
COUNT(s.session_id) AS total_sessions
FROM Events e
JOIN Sessions s
ON e.event_id=s.event_id
GROUP BY e.title
HAVING COUNT(s.session_id)=
(
SELECT MAX(session_total)
FROM
(
SELECT COUNT(*) AS session_total
FROM Sessions
GROUP BY event_id
) x
);

SELECT e.city,
AVG(f.rating) AS avg_rating
FROM Events e
JOIN Feedback f
ON e.event_id=f.event_id
GROUP BY e.city;

SELECT e.title,
COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r
ON e.event_id=r.event_id
GROUP BY e.title
ORDER BY total_registrations DESC
LIMIT 3;

SELECT s1.event_id,
s1.title,
s2.title
FROM Sessions s1
JOIN Sessions s2
ON s1.event_id=s2.event_id
AND s1.session_id < s2.session_id
AND s1.start_time < s2.end_time
AND s1.end_time > s2.start_time;

SELECT *
FROM Users u
WHERE registration_date >= CURDATE()-INTERVAL 30 DAY
AND user_id NOT IN
(
SELECT user_id
FROM Registrations
);

SELECT speaker_name,
COUNT(*) AS total_sessions
FROM Sessions
GROUP BY speaker_name
HAVING COUNT(*) > 1;

SELECT e.title
FROM Events e
LEFT JOIN Resources r
ON e.event_id=r.event_id
WHERE r.resource_id IS NULL;

SELECT e.title,
COUNT(DISTINCT r.registration_id) AS total_registrations,
AVG(f.rating) AS avg_rating
FROM Events e
LEFT JOIN Registrations r
ON e.event_id=r.event_id
LEFT JOIN Feedback f
ON e.event_id=f.event_id
WHERE e.status='completed'
GROUP BY e.title;

SELECT u.full_name,
COUNT(DISTINCT r.event_id) AS events_attended,
COUNT(DISTINCT f.feedback_id) AS feedback_count
FROM Users u
LEFT JOIN Registrations r
ON u.user_id=r.user_id
LEFT JOIN Feedback f
ON u.user_id=f.user_id
GROUP BY u.full_name;

SELECT u.full_name,
COUNT(f.feedback_id) AS total_feedback
FROM Users u
JOIN Feedback f
ON u.user_id=f.user_id
GROUP BY u.full_name
ORDER BY total_feedback DESC
LIMIT 5;

SELECT user_id,
event_id,
COUNT(*) AS duplicate_count
FROM Registrations
GROUP BY user_id,event_id
HAVING COUNT(*) > 1;

SELECT MONTH(registration_date) AS month_no,
COUNT(*) AS registrations
FROM Registrations
WHERE registration_date >= CURDATE()-INTERVAL 12 MONTH
GROUP BY MONTH(registration_date)
ORDER BY month_no;

SELECT e.title,
AVG(TIMESTAMPDIFF(MINUTE,
s.start_time,
s.end_time)) AS avg_duration
FROM Events e
JOIN Sessions s
ON e.event_id=s.event_id
GROUP BY e.title;

SELECT e.title
FROM Events e
LEFT JOIN Sessions s
ON e.event_id=s.event_id
WHERE s.session_id IS NULL;
