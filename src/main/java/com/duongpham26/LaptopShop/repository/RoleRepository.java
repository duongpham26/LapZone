package com.duongpham26.LaptopShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duongpham26.LaptopShop.domain.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{   

   Role findByName(String name);

}
