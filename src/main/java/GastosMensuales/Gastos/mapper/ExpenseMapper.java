package GastosMensuales.Gastos.mapper;

import GastosMensuales.Gastos.dto.ExpenseDto;
import GastosMensuales.Gastos.model.Expense;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ExpenseMapper {

    // Convierte de entidad a DTO
    public ExpenseDto toDto(Expense expense) {
        if (expense == null) return null;
        return ExpenseDto.builder()
                .id(expense.getId())
                .amount(expense.getAmount())
                .description(expense.getDescription())
                .expenseDate(expense.getExpenseDate().toString())
                .build();
    }

    // Convierte de DTO a entidad
    public Expense toEntity(ExpenseDto dto) {
        if (dto == null) return null;
        Expense expense = new Expense();
        expense.setId(dto.getId());
        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setExpenseDate(LocalDate.parse(dto.getExpenseDate()));
        return expense;
    }

}
