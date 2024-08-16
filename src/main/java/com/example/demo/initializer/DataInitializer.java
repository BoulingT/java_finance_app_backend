package com.example.demo.initializer;

import com.example.demo.entity.expenses.ExpenseType;
import com.example.demo.entity.incomes.IncomeType;
import com.example.demo.repository.expenses.ExpenseTypeRepository;
import com.example.demo.repository.incomes.IncomeTypeRepository;
import com.example.demo.security.entity.User;
import com.example.demo.security.enums.Role;
import com.example.demo.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ExpenseTypeRepository expenseTypeRepository;

    private final IncomeTypeRepository incomeTypeRepository;

    private final UserRepository userRepository;

    public DataInitializer(ExpenseTypeRepository expenseTypeRepository,
                           IncomeTypeRepository incomeTypeRepository,
                           UserRepository userRepository
    ) {
        this.expenseTypeRepository = expenseTypeRepository;
        this.incomeTypeRepository = incomeTypeRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (expenseTypeRepository.count() == 0) {
            expenseTypeRepository.save(new ExpenseType(1L, "Rent"));
            expenseTypeRepository.save(new ExpenseType(2L, "Bill"));
            expenseTypeRepository.save(new ExpenseType(3L, "Subscription"));
            expenseTypeRepository.save(new ExpenseType(4L, "Consumption credit"));
            expenseTypeRepository.save(new ExpenseType(5L, "Consumption budget"));
            expenseTypeRepository.save(new ExpenseType(6L, "Other"));
        }
        if (incomeTypeRepository.count() == 0) {
            incomeTypeRepository.save(new IncomeType(1L, "Salary"));
            incomeTypeRepository.save(new IncomeType(2L, "CAF"));
            incomeTypeRepository.save(new IncomeType(3L, "Refund"));
            incomeTypeRepository.save(new IncomeType(4L, "Refund loan"));
            incomeTypeRepository.save(new IncomeType(5L, "Other"));
        }
        if(userRepository.count() == 0) {
            userRepository.save(new User(1L, "recruiter@gmail.com", "recruiter", Role.USER));
        }
    }
}
