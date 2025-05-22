package br.com.luanaraujo.todolist.pedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "PEDIDOORCAMENTO")
public class PedidoOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroPedido;

    private LocalDateTime dataPedido;

    private Double valorTotal;

    private String clienteNome;

    // Assuming column names match field names. If not, @Column would be needed.
    // e.g., @Column(name = "NUMERO_PEDIDO")

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensPedidoOrcamento> itens;
}
