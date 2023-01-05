package com.mustafazorbaz.services;

import java.util.List;

import com.mustafazorbaz.entities.Ogrenciler;

public interface OgrenciServices {
	public List<Ogrenciler> list();

	public boolean delete(Ogrenciler ogrenciler);

	public boolean saveOgrenci(Ogrenciler ogrenciler);

	public boolean updateOgrenci(Ogrenciler ogrenciler);

	public Ogrenciler getOgrenci(int id);

	public void removeOgrenci(int id);
}
