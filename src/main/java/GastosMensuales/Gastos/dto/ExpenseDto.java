package GastosMensuales.Gastos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDto {

    private Long id; //Para el ID generado automáticamente

    @NotNull
    @Positive
    private BigDecimal amount; // Dinero

    @NotNull
    private String description; // Concepto

    @NotNull
    private String expenseDate; // Fecha en formato "yyyy-MM-dd"
}
