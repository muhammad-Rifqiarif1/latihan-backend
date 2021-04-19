package com.latihan.TableSiswa.controller;

import com.latihan.TableSiswa.entity.SiswaEntity;
import com.latihan.TableSiswa.service.SiswaService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SiswaController {

    @Autowired
    private SiswaService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<SiswaEntity> siswaEntity = service.listAll();
        model.addAttribute("siswaEntity",siswaEntity);

        return "index";
    }

    @RequestMapping("/new")
    public String addNewHomePage(Model model) {
        SiswaEntity siswaEntity = new SiswaEntity();
        model.addAttribute("siswaEntity",siswaEntity);

        return "tambah_siswa";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public String simpanSiswa(@ModelAttribute("siswaEntity") SiswaEntity siswaEntity) {
        service.addNew(siswaEntity);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView addEditHomePage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("siswa");
        SiswaEntity siswaEntity = service.getById(id);
        mav.addObject("siswaEntity",siswaEntity);

        return mav;
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteSiswa(@PathVariable(name = "id") long id) {
        service.delete(id);

        return "redirect:/";
    }



}
