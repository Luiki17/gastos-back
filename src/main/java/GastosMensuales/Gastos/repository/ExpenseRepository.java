package GastosMensuales.Gastos.repository;

import GastosMensuales.Gastos.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Método personalizado para listar gastos por mes y año
    List<Expense> findByExpenseDateBetween(LocalDate start, LocalDate end);

}
