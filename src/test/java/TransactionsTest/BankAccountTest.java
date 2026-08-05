package TransactionsTest;

import com.Main;
import com.dto.BankAccountResponse;
import com.dto.CreateBankAccountRequest;
import com.entity.AccountStatus;
import com.entity.BankAccount;
import com.mapper.BankAccountMapper;
import com.repository.BankAccountRepository;
import com.service.bankaccountservice.BankAccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = Main.class)
@Transactional
public class BankAccountTest {

    @Mock
    private BankAccountRepository bankAccountRepository;

    @Mock
    private BankAccountMapper bankAccountMapper;

    @InjectMocks
    private BankAccountServiceImpl bankAccountService;

    private CreateBankAccountRequest request;
    private BankAccount bankAccount;
    private BankAccount savedAccount;
    private BankAccountResponse response;

    @BeforeEach
    void setUp() {
        // 1. Подготовка тестовых данных
        request = new CreateBankAccountRequest();
        request.setAccountNumber("1234567890");
        request.setAccountBalance(BigDecimal.valueOf(1000.50));
        request.setStatus(AccountStatus.ACTIVE);

        bankAccount = new BankAccount();
        bankAccount.setAccountNumber("1234567890");
        bankAccount.setAccountBalance(BigDecimal.valueOf(1000.50));
        bankAccount.setStatus(AccountStatus.ACTIVE);

        savedAccount = new BankAccount();
        savedAccount.setAccountNumber("1234567890");
        savedAccount.setAccountBalance(BigDecimal.valueOf(1000.50));
        savedAccount.setStatus(AccountStatus.ACTIVE);
        savedAccount.setCreatedAt(Instant.now());

        response = new BankAccountResponse();
        response.setAccountNumber("1234567890");
        response.setAccountBalance(BigDecimal.valueOf(1000.50));
    }

    @Test
    @DisplayName("Успешное создание счета")
    void createBankAccount_Success() {
        // Arrange (Подготовка)
        when(bankAccountRepository.existsByAccountNumber(request.getAccountNumber()))
                .thenReturn(false);

        when(bankAccountMapper.toEntity(request))
                .thenReturn(bankAccount);

        when(bankAccountRepository.save(any(BankAccount.class)))
                .thenReturn(savedAccount);

        when(bankAccountMapper.toResponse(savedAccount))
                .thenReturn(response);

        // Act (Выполнение)
        BankAccountResponse result = bankAccountService.createBankAccount(request);

        // Assert (Проверка)
        assertThat(result).isNotNull();
        assertThat(result.getAccountNumber()).isEqualTo("1234567890");
        assertThat(result.getAccountBalance()).isEqualByComparingTo("1000.50");

        // Проверка вызовов методов
        verify(bankAccountRepository).existsByAccountNumber(request.getAccountNumber());
        verify(bankAccountMapper).toEntity(request);
        verify(bankAccountRepository).save(any(BankAccount.class));
        verify(bankAccountMapper).toResponse(savedAccount);
    }
}
