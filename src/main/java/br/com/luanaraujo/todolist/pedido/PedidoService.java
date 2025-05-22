package br.com.luanaraujo.todolist.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoOrcamentoRepository pedidoOrcamentoRepository;
    private final ItensPedidoOrcamentoRepository itensPedidoOrcamentoRepository;

    @Autowired
    public PedidoService(PedidoOrcamentoRepository pedidoOrcamentoRepository, ItensPedidoOrcamentoRepository itensPedidoOrcamentoRepository) {
        this.pedidoOrcamentoRepository = pedidoOrcamentoRepository;
        this.itensPedidoOrcamentoRepository = itensPedidoOrcamentoRepository;
    }

    /**
     * Fetches all PedidoOrcamento records.
     * @return A list of all PedidoOrcamento.
     */
    public List<PedidoOrcamento> getAllPedidos() {
        return pedidoOrcamentoRepository.findAll();
    }

    /**
     * Fetches a PedidoOrcamento by its ID.
     * @param id The ID of the PedidoOrcamento.
     * @return An Optional containing the PedidoOrcamento if found, or an empty Optional if not.
     */
    public Optional<PedidoOrcamento> getPedidoById(Long id) {
        return pedidoOrcamentoRepository.findById(id);
    }

    /**
     * Fetches all ItensPedidoOrcamento for a given PedidoOrcamento ID.
     * @param pedidoId The ID of the PedidoOrcamento.
     * @return A list of ItensPedidoOrcamento associated with the given PedidoOrcamento ID.
     */
    public List<ItensPedidoOrcamento> getItensByPedidoId(Long pedidoId) {
        return itensPedidoOrcamentoRepository.findByPedidoId(pedidoId);
    }

    /**
     * Fetches all ItensPedidoOrcamento records.
     * @return A list of all ItensPedidoOrcamento.
     */
    public List<ItensPedidoOrcamento> getAllItens() {
        return itensPedidoOrcamentoRepository.findAll();
    }

    /**
     * Fetches an ItensPedidoOrcamento by its ID.
     * @param id The ID of the ItensPedidoOrcamento.
     * @return An Optional containing the ItensPedidoOrcamento if found, or an empty Optional if not.
     */
    public Optional<ItensPedidoOrcamento> getItemById(Long id) {
        return itensPedidoOrcamentoRepository.findById(id);
    }
}
