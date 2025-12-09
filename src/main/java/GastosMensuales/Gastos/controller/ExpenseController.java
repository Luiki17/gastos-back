package GastosMensuales.Gastos.controller;

import GastosMensuales.Gastos.dto.ExpenseDto;
import GastosMensuales.Gastos.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    // Crear un gasto
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@Valid @RequestBody ExpenseDto dto) {
        ExpenseDto created = service.createExpense(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Listar todos los gastos
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month
    ) {
        List<ExpenseDto> expenses;
        if (year != null && month != null) {
            expenses = service.getExpensesByMonth(year, month);
        } else {
            expenses = service.getAllExpenses();
        }
        return ResponseEntity.ok(expenses);
    }

    // Obtener gasto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        return service.getExpenseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar gasto
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseDto dto
    ) {
        return service.updateExpense(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar gasto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        boolean deleted = service.deleteExpense(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
