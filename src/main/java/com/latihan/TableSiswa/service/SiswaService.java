package com.latihan.TableSiswa.service;

import com.latihan.TableSiswa.entity.SiswaEntity;
import com.latihan.TableSiswa.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class SiswaService {

    @Autowired
    SiswaRepository siswaRepository;

    public void addNew(SiswaEntity param) {
        siswaRepository.save(param);
    }

    public void delete(Long id) {
        siswaRepository.deleteById(id);
    }

    public List<SiswaEntity> listAll() {
        return siswaRepository.findAll();
    }

    public SiswaEntity getById(Long id) {
        return siswaRepository.findById(id).get();
    }

}
