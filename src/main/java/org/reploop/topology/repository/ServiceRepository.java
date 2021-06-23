package org.reploop.topology.repository;

import org.reploop.topology.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByNameAndCmd(String name, String cmd);

    List<Service> findByNameAndCmdIsNotNull(String name);

    List<Service> findByCmdIsNotNull();

    List<Service> findByCmd(String cmd);
}