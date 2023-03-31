package Repository;

import Entity.SanPham;
import Utitils.Hiberbnate;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepository {
    private Session hSession;
    public SanPhamRepository()
    {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }

    public void insert(SanPham kh)
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

    public void update(SanPham kh)
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

    public void delete(SanPham kh)
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

    public List<SanPham> findAll()
    {
        String hql = "SELECT spObj FROM SanPham spObj";
        TypedQuery<SanPham> q = this.hSession.createQuery(hql, SanPham.class);
        return q.getResultList();
    }

    public SanPham findByMa(String ma)
    {
        String hql = "SELECT spObj FROM SanPham spObj WHERE spObj.ma = ?1";
        TypedQuery<SanPham> q = this.hSession.createQuery(hql, SanPham.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}

