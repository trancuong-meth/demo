package Repository;

import Entity.NSX;
import Utitils.Hiberbnate;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class NSXRepository {
    private Session hSession;
    public NSXRepository()
    {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }

    public void insert(NSX kh)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(NSX kh)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(NSX kh)
    {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(kh);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<NSX> findAll()
    {
        String hql = "SELECT nsxObj FROM NSX nsxObj";
        TypedQuery<NSX> q = this.hSession.createQuery(hql, NSX.class);
        return q.getResultList();
    }

    public NSX findByMa(String ma)
    {
        String hql = "SELECT nsxObj FROM NSX nsxObj WHERE nsxObj.ma = ?1";
        TypedQuery<NSX> q = this.hSession.createQuery(hql, NSX.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}

