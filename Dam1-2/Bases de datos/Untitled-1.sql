SELECT concat(p.nombre, " ", p.apellidos) as profesor from persona p where p.rol = 3 ;

select concat(p.nombre, " ", p.apellidos) as profesor, count(a.ida) as alumnos
from alumno a join profesor pr join grupo g join persona p join persona p2
on a.idg = pr.idg and g.id = pr.idp and g.id = a.idg and p2.id = a.ida and p.id = pr.idp
where p.rol = 3 and p2.rol = 4 and timestampdiff(year, p2.fnac, p.fnac ) <= 10
group by p.id;


-- Muestra el código de empleado y los títulos que tiene cada mánager que siga siendo mánager
-- y pasase menos de 5 años desde que fue contratado a tener cargo de mánager.

select concat(left(e.first_name, 1), ".", left(e.last_name, 3)) as cod_e, t1.title as title
from titles t1 join (select emp_no, title from titles where title = "Manager" and year(to_date) = 9999) t2 join employees e
on t1.emp_no = t2.emp_no and e.emp_no = t1.emp_no where timestampdiff(year, e.hire_date, t1.from_date) < 5
group by t1.emp_no, t1.title;

-- Muestra el nombre y apellidos, el título que posea siempre que sea "Senior"
-- y el salario que tenía cuando fue contratado. De estos, mostrar solo los 10 salarios más altos.

select concat(e.first_name, " ", e.last_name) as emp, t.title as title, s.salary as salary
from employees e join salaries e join titles t
on e.emp_no = s.emp_no and e.emp_no = t.emp_no and t.emp_no = s.emp_no
where e.hire_date = s.from_date and t.title like "%Senior%";

select concat(e.first_name, " ", e.last_name) as emp, t.title as title, s.salary as salary
from employees e join titles t join salaries s
on e.emp_no = s.emp_no and e.emp_no = t.emp_no
where t.title like "%Senior%" and e.hire_date = t.from_date order by s.salary desc limit 10;