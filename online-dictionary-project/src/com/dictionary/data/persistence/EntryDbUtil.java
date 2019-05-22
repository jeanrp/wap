package com.dictionary.data.persistence;

import com.dictionary.data.configuration.DbConnection;
import com.dictionary.model.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntryDbUtil {
    private DbConnection dataSource;

    public EntryDbUtil(DbConnection dataSource) {
        this.dataSource = dataSource;
    }

    public Entry getEntryByWord(String wordEntry) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try
        {
            myConn = dataSource.getConnection();
            String sql = "SELECT * from entries WHERE word = ?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, wordEntry);

            myRs = myStmt.executeQuery();

            Entry entry = null;

            boolean firstTime = true;
            List<String> wordTypeList = new ArrayList<>();
            List<String> definitionList = new ArrayList<>();

            while (myRs.next())
            {
                String word = myRs.getString("word");
                String wordType = myRs.getString("wordtype");
                String definition = myRs.getString("definition");

                if (firstTime)
                {
                    wordTypeList.add(wordType);
                    definitionList.add(definition);
                    entry = new Entry(word, wordTypeList, definitionList);
                    firstTime = false;
                }else
                {
                    entry.getDefinitionList().add(definition);
                    entry.getWordTypeList().add(wordType);
                }
            }

            return entry;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            close(myConn, myStmt, myRs);
        }

        return null;
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try
        {
            if (myRs != null)
                myRs.close();

            if (myStmt != null)
                myStmt.close();

            if (myConn != null)
                myConn.close();
        } catch (Exception e)
        {
            // TODO: handle exception
        }
    }
}
