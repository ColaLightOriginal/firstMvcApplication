package com.firstMvcApplication.firstMvcApplication.Repositories;
import com.firstMvcApplication.firstMvcApplication.Classes.Employee;
import com.firstMvcApplication.firstMvcApplication.Interfaces.EmployeesRepositoryInterface;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

@Repository
public class EmployeeRepository implements EmployeesRepositoryInterface{

    @Autowired
    private EntityManager sessionFactory;

    public EmployeeRepository() {
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> resultList = new LinkedList<Employee>();
        try {
            String query = "select emp from Employee emp";
            TypedQuery<Employee> tq = sessionFactory.createQuery(query, Employee.class);
            resultList = tq.getResultList();
            return resultList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee findOne(int id) {
        try{
            Session session = sessionFactory.unwrap(Session.class);
            session.beginTransaction();
            Employee emp = new Employee();
            emp = session.get(Employee.class, id );
            session.close();
            return emp;
//            String query = ("select emp from Employee emp where id=:id");
//            TypedQuery<Employee> tq = sessionFactory.createQuery(query, Employee.class);
//            tq.setParameter("id", id);
//            Employee result = tq.getSingleResult();
//            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Employee findByNameSurname(String name, String surname){
        try{
            String query = "select emp from Employee emp where name = :name and surname = :surname";
            TypedQuery<Employee> tq = sessionFactory.createQuery(query,Employee.class);
            tq.setParameter("name", name);
            tq.setParameter("surname", surname);
            Employee result = tq.getSingleResult();
            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int getMaxId(){
            int result = -1;
            String query = ("select max(id) from Employee emp");
            Query qt = sessionFactory.createQuery(query);
            try{
                result = (int) qt.getSingleResult();
            }catch(NullPointerException npe){
                return 0;
            }
            return result;
    }

    public void addEmployee(String name, String surname){
        try {
            int maxId;
            Session session = sessionFactory.unwrap(Session.class);
            session.beginTransaction();
            Employee emp = new Employee();
            maxId = getMaxId();
            emp.setId(maxId+1);
            emp.setName(name);
            emp.setSurname(surname);
            session.save(emp);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void removeEmployee(int id){
        try {
            Session session = sessionFactory.unwrap(Session.class);
            session.beginTransaction();
            Employee emp = session.get(Employee.class,id);
            session.delete(emp);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}