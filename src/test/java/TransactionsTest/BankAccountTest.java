package TransactionsTest;

import com.Main;
import com.dto.BankAccountDTO;
import com.repository.BankAccountRepository;
import com.service.bankaccountservice.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = Main.class)
@Transactional
public class BankAccountTest {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    public void shouldSaveBankAccountAndFindById() {
//        Long bankAccountId = bankAccountService.createBankAccount();
//        BankAccountDTO bankAccountDTO = bankAccountService.getBankAccountById(bankAccountId);
//        assertThat(bankAccountDTO).isNotNull();
    }
}
