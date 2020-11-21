import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accounts;
   
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
   
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
   
    public void printBankDetails() {
        System.out.println("bank name: "+ bankName);
        System.out.println("----------accounts details--------");
        accounts.forEach(a-> System.out.println(a));
    }
   
}