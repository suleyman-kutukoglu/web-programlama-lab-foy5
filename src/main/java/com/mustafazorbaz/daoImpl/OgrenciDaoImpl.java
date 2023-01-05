package com.mustafazorbaz.daoImpl;

import java.util.List;

import com.mustafazorbaz.entities.Ogrenciler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mustafazorbaz.dao.OgrenciDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class OgrenciDaoImpl implements OgrenciDao {

	@Autowired
	SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(OgrenciDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Ogrenciler> list() {
		return sessionFactory.getCurrentSession().createCriteria(Ogrenciler.class).list();

	}

	public boolean delete(Ogrenciler ogrenciler) {
		try {
			sessionFactory.getCurrentSession().delete(ogrenciler);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean saveOgrenci(Ogrenciler ogrenciler) {
		sessionFactory.getCurrentSession().save(ogrenciler);
		return true;
	}

	public Ogrenciler getOgrenci(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		// get user
		Ogrenciler ogrenci = (Ogrenciler) session.get(Ogrenciler.class, new Integer(id));
		return ogrenci;
	}

	public void removeOgrenci(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Ogrenciler p = (Ogrenciler) session.load(Ogrenciler.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Ogrenci basariyla silindi. Detaylar=" + p);

	}

	public boolean updateOgrenci(Ogrenciler ogrenciler) {
		sessionFactory.getCurrentSession().update(ogrenciler);
		return true;
	}

}
