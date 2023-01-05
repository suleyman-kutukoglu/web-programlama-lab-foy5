package com.mustafazorbaz.dao;

import java.util.List;

import com.mustafazorbaz.entities.Ogrenciler;

public interface OgrenciDao {
	public List<Ogrenciler> list();

	public boolean delete(Ogrenciler ogrenciler);

	public Ogrenciler getOgrenci(int id);

	public void removeOgrenci(int id);

	public boolean saveOgrenci(Ogrenciler ogrenciler);

	public boolean updateOgrenci(Ogrenciler ogrenciler);

}
