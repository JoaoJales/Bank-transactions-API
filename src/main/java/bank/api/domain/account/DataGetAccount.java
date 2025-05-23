package bank.api.domain.account;

import java.math.BigDecimal;

public record DataGetAccount(Long id, String numero, BigDecimal saldo, TypeAccount tipo) {
    public DataGetAccount(Account account){
        this(account.getId(), account.getNumero(), account.getSaldo(), account.getTipo());
    }
}
