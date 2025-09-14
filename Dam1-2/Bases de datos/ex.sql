-- Pregunta 1

select d.dept_name, count(s.emp_no) as num 
from salaries s join dept_manager dm join departments d on s.emp_no = dm.emp_no and dm.dept_no = d.dept_no
where  (s.salary between 60000 and 70000) and year(s.to_date) = 9999 group by dm.dept_no;


-- Pregunta 2

 select concat(left(e.first_name, 3), ".", left(last_name, 3), "@corp.com") as emp, 
 timestampdiff(year, birth_date, hire_date) as edad_incorp, 
 year(hire_date) as año_incorp,s.salary as salario 
 from employees e join salaries s join titles t on e.emp_no = s.emp_no and t.emp_no = e.emp_no and t.emp_no = s.emp_no where timestampdiff(day, e.hire_date, t.to_date) < 2;

-- Pregunta 3

    select d.dept_name as dept_name, concat(truncate(count(e.emp_no) / 100), "%"), 2) *100 as pe from departments d join (select e.emp_no as emp_no from employees e join dept_manager dm join dept_emp de on e.emp_no = dm.emp_no and e.emp_no = de.emp_no where e.gender = "F") e group by d.dept_name order by pe desc limit 3;

select e.emp_no as emp_no from employees e join dept_manager dm join dept_emp de on e.emp_no = dm.emp_no and e.emp_no = de.emp_no where e.gender = "F";

--  Pregunta 4

select t.title as title, d.dept_name as dept_name, count(t.emp_no) as num
from titles t 
join (select e.emp_no as emp_no from employees e where e.emp_no in(select emp_no from dept_manager) or e.emp_no in(select emp_no from dept_emp)) em 
join departments d 
join (select d.dept_no as dept_no from departments d where d.dept_no in(select dept_no from dept_manager) or d.dept_no in(select dept_no from dept_emp)) de
on t.emp_no = em.emp_no and d.dept_no = de.dept_no 
where year(t.to_date) < 1994 and d.dept_name != "Development" 
group by t.title, d.dept_name;


select d.dept_no from departments where d.dept_no in(select dept_no from dept_manager) or d.dept_no in(select dept_no from dept_emp);
select e.emp_no from employees e where e.emp_no in(select emp_no from dept_manager) or e.emp_no in(select emp_no from dept_emp);


select t.title, d.dept_name, count(em.emp_no) as num
from titles t
join departments d
join (select e.emp_no as emp_no from employees e where e.emp_no in(select emp_no from dept_manager) or e.emp_no in(select emp_no from dept_emp)) em 
join (select d.dept_no as dept_no from departments d where d.dept_no in(select dept_no from dept_manager) or d.dept_no in(select dept_no from dept_emp)) de
on t.emp_no = em.emp_no and d.dept_no = de.dept_no
where d.dept_name != "Development" and year(t.to_date) < 1994
group by t.title, d.dept_name
having(num < 20 or num > 5000);