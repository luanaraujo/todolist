package br.com.luanaraujo.todolist.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Lists all orders (PEDIDOORCAMENTO).
     * @return ResponseEntity containing a list of PedidoOrcamento and HttpStatus.OK.
     */
    @GetMapping
    public ResponseEntity<List<PedidoOrcamento>> getAllPedidos() {
        List<PedidoOrcamento> pedidos = pedidoService.getAllPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    /**
     * Gets a specific order by ID.
     * @param id The ID of the PedidoOrcamento.
     * @return ResponseEntity containing the PedidoOrcamento if found (HttpStatus.OK), 
     *         or HttpStatus.NOT_FOUND if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PedidoOrcamento> getPedidoById(@PathVariable Long id) {
        Optional<PedidoOrcamento> pedido = pedidoService.getPedidoById(id);
        return pedido.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                     .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Gets all items for a specific order.
     * @param pedidoId The ID of the PedidoOrcamento.
     * @return ResponseEntity containing a list of ItensPedidoOrcamento and HttpStatus.OK.
     */
    @GetMapping("/{pedidoId}/itens")
    public ResponseEntity<List<ItensPedidoOrcamento>> getItensByPedidoId(@PathVariable Long pedidoId) {
        List<ItensPedidoOrcamento> itens = pedidoService.getItensByPedidoId(pedidoId);
        // Assuming service returns empty list if order not found or no items.
        // If we need to check if the order itself exists and return 404,
        // we'd need an additional check here (e.g., pedidoService.getPedidoById(pedidoId).isPresent())
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    /**
     * Lists all order items (ITENSPEDIDOORCAMENTO).
     * @return ResponseEntity containing a list of ItensPedidoOrcamento and HttpStatus.OK.
     */
    @GetMapping("/itens")
    public ResponseEntity<List<ItensPedidoOrcamento>> getAllItens() {
        List<ItensPedidoOrcamento> itens = pedidoService.getAllItens();
        return new ResponseEntity<>(itens, HttpStatus.OK);
    }

    /**
     * Gets a specific order item by ID.
     * @param id The ID of the ItensPedidoOrcamento.
     * @return ResponseEntity containing the ItensPedidoOrcamento if found (HttpStatus.OK),
     *         or HttpStatus.NOT_FOUND if not found.
     */
    @GetMapping("/itens/{id}")
    public ResponseEntity<ItensPedidoOrcamento> getItemById(@PathVariable Long id) {
        Optional<ItensPedidoOrcamento> item = pedidoService.getItemById(id);
        return item.map(i -> new ResponseEntity<>(i, HttpStatus.OK))
                   .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
