package com.mustafazorbaz.servicesImpl;

import java.util.List;

import com.mustafazorbaz.entities.Ogrenciler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafazorbaz.dao.OgrenciDao;
import com.mustafazorbaz.services.OgrenciServices;

@Service
public class OgrenciServicesImpl implements OgrenciServices {

	@Autowired
	OgrenciDao ogrenciDao;

	public List<Ogrenciler> list() {
		return ogrenciDao.list();
	}

	public boolean delete(Ogrenciler ogrenciler) {
		return ogrenciDao.delete(ogrenciler);
	}

	public boolean saveOgrenci(Ogrenciler ogrenciler) {
		return ogrenciDao.saveOgrenci(ogrenciler);
	}

	public Ogrenciler getOgrenci(int id) {
		return ogrenciDao.getOgrenci(id);
	}

	public void removeOgrenci(int id) {
		ogrenciDao.removeOgrenci(id);

	}

	public boolean updateOgrenci(Ogrenciler ogrenciler) {
		return ogrenciDao.updateOgrenci(ogrenciler);
	}

}
