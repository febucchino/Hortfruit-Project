package com.example.hortfruit.repository.address;

import com.example.hortfruit.model.customer.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(name = "select * from cliente c, endereco e where e.id_cliente = 1 and e.id_cliente = c.id_cliente")
    Address findAddressByCustomerId(Long id);
}
