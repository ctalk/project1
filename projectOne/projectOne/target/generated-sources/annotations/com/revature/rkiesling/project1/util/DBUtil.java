package com.revature.rkiesling.project1.util;

import com.revature.rkiesling.project1.util.UserTable;
import com.revature.rkiesling.project1.util.JDBCConnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil implements UserTable {

    public static boolean haveSchema () {
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        boolean returnVal = false;
        String sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = ?";
        try {
            c = JDBCConnection.getJDBCConnection ();
            p = c.prepareStatement(sql);
            p.setString(1, UserTable.schemaName);
            r = p.executeQuery ();
            if (r.next ()) {
                returnVal = true;
            } else {
                returnVal = false;
            }
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
        JDBCConnection.closeAll (c, p, r);
        return returnVal;
    }

    public static String makeSchema () {
        Connection c = null;
        String sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = ?";
        PreparedStatement p = null;
        ResultSet r = null;
        String out = "";
        try {
            c = JDBCConnection.getJDBCConnection ();
            p = c.prepareStatement(sql);
            p.setString(1, UserTable.schemaName);
            r = p.executeQuery ();
            if (!r.next ()) {
                out = "Schema, \"" + UserTable.schemaName +
                    ",\" not found - creating...<br>";
                sql = "create schema " + UserTable.schemaName;
                p = c.prepareStatement (sql);
                p.executeUpdate ();
            }
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
            out += " " + e.getMessage () + "<br>";
        } finally {
            JDBCConnection.closeAll (c, p, r);
        }
        return out;
    }

    public static String makeTables () {

        String out = "";
        Connection c = null;
        String sqlUser = "drop table if exists " + UserTable.tableName;
        PreparedStatement p = null;
        StringBuffer query = new StringBuffer (1024);

        try {
            c = JDBCConnection.getJDBCConnection ();
                        
            // Default is: "drop table if exists bank_app.users"
            p = c.prepareStatement(sqlUser);
            try {
                p.executeUpdate ();
                out = "Removing old user table if needed...<br>";
            } catch (SQLException e) {
                out += e.getMessage () + ".<br>";
            }

            //
            // create table SQL: see UserTable.java.
            //
                
            query.insert(0, "create table " +
                         UserTable.tableName + " (");
            for (String spec: UserTable.colDefs) {
                query.append(spec);
            }
            p = c.prepareStatement(query.toString());
            try {
                p.executeUpdate ();
                out += "Created User table...<br>";
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        } catch (SQLException e) {
            out += e.getMessage () + ".<br>";
        }
        JDBCConnection.closeAll (c, p);
        return out;
    }
                // reportSQLException ("makeBankTables: " + query.toString () + " : ", e);
            // out += e.getMessage () + ".<br>";
            // }
                        
            // Now create bank_app.transactions
            //      String sqlTrans = "drop table if exists " + TransactionTable.transactionTableName;
            //      PreparedStatement pTrans = conTable.prepareStatement(sqlTrans);
            // try {
            //          pTrans.executeUpdate ();
            //          log.info("makeBankTables: removed old " + TransactionTable.transactionTableName + ".");
            // } catch (SQLException e) {
            //          reportSQLException ("makeBankTables: " + sqlTrans + " : ", e);
            //      }
            //      StringBuffer queryTrans = new StringBuffer (1024);
            //      queryTrans.insert(0, "create table " + TransactionTable.transactionTableName + " (");
            //      for (String spec: TransactionTable.colDefs) {
            //          queryTrans.append(spec);
            //      }
                        
            //      pTrans = conTable.prepareStatement(queryTrans.toString());
            //      try {
            //          pTrans.executeUpdate ();
            //          log.info("makeBankTables: created " + TransactionTable.transactionTableName + " table.");
            //      } catch (SQLException e) {
            //          reportSQLException ("makeBankTables: " + queryTrans.toString () + " : ", e);
            //      }

            // Now create bank_app.balances
            //      String sqlBalance = "drop table if exists " + BalanceTable.balanceTableName;
            //      PreparedStatement pBal = conTable.prepareStatement(sqlBalance);
            //      try {
            //          pBal.executeUpdate ();
            //          log.info("makeBankTables: removed old " + BalanceTable.balanceTableName + ".");
            //      } catch (SQLException e) {
            //          reportSQLException ("makeBankTables: " + sqlBalance + " : ", e);
            //      }
            //      StringBuffer queryBalance = new StringBuffer (1024);
            //      queryBalance.insert(0, "create table " + BalanceTable.balanceTableName + " (");
            //      for (String spec: BalanceTable.colDefs) {
            //          queryBalance.append(spec);
            //      }
                        
            //      pBal = conTable.prepareStatement(queryBalance.toString());
            //      try {
            //          pBal.executeUpdate ();
            //          log.info("makeBankTables: created " + BalanceTable.balanceTableName + " table.");
            //      } catch (SQLException e) {
            //          reportSQLException ("makeBankTables: " + queryBalance.toString () + " : ", e);
            //      }
            
            //      JDBCConnection.close (conTable);
            
            //  } catch (SQLException e) {
            //      reportSQLException ("makeBankTables: ", e);
            //  }
        
            // }
        
}
