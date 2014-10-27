--do comments work?
INSERT INTO RouteType
(planeClass, luxCSits, businessCSits, charterCSits)
VALUES
  ('Lux', 5, 10, 20),
  ('Business', 0, 10, 40),
  ('Charter', 0, 0, 55);

INSERT INTO Route
(froml, wherel, routePrice, routeType)
VALUES
  ('Киев', 'Харьков', 600, 'Business'),
  ('Киев', 'Донецк', 700, 'Charter'),
  ('Киев', 'Одесса', 800, 'Business'),
  ('Киев', 'Львов', 900, 'Charter'),
  ('Киев', 'Анталия', 1100, 'Lux'),
  ('Киев', 'Хургада', 1200, 'Lux');