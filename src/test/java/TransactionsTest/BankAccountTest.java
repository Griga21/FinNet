package TransactionsTest;

import com.Main;
import com.entity.BankAccount;
import com.repository.BankAccountRepository;
import com.service.bankaccountservice.BankAccountService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = Main.class)
@Transactional
public class BankAccountTest {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    public void shouldSaveBankAccountAndFindById(){
        Long bankAccountId = bankAccountService.createBankAccount();
        BankAccount bankAccount = bankAccountService.getBankAccountById(bankAccountId);
        assertThat(bankAccount).isNotNull();
    }
}
