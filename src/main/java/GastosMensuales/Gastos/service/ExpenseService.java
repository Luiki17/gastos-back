package GastosMensuales.Gastos.service;

import GastosMensuales.Gastos.dto.ExpenseDto;
import GastosMensuales.Gastos.mapper.ExpenseMapper;
import GastosMensuales.Gastos.model.Expense;
import GastosMensuales.Gastos.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;
    private final ExpenseMapper mapper;

    public ExpenseService(ExpenseRepository repository, ExpenseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Crear un gasto
    public ExpenseDto createExpense(ExpenseDto dto) {
        Expense expense = mapper.toEntity(dto);
        Expense saved = repository.save(expense);
        return mapper.toDto(saved);
    }

    // Listar todos los gastos
    public List<ExpenseDto> getAllExpenses() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // Listar gastos por mes y año
    public List<ExpenseDto> getExpensesByMonth(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();
        return repository.findByExpenseDateBetween(start, end)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // Buscar gasto por ID
    public Optional<ExpenseDto> getExpenseById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    // Actualizar gasto
    public Optional<ExpenseDto> updateExpense(Long id, ExpenseDto dto) {
        return repository.findById(id).map(existing -> {
            existing.setAmount(dto.getAmount());
            existing.setDescription(dto.getDescription());
            existing.setExpenseDate(LocalDate.parse(dto.getExpenseDate()));
            Expense updated = repository.save(existing);
            return mapper.toDto(updated);
        });
    }

    // Eliminar gasto
    public boolean deleteExpense(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
