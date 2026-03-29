package com.cognis.buildup_api.core.obra.obraPropietarios;

import com.cognis.buildup_api.core.BaseEntity;
import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.obra.Obra;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class ObraProprietarios extends BaseEntity {

        @ManyToOne
        @JoinColumn(name = "id_obra")
        private Obra obra;
        @OneToOne
        @JoinColumn(name = "id_cliente")
        private Cliente cliente;
}
