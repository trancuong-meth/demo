package Repository;

import Entity.MauSac;
import Utitils.Hiberbnate;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class MauSacRepository {
    private Session hSession;
    public MauSacRepository() {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }

    public void insert(MauSac cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(MauSac cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(MauSac cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<MauSac> findAll() {
        String hql = "SELECT msObj FROM MauSac msObj";
        TypedQuery<MauSac> q = this.hSession.createQuery(hql, MauSac.class);
        return q.getResultList();
    }

    public MauSac findByMa(String ma) {
        String hql = "SELECT msObj FROM MauSac msObj WHERE msObj.ma = ?1";
        TypedQuery<MauSac> q = this.hSession.createQuery(hql, MauSac.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}
