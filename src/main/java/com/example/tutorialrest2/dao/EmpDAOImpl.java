package com.example.tutorialrest2.dao;

import com.example.tutorialrest2.entity.Scott;
import com.example.tutorialrest2.model.EmpSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmpDAOImpl implements EmpDAO{
    @Autowired
    private EntityManager entityManager;

    //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    //EntityManager entityManager = entityManagerFactory.createEntityManager();
    public List<Scott> findAll() {
        return entityManager.createQuery("SELECT c FROM Scott c").getResultList();
    }
    public List<Scott> find(EmpSearch empSearch) {
        String str="SELECT c FROM Scott c where 1=1 ";
        if(!empSearch.getEmpno().equals("")){
            str+="and empno like :empno ";
        }
        if(!empSearch.getEname().equals("")){
            str+="and ename like :ename ";
        }
        if(!empSearch.getDep().equals("")){
            str+="and dep like :dep ";
        }
        if(!empSearch.getMgr().equals("")){
            str+="and mgr like :mgr ";
        }
        if(empSearch.getSalMax()!=0){
            str+="and sal between :salmin and :salmax ";
        }
        Query query=entityManager.createQuery(str);
        if(!empSearch.getEmpno().equals("")){
            query.setParameter("empno","%"+empSearch.getEmpno()+"%");
        }
        if(!empSearch.getEname().equals("")){
            query.setParameter("ename","%"+empSearch.getEname()+"%");
        }
        if(!empSearch.getDep().equals("")){
            query.setParameter("dep","%"+empSearch.getDep()+"%");
        }
        if(!empSearch.getMgr().equals("")){
            query.setParameter("mgr","%"+empSearch.getMgr()+"%");
        }
        if(empSearch.getSalMax()!=0){
            query.setParameter("salmin",empSearch.getSalMin());
            query.setParameter("salmax",empSearch.getSalMax());
        }
        return query.getResultList();
    }

    @Override
    public Scott findById(String id) {
        return this.entityManager.find(Scott.class,id);
    }

    public List<String> findDep() {
        return entityManager.createQuery("select distinct c.dep from Scott as c").getResultList();
    }

    public List<String> findMgr() {
        return entityManager.createQuery(("select distinct c.ename from Scott as c")).getResultList();
    }


    public void update(Scott emp) {
        entityManager.merge(emp);
    }

    public void del(Scott emp) {
        entityManager.remove((entityManager.contains(emp)?emp:entityManager.merge(emp)));
    }

    public void add(Scott emp) {
        entityManager.persist(emp);
    }
}
