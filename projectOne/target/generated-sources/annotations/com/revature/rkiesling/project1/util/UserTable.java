package com.revature.rkiesling.project1.util;

import java.util.Arrays;
import java.util.ArrayList;

public interface UserTable {
    public static final String schemaName = "expenses";
    public static final String tableName = "expenses.users";
        
    public static final ArrayList<String> colNames =
        new ArrayList <> (Arrays.asList 
                          ("firstname",
                           "lastname",
                           "userid",
                           "password",
                           "ssn",
                           "role"));
    // Used when we construct the query to create the
    // table.
    public static final ArrayList<String> colDefs =
        new ArrayList <> (Arrays.asList
                          ("id serial primary key not null,",
                           "firstname varchar(64) not null,",
                           "lastname varchar (64) not null,",
                           "userid varchar (64) not null unique,",
                           "password varchar (64) not null,",
                           "ssn varchar (12) not null,",
                           "role int not null)"));
}
