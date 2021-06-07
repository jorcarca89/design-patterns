package cl.jorcarca.designpatterns.behavioral.memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.base.Objects;

public class CurrentAccount implements Snapshotable {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private String currency;
    private Integer initialAmount;
    private Integer currentAmount;
    private List<Integer> transactions;
    private boolean blocked;

    public CurrentAccount(String currency, Integer initialAmount) {
        this.currency = currency;
        this.initialAmount = initialAmount;
        this.transactions = new ArrayList<>();
        currentAmount = initialAmount;
        blocked = true;
    }

    @Override
    public Snapshot takeSnapshot() {
        logger.info("Taking snapshot");
        return new CurrentAccountSnapshot(this);
    }

    public Integer addTransaction(Integer amount) {
        logger.log(Level.INFO, "Adding transaction to transaction list: {0}", amount);
        currentAmount += amount;
        transactions.add(amount);
        return currentAmount;
    }

    public void blockAccount() {
        logger.info("Blocking account");
        this.blocked = true;
    }

    public void unblockAccount() {
        logger.info("Unblocking account");
        this.blocked = false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Integer getInitialAmount() {
        return this.initialAmount;
    }

    public Integer getCurrentAmount() {
        return this.currentAmount;
    }

    public List<Integer> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CurrentAccount)) {
            return false;
        }
        CurrentAccount currentAccount = (CurrentAccount) o;
        return currency.equals(currentAccount.currency) && initialAmount.equals(currentAccount.initialAmount)
                && currentAmount.equals(currentAccount.currentAmount)
                && transactions.equals(currentAccount.transactions) && blocked == currentAccount.blocked;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currency, initialAmount, currentAmount, transactions, blocked);
    }

    @Override
    public String toString() {
        return "{" + " currency='" + getCurrency() + "'" + ", initialAmount='" + getInitialAmount() + "'"
                + ", currentAmount='" + getCurrentAmount() + "'" + ", transactions='" + getTransactions() + "'"
                + ", blocked='" + isBlocked() + "'" + "}";
    }

    public class CurrentAccountSnapshot extends BaseSnapshot {
        private final String currency;
        private final Integer initialAmount;
        private final Integer currentAmount;
        private final List<Integer> transactions;
        private final boolean blocked;

        public CurrentAccountSnapshot(CurrentAccount currentAccount) {
            super(new SnapshotMetadata("CurrentAccountSnapshot", currentAccount.toString()));

            logger.log(Level.INFO, "Creating snapshot from object: {0}", currentAccount);

            currency = currentAccount.getCurrency();
            initialAmount = currentAccount.getInitialAmount();
            currentAmount = currentAccount.getCurrentAmount();
            transactions = new ArrayList<>(currentAccount.getTransactions());
            blocked = currentAccount.isBlocked();

            logger.log(Level.INFO, "Snapshot created with metadata: {0}", this.getMetadata());
        }

        @Override
        public void restore() {
            logger.log(Level.INFO, "Restoring snapshot, current state: {0}", CurrentAccount.this);
            CurrentAccount.this.currency = currency;
            CurrentAccount.this.initialAmount = initialAmount;
            CurrentAccount.this.currentAmount = currentAmount;
            CurrentAccount.this.transactions = transactions;
            CurrentAccount.this.blocked = blocked;
            logger.log(Level.INFO, "Restored snapshot: {0}", CurrentAccount.this);
        }

        @Override
        public String toString() {
            return "{" + " currency='" + getCurrency() + "'" + ", initialAmount='" + getInitialAmount() + "'"
                    + ", currentAmount='" + getCurrentAmount() + "'" + ", transactions='" + getTransactions() + "'"
                    + ", blocked='" + isBlocked() + "'" + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof CurrentAccountSnapshot)) {
                return false;
            }
            CurrentAccountSnapshot currentAccountSnapshot = (CurrentAccountSnapshot) o;
            return this.getMetadata().equals(currentAccountSnapshot.getMetadata())
                    && currency.equals(currentAccountSnapshot.currency)
                    && initialAmount.equals(currentAccountSnapshot.initialAmount)
                    && currentAmount.equals(currentAccountSnapshot.currentAmount)
                    && transactions.equals(currentAccountSnapshot.transactions)
                    && blocked == currentAccountSnapshot.blocked;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.getMetadata(), currency, initialAmount, currentAmount, transactions, blocked);
        }
    }

}
