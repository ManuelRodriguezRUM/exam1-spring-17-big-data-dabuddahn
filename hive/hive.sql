# You sql follows
# You sql follows
# PART 1 - Schools by Region and City
select region, ciudad, count(*)
    from escuelaspr
    group by region, ciudad;

# PART 2 - Total number of Students per school
 select s.id, count(*)
    from studentspr e, escuelaspr s
    where e.id = s.id
    group by s.id;
# PART 3 - All students that go to school in the city of Ponce or Cabo Rojo
select e.ciudad, e.id, s.numeroserie
    from studentsPR s, escuelasPR e
    where e.id=s.id AND (e.ciudad ="Ponce" OR e.ciudad="Cabo Rojo");
# PART 4 - Students by region and city
select e.ciudad, e.region, count(*)
    from studentsPR s, escuelasPR e
    where s.id=e.id
    group by e.region, e.ciudad;
