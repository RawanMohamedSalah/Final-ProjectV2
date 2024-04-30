package core;
import java.util.List;

public interface TransactionDao {
    List<Transactions> getAllTransactions() throws Exception;
}
