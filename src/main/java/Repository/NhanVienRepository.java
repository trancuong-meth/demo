package Repository;

import Entity.NhanVien;
import Utitils.Hiberbnate;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class NhanVienRepository {
    private Session hSession;
    private TypedQuery<NhanVien> q;

    public NhanVienRepository()
    {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }

    public void insert(NhanVien kh)
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

    public void update(NhanVien kh)
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

    public void delete(NhanVien kh)
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

    public List<NhanVien> findAll()
    {
        String hql = "SELECT nvObj FROM NhanVien nvObj";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql, NhanVien.class);
        return q.getResultList();
    }

    public NhanVien findByMa(String ma)
    {
        String hql = "SELECT nvObj FROM NhanVien nvObj WHERE nvObj.ma = ?1";
        TypedQuery<NhanVien> q = this.hSession.createQuery(hql, NhanVien.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}

