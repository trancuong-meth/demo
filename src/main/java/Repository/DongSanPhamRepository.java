package Repository;

import Entity.DongSP;
import Utitils.Hiberbnate;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class DongSanPhamRepository {
    private Session hSession;
    public DongSanPhamRepository()
    {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }

    public void insert(DongSP kh)
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

    public void update(DongSP kh)
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

    public void delete(DongSP kh)
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

    public List<DongSP> findAll()
    {
        String hql = "SELECT dspObj FROM DongSP dspObj";
        TypedQuery<DongSP> q = this.hSession.createQuery(hql, DongSP.class);
        return q.getResultList();
    }

    public DongSP findByMa(String ma)
    {
        String hql = "SELECT dspObj FROM DongSP dspObj WHERE dspObj.ma = ?1";
        TypedQuery<DongSP> q = this.hSession.createQuery(hql, DongSP.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}

