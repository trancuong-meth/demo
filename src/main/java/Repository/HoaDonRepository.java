package Repository;

import Entity.HoaDon;
import Utitils.Hiberbnate;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class HoaDonRepository {
    private Session hSession;
    public HoaDonRepository() {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }

    public void insert(HoaDon hd) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(hd);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(HoaDon hd) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(hd);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(HoaDon hd) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(hd);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<HoaDon> findAll() {
        String hql = "SELECT hdObj FROM HoaDon hdObj";
        TypedQuery<HoaDon> q = this.hSession.createQuery(hql, HoaDon.class);
        return q.getResultList();
    }

    public HoaDon findByMa(String ma) {
        String hql = "SELECT hdObj FROM HoaDon hdObj WHERE hdObj.ma = ?1";
        TypedQuery<HoaDon> q = this.hSession.createQuery(hql, HoaDon.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}
