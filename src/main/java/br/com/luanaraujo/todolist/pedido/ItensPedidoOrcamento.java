package br.com.luanaraujo.todolist.pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ITENSPEDIDOORCAMENTO")
public class ItensPedidoOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoProduto;

    private String descricaoProduto;

    private Integer quantidade;

    private Double precoUnitario;

    private Double precoTotalItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_orcamento_id") // Assuming this FK column name
    private PedidoOrcamento pedido;
}
