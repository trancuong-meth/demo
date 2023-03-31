package Repository;

import Entity.CuaHang;
import Utitils.Hiberbnate;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class CuaHangRepository {

    private Session hSession;

    public CuaHangRepository() {
        this.hSession = Hiberbnate.getFACTORY().openSession();
    }


    public void insert(CuaHang ch) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(CuaHang ch) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.update(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(CuaHang ch) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ch);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<CuaHang> findAll() {
        String hql = "SELECT chObj FROM CuaHang chObj";
        TypedQuery<CuaHang> q = this.hSession.createQuery(hql, CuaHang.class);
        return q.getResultList();
    }

    public CuaHang findByMa(String ma) {
        String hql = "SELECT chObj FROM CuaHang chObj WHERE chObj.ma = ?1";
        TypedQuery<CuaHang> q = this.hSession.createQuery(hql, CuaHang.class);
        q.setParameter(1, ma);
        return q.getSingleResult();
    }
}
