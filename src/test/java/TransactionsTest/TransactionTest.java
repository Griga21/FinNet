package TransactionsTest;

import com.dto.CreateTransactionRequest;
import com.entity.BankAccount;
import com.entity.Transaction;
import com.entity.TransactionType;
import com.repository.BankAccountRepository;
import com.repository.TransactionRepository;
import com.service.TransactionService;
import com.service.TransactionsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) // включает моки
public class TransactionTest {

    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private BankAccountRepository bankAccountRepository;
    @InjectMocks
    private TransactionsServiceImpl transactionService;

    @Test
    void createTransaction_shouldSaveAndReturnId() {
        Long fromAccountId = 1L;
        Long toAccountId = 2L;
        BigDecimal amount = new BigDecimal("100.00");

        BankAccount fromAccount = new BankAccount();
        ReflectionTestUtils.setField(fromAccount, "id", fromAccountId);
        fromAccount.setAccountBalance(new BigDecimal("1000.00"));

        BankAccount toAccount = new BankAccount();
        ReflectionTestUtils.setField(toAccount, "id", toAccountId);
        toAccount.setAccountBalance(new BigDecimal("500.00"));

        CreateTransactionRequest request = new CreateTransactionRequest();
        request.setAmount(amount);
        request.setType(TransactionType.ENROLLMENT);
        request.setFromAccountId(fromAccountId);
        request.setToAccountId(toAccountId);

        when(bankAccountRepository.findById(fromAccountId))
                .thenReturn(Optional.of(fromAccount));
        when(bankAccountRepository.findById(toAccountId))
                .thenReturn(Optional.of(toAccount));

        when(transactionRepository.save(any(Transaction.class)))
                .thenAnswer(invocation -> {
                    Transaction tx = invocation.getArgument(0);
                    ReflectionTestUtils.setField(tx, "id", 100L);
                    return tx;
                });

        // Act
        Long transactionId = transactionService.createTransaction(request);

        // Assert
        assertThat(transactionId).isNotNull();
        assertThat(transactionId).isEqualTo(100L);

        verify(bankAccountRepository).findById(1L); // ровно 1 раз
        verify(bankAccountRepository).findById(2L); // ровно 1 раз
    }
}
