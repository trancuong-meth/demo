package Repository;

import Entity.KhachHang;
import Utitils.Hiberbnate;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class KhachHangRepository {
    private Session hSession;
    public KhachHangRepository()
    {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }

    public void insert(KhachHang kh)
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

    public void update(KhachHang kh)
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

    public void delete(KhachHang kh)
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

    public List<KhachHang> findAll()
    {
        String hql = "SELECT khObj FROM KhachHang khObj";
        TypedQuery<KhachHang> q = this.hSession.createQuery(hql, KhachHang.class);
        return q.getResultList();
    }

    public KhachHang findByMa(String ma)
    {
        String hql = "SELECT khObj FROM KhachHang khObj WHERE khObj.ma = ?1";
        TypedQuery<KhachHang> q = this.hSession.createQuery(hql, KhachHang.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }

    public KhachHang login(String ma, String matKhau)
    {
        String hql = "SELECT khObj FROM KhachHang khObj WHERE khObj.ma = ?1 AND khObj.matKhau = ?2";
        TypedQuery<KhachHang> q = this.hSession.createQuery(hql, KhachHang.class);
        q.setParameter(1, ma);
        q.setParameter(2, matKhau);

        try {
            KhachHang kh = q.getSingleResult();
            return kh;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}

