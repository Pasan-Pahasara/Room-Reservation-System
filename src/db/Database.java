package db;

import model.Customer;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerTable = new ArrayList();

    static {
        customerTable.add(
                new Customer("R001","Hasika","70528899V","0715588965","hasi@gmail.com","Panadura","Yes")
        );
        customerTable.add(
                new Customer("R002","Maneesha","70745899V","0452688965","mani@gmail.com","Galle","Yes")
        );
    }
}
