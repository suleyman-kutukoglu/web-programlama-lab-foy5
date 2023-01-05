package com.mustafazorbaz.controllers;

import java.util.List;

import com.mustafazorbaz.entities.Ogrenciler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mustafazorbaz.services.OgrenciServices;

@Controller
@RequestMapping(value = "ogrenciler")
public class OgrenciController {

	@Autowired
	OgrenciServices ogrenciServices;
 

	 
	@RequestMapping(value = "/getPageOgrenciAdd", method = RequestMethod.GET)
	private ModelAndView getPageOgrenciAdd() {
		ModelAndView view = new ModelAndView("addOgrenci");
		view.addObject("ogrenci", new Ogrenciler());
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addOgrenci(@ModelAttribute("ogrenci") Ogrenciler ogrenci) {
		ogrenciServices.saveOgrenci(ogrenci);
		return "redirect:/ogrenciler/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOgrenci(@ModelAttribute("ogrenci") Ogrenciler ogrenci) {
		
		
		ogrenciServices.updateOgrenci(ogrenci);
		return "redirect:/ogrenciler/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getAll(Ogrenciler ogrenciler) {
		ModelAndView view = new ModelAndView("homePage");
		List<Ogrenciler> data = ogrenciServices.list();
		view.addObject("datas", data);

		return view;
	}

	@RequestMapping(value = "/ogrenciDelete/{id}")
	public String delete(@PathVariable("id") int id) {
		ogrenciServices.removeOgrenci(id);
		return "redirect:/ogrenciler/list";
	}

	@RequestMapping("/edit/{id}")
	public String editOgrenci(@PathVariable("id") int id, Model model) {
		model.addAttribute("ogrenci", this.ogrenciServices.getOgrenci(id));
		return "editOgrenci";
	}
}
