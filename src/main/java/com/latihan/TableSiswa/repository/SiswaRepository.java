package com.latihan.TableSiswa.repository;

import com.latihan.TableSiswa.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends JpaRepository<SiswaEntity,Long> {

}
