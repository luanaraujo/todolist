package br.com.luanaraujo.todolist.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoOrcamentoRepository extends JpaRepository<PedidoOrcamento, Long> {
}
