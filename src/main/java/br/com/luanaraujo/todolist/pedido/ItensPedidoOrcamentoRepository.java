package br.com.luanaraujo.todolist.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItensPedidoOrcamentoRepository extends JpaRepository<ItensPedidoOrcamento, Long> {

    List<ItensPedidoOrcamento> findByPedidoId(Long pedidoId);
}
