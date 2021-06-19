package com.cclx.topology.repository;

import com.cclx.topology.model.Proc;
import com.cclx.topology.model.Server;
import com.cclx.topology.model.ServerPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ServerPortRepository extends JpaRepository<ServerPort, Long> {

    List<ServerPort> findByServer(Server server);

    List<ServerPort> findByProcess(Proc process);

    List<ServerPort> findByProcessIn(Collection<Proc> processes);

    ServerPort findByServerAndPort(Server server, Integer port);
}
